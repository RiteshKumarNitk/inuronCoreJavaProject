/* Write a Java program that creates two threads. The first thread should print even
numbers between 1 and 10, and the second thread should print odd numbers
between 1 and 10. */
package corejava;
public class Question8 {
    private static final Object lock = new Object();
    private static int counter = 1;
    private static int n;

    public static void main(String[] args) {
        n = 10;
        Question8 obj = new Question8();

        Thread t1 = new Thread(() -> obj.printOddNo(), "Thread-1");
        Thread t2 = new Thread(() -> obj.printEvenNo(), "Thread-2");

        t1.start();
        t2.start();
    }

    protected void printOddNo() {
        int c = 0;
        synchronized (lock) {
            while (counter <= n) {
                c++;
                if (counter % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " odd: " + counter);
                counter++;
                lock.notify();
            }
            System.out.println("T1 time: " + c);
        }
    }

    protected void printEvenNo() {
        int c = 0;
        synchronized (lock) {
            while (counter <= n) {
                c++;
                if (counter % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " even: " + counter);
                counter++;
                lock.notify();
            }
            System.out.println("T2 time: " + c);
        }
    }
}
