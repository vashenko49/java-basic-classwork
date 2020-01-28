import java.util.HashMap;
import java.util.Map;

public class DocumentProcessor {
    private static final int LENGTH_ARRAY_COUNT_WORDS = 12;

    //Boyer–Moore string-search algorithm. Found in my old drafts =)
    public static int score(String word, Document document) {
        int count = 0;
        if (document == null) {
            return count;
        }
        if (document.getText() == null) {
            return count;
        }
        int indexShift = word.length() - 1;
        int positionInTable = word.length() - 1;
        while (indexShift < document.getText().length()) {
            if (word.charAt(positionInTable) == document.getText().charAt(indexShift)) {
                if (positionInTable == 0) {
                    count++;
                    indexShift = indexShift + word.length() + 1;
                    positionInTable = word.length() - 1;
                } else {
                    indexShift--;
                    positionInTable--;
                }
            } else {
                indexShift = indexShift + word.length() - Math.min(positionInTable, (1 + indexShift(document.getText().charAt(indexShift), word)));
                positionInTable = word.length() - 1;
            }
        }

        return count;
    }

    private static int indexShift(char c, String pattern) {
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public static int score(String word, Document... documents) {
        int sumCount = 0;
        for (Document document : documents) {
            sumCount += score(word, document);
        }
        return sumCount;
    }

    public static boolean equal(Document document1, Document document2) {
        if (document1 == null || document2 == null) {
            return false;
        }
        return document1.getText().equals(document2.getText());
    }

    public static String[][] getCountWords(Document document) {
        String editedText = document.getText().replace("\\W", "");

        String[] wordsArray = editedText.split("[\\s]+");

        int indexCountWords = 0;
        String[][] countWords = new String[LENGTH_ARRAY_COUNT_WORDS][2];

        for (String word : wordsArray) {
            int indexWordInCountWords = findWordInArrayByIndex(word, countWords);
            if (indexWordInCountWords < 0) {
                if (countWords.length * 0.8 < indexCountWords) {
                    countWords = expandArray(countWords);
                }
                countWords[indexCountWords][0] = word;
                countWords[indexCountWords][1] = "1";
                indexCountWords++;
            } else {
                int count = Integer.parseInt(countWords[indexWordInCountWords][1]);
                countWords[indexWordInCountWords][1] = Integer.toString(++count);
            }
        }
        return trimNullElementArray(countWords);
    }

    private static String[][] trimNullElementArray(String[][] values) {
        int countNotNull = 0;
        int indexArray = 0;
        for (String[] value : values) {
            if (value[0] != null) {
                countNotNull++;
            }
        }
        String[][] newArrayWithoutNull = new String[countNotNull][2];
        for (String[] value : values) {
            if (value[0] != null) {
                System.arraycopy(value, 0, newArrayWithoutNull[indexArray], 0, value.length);
                indexArray++;
            }
        }
        return newArrayWithoutNull;
    }

    private static int findWordInArrayByIndex(String word, String[][] countWords) {
        for (int i = 0; i < countWords.length; i++) {
            if (countWords[i][0] == null) {
                break;
            }
            if (countWords[i][0].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private static String[][] expandArray(String[][] countWords) {
        String[][] newArray = new String[LENGTH_ARRAY_COUNT_WORDS * 2][2];
        for (int i = 0; i < countWords.length; i++) {
            System.arraycopy(countWords[i], 0, newArray[i], 0, countWords[i].length);
        }
        return newArray;
    }
}
