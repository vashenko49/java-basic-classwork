package homework;

public class Main {
    public static void main(String[] args) {
        Document document = new Document("g ogo googo gogo gogo googo jdsgn gogo jdsgn gogo jdsgn googo googo", "Gogovich");
        Document document1 = new Document("gogo gogo,$%^& gogo googo jdsgn gogo", "Gogovich1");

        System.out.println(document.getAuthor());
        System.out.println(document.getTimeStamp());

        System.out.println("< -------------------- >");

        System.out.println(document.getText());
        System.out.println("version: " + document.getVersion());
        document.setText("g ogo googo gogo gogo googo jdsgn gogo jdsgn gogo jdsgn googo googo g ogo googo gogo gogo googo jdsgn gogo jdsgn gogo jdsgn googo googo");
        System.out.println(document.getText());
        System.out.println("version: " + document.getVersion());

        System.out.println("< -------------------- >");

        System.out.println(DocumentProcessor.score("gogo", document));
        System.out.println(DocumentProcessor.score("gogo", document, document1));
        System.out.println(DocumentProcessor.equal(document, document1));
        System.out.println(DocumentProcessor.getCountWords(document));
    }
}
