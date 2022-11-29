package librarysystem;

/**
 *
 * @author Renata, Suellen
 */

public class BorrowingQueue implements ArrayQueue {

    private Student[] students;
    private int capacity;
    private int queueSize;
    private int first;//pointer of the first element (index) --front
    private int last;//pointer of the last element (index) --back

    public BorrowingQueue(int capacity) {
        this.capacity = capacity;
        this.students = new Student[capacity];
        this.queueSize = 0;
        //both pointers (first and last) should be outside the array, because 
        //this one is empty, and there is no first or last element yet
        this.last = -1;
        this.first = -1;
    }

    @Override
    public boolean Enqueue(Student newElement) {
        //array is full, so we cannot add elements
        //if(last >= capacity -1)
        if (queueSize >= capacity) {
            return false;
        }
        //if the array is empty, we need to move the front pointer
        if (first == -1) {
            first++;
        }

        last++; //we move the last pointer one position
        students[last] = newElement; //we allocate the new element in the new-last position
        queueSize++;//we increase the queue size
        return true;
    }

    @Override
    public Student Dequeue() {
        //checks if queue is empty 
        if (queueSize == 0) {
            return null;
        }

        if (queueSize == 1) {
            Student elementReturn = students[first];
            first--;
            last--;
            queueSize--;
            return elementReturn;
        }

        //Save the element in one variable 
        Student elementReturn = students[first];

        for (int i = 0; i < queueSize; i++) {
            if (i + 1 <= queueSize - 1) {
                students[i] = students[i + 1];
            }
        }
        last--;
        queueSize--;
        return elementReturn;
    }

    @Override
    public Student First() {
        if (queueSize == 0) {
            return null;
        }
        return students[first];

    }

    @Override
    public Student Last() {
        if (queueSize == 0) {
            return null;
        }
        return students[last];

    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        if (queueSize == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String toReturn = "";

        for (int i = 0; i <= last; i++) {
            toReturn += students[i].toString() + "\n";
        }

        return toReturn;
    }

}
