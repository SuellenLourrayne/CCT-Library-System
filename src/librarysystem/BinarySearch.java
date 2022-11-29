package librarysystem;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Renata, Suellen
 */

public class BinarySearch {
    //returns book position, if not found returns -1
    public int searchBook(List<Book> arr, int l, int r, String book, String column) {
        QuickSort qs = new QuickSort();

        if (r >= l) {
            int mid = l + (r - l) / 2;
            //compareBook gets the book string 
            String compareBook = qs.getBookByString(arr.get(mid), column);
            if (book.equals(compareBook)) {
                return mid;
            }

            if (qs.smallString(book, compareBook)) {
                return searchBook(arr, l, mid - 1, book, column);
            }
            return searchBook(arr, mid + 1, r, book, column);
        }

        //if book not found, return -1
        return -1;
    }
     //returns student position, if not found returns -1
    public int searchStudent(List<Student> arr, int l, int r, String student, String column) {
        QuickSort qs = new QuickSort();

        if (r >= l) {
            int mid = l + (r - l) / 2;
            String compareStudentName = arr.get(mid).getName();
            Long compareStudentId = arr.get(mid).getId();

            if (column.equals("id")) {
                Long longStudentId = Long.valueOf(student);

                if (Objects.equals(compareStudentId, longStudentId)) {
                    return mid;
                }

                if (longStudentId < compareStudentId) {
                    return searchStudent(arr, l, mid - 1, student, column);
                }
                return searchStudent(arr, mid + 1, r, student, column);

            } else {
                if (student.equals(compareStudentName)) {
                    return mid;
                }

                if (qs.smallString(student, compareStudentName)) {
                    return searchStudent(arr, l, mid - 1, student, column);
                }
                return searchStudent(arr, mid + 1, r, student, column);
            }

        }
        return -1;
    }
    //returns the book, if not found returns a message that book was not found
    public static void printBook(List<Book> books, int index) {
        if (index > 0) {
            String b = books.get(index).toString();
            System.out.println(b);
        } else {
            System.out.println("Book not found!\n");
        }
    }
    //returns the student, if not found returns a message that student was not found
    public static void printStudent(List<Student> students, int index) {
        if (index > 0) {
            String b = students.get(index).toString();
            System.out.println(b);
        } else {
            System.out.println("Student not found!\n");
        }
    }

}
