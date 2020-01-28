public class Main {
    public static void main(String[] args) {
        Document document = new Document("g ogo googo gogo gogo googo jdsgn gogo jdsgn gogo jdsgn googo googo", "Gogovich");
        Document document1 = new Document("gogo gogo,$%^& gogo googo jdsgn gogo", "Gogovich1");
        Document document2 = document1;

        System.out.println(document.getAuthor());
        System.out.println(document.getTimeStamp());

        System.out.println("< -------------------- >");

        System.out.println(document.getText());
        System.out.println("version: " + document.getVersion());
        document.changeText("g ogo googo gogo gogo googo jdsgn gogo jdsgn gogo jdsgn googo googo g ogo googo gogo gogo googo jdsgn gogo jdsgn gogo jdsgn googo googo a s d f g h j k l q w e r t y u i o");
        System.out.println(document.getText());
        System.out.println("version: " + document.getVersion());

        System.out.println("< -------------------- >");

        System.out.println(DocumentProcessor.score("gogo", document));
        System.out.println(DocumentProcessor.score("gogo", document, document1));
        System.out.println(DocumentProcessor.equal(document, document1));
        System.out.println(DocumentProcessor.equal(document1, document2));
        String[][] countWords = DocumentProcessor.getCountWords(document);

        System.out.println("< -------------------- >");
        for (String[] value : countWords) {
            System.out.println(value[0] + " = " + value[1]);
        }
    }
}
