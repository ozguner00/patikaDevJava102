package KitapSiralayici;

public class Book implements Comparable<Book>{
    private String bookName;
    private int numberOfPage;
    private String authorName;
    private int releaseYer;

    public Book(String bookName, int numberOfPage, String authorName, int releaseYer) {
        this.bookName = bookName;
        this.numberOfPage = numberOfPage;
        this.authorName = authorName;
        this.releaseYer = releaseYer;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getReleaseYer() {
        return releaseYer;
    }

    public void setReleaseYer(int releaseYer) {
        this.releaseYer = releaseYer;
    }

    @Override
    public int compareTo(Book o) {
        return this.bookName.compareTo(o.bookName);
    }


}
