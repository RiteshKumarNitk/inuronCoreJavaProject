/*Write a Java program to invoke parent class constructor from a child class. Create
Child class object and parent class constructor must be invoked. Demonstrate by
writing a program. Also explain key points about Constructor.*/
package corejava;
class A {
    public int a;
    public int b;

    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class B extends A {
    public int c;

    B(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public void sum() {
        int sum = a + b + c;
        System.out.println("Sum of the three numbers: " + sum);
    }
}

public class Question2 {
    public static void main(String[] args) {
        B obj = new B(10, 30, 40);
        obj.sum();
    }
}
