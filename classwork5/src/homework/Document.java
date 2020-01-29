package homework;

public class Document {
    private String text;
    private int version = 0;
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

    private void setText(String text) {
        this.text = text;
    }

    public void changeText(String text) {
        setText(text);
        increaseVersion();
    }

    private void increaseVersion() {
        version++;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Document) {
            Document document = (Document) o;
            return document.hashCode() == hashCode() && timeStamp == ((Document) o).timeStamp && text.equals(document.getText());
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(author, 16);
    }
}
