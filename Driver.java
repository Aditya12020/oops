import java.util.Scanner;
class MyClass {

    public MyClass() {}

    
    public int abs(int x) {
        return (x < 0) ? -x : x;
    }

    
    public float abs(float x) {
        return (x < 0) ? -x : x;
    }

    
    public double abs(double x) {
        return (x < 0) ? -x : x;
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyClass obj = new MyClass();

        System.out.print("Enter integer: ");
        int i = sc.nextInt();

        System.out.print("Enter float: ");
        float f = sc.nextFloat();

        System.out.print("Enter double: ");
        double d = sc.nextDouble();

        System.out.println("Absolute int = " + obj.abs(i));
        System.out.println("Absolute float = " + obj.abs(f));
        System.out.println("Absolute double = " + obj.abs(d));

        sc.close();
    }
}











class Call {
    protected int duration; // in minutes

    public Call() {}

    public Call(int duration) {
        this.duration = duration;
    }
}

// Local Call class
class LocalCall extends Call {

    public LocalCall(int duration) {
        super(duration);
    }

    // 1 unit per 3 minutes (fraction counted)
    public int calculateBill() {
        int units = (int) Math.ceil(duration / 3.0);
        return units;
    }
}

// Long Distance Call class
class LongCall extends Call {
    private int code; // STD code
    private int time; // hour (0–23)

    public LongCall(int duration, int code, int time) {
        super(duration);
        this.code = code;
        this.time = time;
    }

    // Method to calculate bill
    public double calculateBill() {
        double rate = 0;

        // Day time: 6am to 10pm (6–22)
        boolean isDay = (time >= 6 && time <= 22);

        if (code == 11) {
            rate = isDay ? 1.0 : 0.5;
        } 
        else if (code == 22) {
            rate = isDay ? 1.5 : 0.5;
        } 
        else if (code == 44) {
            rate = isDay ? 0.75 : 0.4;
        }

        // rate per 2 minutes
        double units = Math.ceil(duration / 2.0);
        return units * rate;
    }
}

// Driver class
public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Local Call");
        System.out.println("2. STD Call");
        int choice = sc.nextInt();

        System.out.print("Enter duration (minutes): ");
        int d = sc.nextInt();

        if (choice == 1) {
            LocalCall lc = new LocalCall(d);
            System.out.println("Bill (units) = " + lc.calculateBill());
        } 
        else if (choice == 2) {
            System.out.print("Enter STD code (11/22/44): ");
            int code = sc.nextInt();

            System.out.print("Enter time (0-23): ");
            int time = sc.nextInt();

            LongCall sca = new LongCall(d, code, time);
            System.out.println("Bill amount = " + sca.calculateBill());
        } 
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}