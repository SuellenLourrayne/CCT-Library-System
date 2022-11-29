package librarysystem;

/**
 *
 * @author Renata, Suellen
 */

public class StudentQueue {
    public Book book;
    public BorrowingQueue queue;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BorrowingQueue getQueue() {
        return queue;
    }

    public void setQueue(BorrowingQueue queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "\n-------------------------------------\n"
                + "Queue\n" + queue.toString();
    }
    
    
    
}
