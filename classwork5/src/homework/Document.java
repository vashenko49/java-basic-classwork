package homework;

public class Document {
    private String text;
    private int version =0;
    private final String author;
    private final long timeStamp;

    public Document(String text, String author) {
        this.text = text;
        this.author = author;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        version++;
        this.text = text;
    }

    public int getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public long getTimeStamp() {
        return timeStamp;
    }


}
