package librarysystem;

import java.util.List;

/**
 *
 * @author Renata, Suellen
 */

// Java program for implementation of QuickSort
class QuickSort {

    /***
    This function takes last element as pivot, places the pivot element at its correct position in sorted array, 
    places all smaller (smaller than pivot) to left of pivot, and all greater elements to right of pivot 
    ***/
    int partitionBook(List<Book> arr, int low, int high, String column) {
        
        String pivot = getBookByString(arr.get(high), column);
        int i = (low - 1); // index of smaller element
        
        for (int j = low; j < high; j++) {
            //If current element is smaller than or equal to pivot
            if (smallString(getBookByString(arr.get(j), column), pivot)) {
                i++;
                Book temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        Book temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;

    }

    int partitionStudent(List<Student> arr, int low, int high, String column) {

        String pivot = arr.get(high).getName();        
        Long longPivot = arr.get(high).getId();
        int i = (low - 1); // index of smaller element
        
        for (int j = low; j < high; j++) {
            //If current element is smaller than or equal to pivot
            if ("id".equals(column)) {
                Long id = arr.get(j).getId();
                if (longPivot > id) {
                    i++;
                    Student temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            } else {
                if(smallString(arr.get(j).getName(), pivot)){
                    i++;

                    Student temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }

        Student temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;

    }

    /***
        The main function that implements QuickSort()
	arr[] --> Array to be sorted,
	low --> Starting index,
	high --> Ending index 
    ***/
    void sortBook(List<Book> books, int low, int high, String column) {
        if (low < high) {
            //pi is partitioning index, arr[pi] is now at right place
            int pi = partitionBook(books, low, high, column);
            //recursively sort elements before partition and after partition
            sortBook(books, low, pi - 1, column);
            sortBook(books, pi + 1, high, column);
        }
    }

    void sortStudent(List<Student> students, int low, int high, String column) {
        if (low < high) {
            //pi is partitioning index, arr[pi] is now at right place 
            int pi = partitionStudent(students, low, high, column);
            //recursively sort elements before partition and after partition
            sortStudent(students, low, pi - 1, column);
            sortStudent(students, pi + 1, high, column);
        }
    }

    static void printArrayBook(List<Book> books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println();
    }

    static void printArrayStudent(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println();
    }
    
    //method to compare which word is smaller than other
    public Boolean smallString(String str1, String str2) {
        //upercase used, this way the entire word is the same type
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        return str1.compareTo(str2) <= 0;   
    }

    public String getBookByString(Book book, String attributeName) {
        if ("title".equals(attributeName)) {
            return book.getBook_title();
        }
        return book.getAuthor_first_name();
    }

}
