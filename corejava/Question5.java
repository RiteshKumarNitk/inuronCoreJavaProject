/*Demonstrate the difference between abstract class and interface by writing programs
as well as in keypoints.*/

package corejava;
interface Mobile {
    void call(); // by default public and abstract
    void internet();
    void bluetooth();
}

abstract class SamsungGuru implements Mobile {
    public void call() {
        System.out.println("Calling features added...");
    }
}

class SamsungGalaxy extends SamsungGuru {
    public void internet() {
        System.out.println("Internet implementation successfully...");
    }

    public void bluetooth() {
        System.out.println("Bluetooth implementation successfully...");
    }
}

public class Question5 {
    public static void main(String[] args) {
        Mobile m1 = new SamsungGalaxy();
        m1.call();
        m1.internet();
        m1.bluetooth();
    }
}
