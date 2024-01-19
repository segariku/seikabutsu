package utils;

public class bookBean {
    //isbnコード
    private String isbn;
    //タイトル
    private String title;
    //著者
    private String author;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //画像
    private String imageUrl;

    public bookBean(String isbn, String title, String author, String imageUrl) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
    }
}
