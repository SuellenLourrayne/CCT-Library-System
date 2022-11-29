package librarysystem;

import java.util.List;

/**
 *
 * @author Renata, Suellen
 */

public class Borrowing {

    private Student student;
    private List<Book> books;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    public void addBook(Book book) {
        this.books.add(book);
    }
    
    public void removeBook(Book book){
        this.books.remove(book);
    }
    
    public boolean hasBook(){
        return !books.isEmpty();
    }
    //print books borrowed by a specific student
    @Override
    public String toString() {
        return "\nBooks borrowed\n" + books.toString();
    }    

}
