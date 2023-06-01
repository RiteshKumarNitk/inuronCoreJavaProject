/*Write a Java program that takes an integer from the user and throws an exception
if it is negative.Demonstrate Exception handling of same program as solution.*/
package corejava;
import java.util.Scanner;


//user defined exception
class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String msg) {
        super(msg);
    }
}

public class Question3 {
    public static void validateNumber(int num) throws NegativeNumberException {
        if (num < 0) {
            throw new NegativeNumberException("Number should always be positive");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter any Integer Number: ");
            int num = sc.nextInt();

            try {
                validateNumber(num);
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
