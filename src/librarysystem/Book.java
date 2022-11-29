package librarysystem;

/**
 *
 * @author Renata, Suellen
 */

public class Book {

    private String id;
    private String author_first_name;
    private String author_last_name;
    private String book_title;
    private String genre;

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor_first_name() {
        return author_first_name;
    }

    public void setAuthor_first_name(String author_first_name) {
        this.author_first_name = author_first_name;
    }

    public String getAuthor_last_name() {
        return author_last_name;
    }

    public void setAuthor_last_name(String author_last_name) {
        this.author_last_name = author_last_name;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    //print book details
    @Override
    public String toString() {
        return "\n_________________________________________\n"
                + "ID = " + id + "\n"
                + "Author first name = " + author_first_name  + "\n"
                + "Author last name = " + author_last_name  + "\n"
                + "Book title = " + book_title  + "\n"
                + "Genre = " + genre + "\n";
    }

}
