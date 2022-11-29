package librarysystem;

/**
 *
 * @author Renata, Suellen
 */

public interface ArrayQueue {

    /**
     * Adds an element at the back of the queue
     *
     * @param newElement
     * @return false if capacity is full
     */
    public boolean Enqueue(Student newElement);

    /**
     * Removes an element from the front of the queue
     *
     * @return null if queue is empty
     */
    public Student Dequeue();

    /**
     * First element of the queue without removing it
     *
     * @return null if empty
     */
    public Student First();

    /**
     * Last element of the queue without removing it
     *
     * @return null if empty
     */
    public Student Last();

    /**
     * Number of elements in the queue
     *
     * @return
     */
    public int size();

    /**
     * True if there is no elements in the queue
     *
     * @return
     */
    public boolean isEmpty();

}
