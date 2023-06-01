/*Write a Java program that reads a set of integers from the user and stores them in a
List. The program should then find the second largest and second smallest elements
in the List.*/
package corejava;
public class Question10 {
    protected static int getSecondLargest(int[] arr, int size) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (arr[i] > highest) {
                secondHighest = highest;
                highest = arr[i];
            } else if (arr[i] > secondHighest && arr[i] != highest) {
                secondHighest = arr[i];
            }
        }

        return secondHighest;
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 12, 3, 10};
        int[] b = {22, 11, 55, 33, 77, 66};

        System.out.println("Second Largest: " + getSecondLargest(a, a.length));
        System.out.println("Second Largest: " + getSecondLargest(b, b.length));
    }
}
