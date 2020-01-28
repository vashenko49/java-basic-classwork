package homework;

import java.util.HashMap;
import java.util.Map;

public class DocumentProcessor {

    //Boyer–Moore string-search algorithm. Found in my old drafts =)
    public static int score(String word, Document document) {
        int count = 0;
        if (document == null) {
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

    public static Map<String, Integer> getCountWords(Document document) {
        //удаляем всю пунктуацию
        String test = document.getText().replace("\\W", "");

        String[] wordsArray = test.split("\\s+");

        Map<String, Integer> countWords = new HashMap<String, Integer>();
        for (String word : wordsArray) {
            if (countWords.containsKey(word)) {
                int value = countWords.get(word);
                countWords.put(word, ++value);

            } else {
                countWords.put(word, 1);
            }
        }
        return countWords;
    }
}
