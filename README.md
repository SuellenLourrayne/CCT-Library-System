# CCT-Library-System
HDip in Computing Science - Algorithms and Constructs
Students: Renata Carvalho e Suellen Oliveira
CCT College - 2022

# Challenges, Sorting and Searching Algorithm implemented 
Binary Search was preferred to Linear Search. In a binary search, it is calculated whether the middle element is smaller or greater than the element being sought after. The main advantage of binary search is that, unlike linear search, each entry in the list is not inspected. Instead of going through each entry, it searches the first half of the list. Therefore, a binary search identifies an element more quickly than a linear search. Binary search only needs an array to be in sorted order, as opposed to linear search, which functions with both sorted and unsorted arrays. The binary search method divides the array recursively since it is based on the divide and conquer strategy.
Since the searching technique we adopted required an array to be in sorted order, sorting the strings was the key problem. To address it, we chose the Quicksort algorithm and on a few exceptional cases where it might be quicker than Binary Search, Linear Search was also used.
Quicksort was chosen because it is the fastest recursive divide and conquer algorithm in its class. A pivot, which is frequently either the middle or last element of an array, is utilized when performing a quick sort. By comparing each element of the array with the pivot, the algorithm reorders each element so that the values on one side (left) are smaller and the values on the other side (right) are larger. The same procedure is repeated until the array is sorted after partitioning both sides.

# References
GeeksforGeeks. (2022, June 13). Java Program for QuickSort. https://www.geeksforgeeks.org/java-program-for-quicksort/
Linear Search vs Binary Search - javatpoint. (n.d.). www.javatpoint.com. https://www.javatpoint.com/ds-linear-search-vs-binary-search
Pyram, J. (2021, December 13). Quick Sort Explained in Under 5 minutes - Better Programming. Medium. https://betterprogramming.pub/quicksort-explained-in-5-minutes-d32cf430a592
Fadatare, R. (2018, November 15). Quick Sort Algorithm in Java. https://www.javaguides.net/2018/09/quick-sort-algorithm-in-java.html
