/*Create a Java program that implements a binary search algorithm. The program
should accept user input for the target value and search for it in a sorted array. The
program should return the index of the target value if found or a message if not
found.*/
package corejava;
import java.util.*;import java.util.Scanner;
import java.util.Scanner;

public class Question7 {

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 7, 8, 9};
        int target;
        Scanner sc = new Scanner(System.in);
		System.out.println("Data in the array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Enter the number you want to search:");
        target = sc.nextInt();
        int index = binarySearch(arr, target);

       

        if (index == -1) {
            System.out.println(target + " element is not found");
        } else {
            System.out.println(target + " element is found at index: " + index);
        }
    }
}
