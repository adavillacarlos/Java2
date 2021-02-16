public abstract class Video implements VisualMaterial{
    private String code;
    private String title;
    private Artist artist;
    private String category;
    private int length;

    public Video() {}

    public Video(String code, String title, Artist artist, String category, int length) {
        this.code = code;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.length = length;
    }

    public Video(String code, String title, Artist artist, int length ) {
        this(code,title,artist,"Commedy",length);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public abstract void display();

    public String copyrightNotice() {
        return "Copyright 202";
    }

    public int length() {
        return length;
    }

    public String toString() {
        return "Code: " + getCode() + "\nTitle: " + getTitle() + "\nArtist: " + getArtist() + "\nCategory: " + getCategory() + "\nLength: " + length;
    }
}
