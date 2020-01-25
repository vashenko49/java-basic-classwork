package classwork3;

import java.util.Random;

public class classwork {
    public static void main(String[] args) {
//        String[] gogo = new String[]{"sf", "32", "sd", "w"};
//        for (String s : gogo) {
//            System.out.println(isDigit(s));
//        }


//        String text = "hello dan.it";
//
//        System.out.println(isWordExistsInText(text, "dan"));


        Random random = new Random();

        CustomList customList = new CustomList();
        for (int i =0;i<1000;i++){
            customList.add(random.nextInt(1000));
        }
        customList.print();
    }

    public static boolean isDigit(String value) {
        return value.matches("\\d+");
    }

    public static boolean isWordExistsInText(String text, String word) {
        return text.matches(".*"+word+".*");
    }
}
