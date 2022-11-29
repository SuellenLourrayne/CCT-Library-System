package librarysystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Renata, Suellen
 */

public class LibrarySystem {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //main menu
        List<Book> books = (List<Book>) ReadCsv.getAllBooks();
        List<Student> students = (List<Student>) ReadCsv.getAllStudents();
        List<Borrowing> borrowings = new ArrayList();
        List<StudentQueue> studentsQueue = new ArrayList();

        //skiping books borroed to avoid NullPoint errors
        for (Student student : students) {
            Borrowing borrowing = new Borrowing();
            borrowing.setStudent(student);
            borrowing.setBooks(new ArrayList());
            borrowings.add(borrowing);
        }

        QuickSort qs = new QuickSort();
        BinarySearch bs = new BinarySearch();

        int option = -1;

        while (option != 0) {
            //main menu
            System.out.println(
                    "\n1 - Search for a specific book by title\n"
                    + "2 - Search for a specific book by author name\n"
                    + "3 - List all books by title alphabetical order\n"
                    + "4 - List all books by author name alphabetical order\n"
                    + "5 - Search for a specific student by name\n"
                    + "6 - Search for a specific student by ID\n"
                    + "7 - List all students by alphabetical name\n"
                    + "8 - List all students by ID order\n"
                    + "9 - Register that a student has borrowed a book\n"
                    + "10 - Register that a student has returned a book\n"
                    + "11 - For a specific student, list the books that they have borrowed\n"
                    + "0 - Exit\n"
            );
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter an option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    //Search for a specific book by title
                    int index = searchIndexBook(books, qs, bs, "title");
                    BinarySearch.printBook(books, index);
                    break;

                case 2:
                    //Search for a specific book by author name
                    index = searchIndexBook(books, qs, bs, "author_name");
                    BinarySearch.printBook(books, index);
                    break;

                case 3:
                    //List all books by title alphabetical order
                    sortBooks(books, qs, "title");
                    break;

                case 4:
                    //List all books by author name alphabetical order
                    sortBooks(books, qs, "author_name");
                    break;
                case 5:
                    //Search for a specific student by name
                    index = searchIndexStudent(students, qs, bs, "name");
                    BinarySearch.printStudent(students, index);
                    break;
                case 6:
                    //Search for a specific student by ID
                    index = searchIndexStudent(students, qs, bs, "id");
                    BinarySearch.printStudent(students, index);
                    break;

                case 7:
                    //List all students by alphabetical name
                    sortStudents(students, qs, "name");
                    break;

                case 8:
                    //List all students by ID order
                    sortStudents(students, qs, "id");
                    break;

                case 9:
                    //Register that a student has borrowed a book
                    int indexStudent = searchIndexStudent(students, qs, bs, "name");
                    BinarySearch.printStudent(students, indexStudent);

                    if (indexStudent < 0) {
                        break;
                    }
                    System.out.println();

                    int indexBook = searchIndexBook(books, qs, bs, "title");
                    BinarySearch.printBook(books, indexBook);

                    if (indexBook > 0) {
                        Book book = books.get(indexBook);
                        Student student = students.get(indexStudent);

                        boolean isBorrowedBook = true;
                        for (StudentQueue studentQueue : studentsQueue) {
                            //Linear Search
                            String borrowingBooksTitle = studentQueue.getBook().getBook_title();
                            BorrowingQueue borrowingQueue = studentQueue.getQueue();

                            if (borrowingBooksTitle.equals(book.getBook_title())) {
                                borrowingQueue.Enqueue(student);
                                //Linear Search
                                for (Borrowing borrowing : borrowings) {
                                    if (borrowing.getStudent().getName().equals(student.getName())) {
                                        borrowing.addBook(book);
                                        isBorrowedBook = false;
                                        break;
                                    }
                                }

                                System.out.println(studentQueue.toString());
                                break;
                            }
                        }
                        if (isBorrowedBook) {
                            StudentQueue studentQueue = new StudentQueue();
                            studentQueue.setBook(book);
                            BorrowingQueue borrowingQueue = new BorrowingQueue(students.size());
                            borrowingQueue.Enqueue(student);

                            studentQueue.setQueue(borrowingQueue);
                            System.out.println(studentQueue.toString());
                            studentsQueue.add(studentQueue);
                            
                            //Linear Search
                            for (Borrowing borrowing : borrowings) {
                                if (borrowing.getStudent().getName().equals(student.getName())) {
                                    borrowing.addBook(book);
                                    break;
                                }
                            }
                        }

                    }

                    break;

                case 10:
                    //Register student that has returned a book
                    if (studentsQueue.isEmpty()) {
                        System.out.println("No student borrowed a book");
                        break;
                    }

                    indexStudent = searchIndexStudent(students, qs, bs, "name");
                    BinarySearch.printStudent(students, indexStudent);

                    if (indexStudent < 0) {
                        break;
                    }
                    System.out.println();

                    indexBook = searchIndexBook(books, qs, bs, "title");
                    BinarySearch.printBook(books, indexBook);

                    if (indexBook > 0) {
                        Book book = books.get(indexBook);
                        Student student = students.get(indexStudent);

                        for (StudentQueue studentQueue : studentsQueue) {
                            //Linear Search
                            String borrowingBooksTitle = studentQueue.getBook().getBook_title();
                            BorrowingQueue borrowingQueue = studentQueue.getQueue();
                            if (borrowingBooksTitle.equals(book.getBook_title())) {
                                if (borrowingQueue.First().getName().equals(student.getName())) {
                                    borrowingQueue.Dequeue();
                                    //Linear Search
                                    for (Borrowing borrowing : borrowings) {
                                        if (borrowing.getStudent().getName().equals(student.getName())) {
                                            borrowing.removeBook(book);
                                            break;
                                        }
                                    }

                                    System.out.println(studentQueue.toString());
                                } else {
                                    System.out.println("The student is still in line and has not borrowed the book");
                                }
                                break;
                            }
                        }
                    }

                    break;
                    
                case 11:

                    //For a specific student, list the books that they have borrowed
                    if (studentsQueue.isEmpty()) {
                        System.out.println("No student borrowed a book");
                        break;
                    }

                    indexStudent = searchIndexStudent(students, qs, bs, "name");
                    BinarySearch.printStudent(students, indexStudent);

                    if (indexStudent < 0) {
                        break;
                    }
                    System.out.println();
                    Student student = students.get(indexStudent);

                    for (Borrowing borrowing : borrowings) {
                        if (borrowing.getStudent().getName().equals(student.getName())) {
                            System.out.println(borrowing.toString());
                            break;
                        }
                    }
                    break;

                case 0:

                    System.out.println("Exiting the program...");
                    sc.close();
                    break;

                default:
                    System.out.println("Invalid option!!\n");
            }
        }
    }

    public static int searchIndexBook(
            List<Book> books,
            QuickSort qs,
            BinarySearch bs,
            String column) {

        int n = books.size();
        qs = new QuickSort();
        bs = new BinarySearch();

        Scanner sc = new Scanner(System.in);
        if ("author_name".equals(column)) {
            System.out.print("Enter the name of the author of the book: ");
        } else {
            System.out.print("Enter the title of the book: ");
        }

        String searchBook = sc.nextLine();

        qs.sortBook(books, 0, n - 1, column);
        return bs.searchBook(books, 0, books.size() - 1, searchBook, column);
    }

    public static void sortBooks(List<Book> books, QuickSort qs, String column) {
        int n = books.size();
        qs = new QuickSort();

        qs.sortBook(books, 0, n - 1, column);
        QuickSort.printArrayBook(books);
    }

    public static int searchIndexStudent(
            List<Student> students,
            QuickSort qs,
            BinarySearch bs,
            String column) {

        int n = students.size();
        qs = new QuickSort();
        bs = new BinarySearch();

        Scanner sc = new Scanner(System.in);

        if ("name".equals(column)) {
            System.out.print("Enter student name: ");
        } else {
            System.out.print("Enter student ID: ");
        }
        String searchStudent = sc.nextLine();

        qs.sortStudent(students, 0, n - 1, column);
        return bs.searchStudent(students, 0, students.size() - 1, searchStudent, column);
    }

    public static void sortStudents(List<Student> students, QuickSort qs, String column) {
        int n = students.size();
        qs = new QuickSort();
        qs.sortStudent(students, 0, n - 1, column);
        QuickSort.printArrayStudent(students);

    }
}
