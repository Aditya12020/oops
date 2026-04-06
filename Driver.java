import java.util.Scanner;

class MyClass {
    private double value;
    public MyClass() {}


    public MyClass(double value) {
        this.value = value;
    }

    
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    
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
    private int duration;

    public Call() {}

    public Call(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}


class LocalCall extends Call {

    public LocalCall() {}

    public LocalCall(int duration) {
        super(duration);
    }

    public int calculateBill() {
        int units = (int) Math.ceil(getDuration() / 3.0);
        return units;
    }
}


class LongCall extends Call {
    private int code;
    private int time;

    public LongCall() {}

    public LongCall(int duration, int code, int time) {
        super(duration);
        this.code = code;
        this.time = time;
    }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public int getTime() { return time; }
    public void setTime(int time) { this.time = time; }

    public double calculateBill() {
        double rate = 0;

        boolean isDay = (getTime() >= 6 && getTime() <= 22);

        if (getCode() == 11) {
            rate = isDay ? 1.0 : 0.5;
        } 
        else if (getCode() == 22) {
            rate = isDay ? 1.5 : 0.5;
        } 
        else if (getCode() == 44) {
            rate = isDay ? 0.75 : 0.4;
        }

        double units = Math.ceil(getDuration() / 2.0);
        return units * rate;
    }
}


public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Local Call");
        System.out.println("2. STD Call");
        int choice = sc.nextInt();

        System.out.print("Enter duration: ");
        int d = sc.nextInt();

        if (choice == 1) {
            LocalCall lc = new LocalCall(d);
            System.out.println("Bill = " + lc.calculateBill());
        } 
        else if (choice == 2) {
            System.out.print("Enter code (11/22/44): ");
            int code = sc.nextInt();

            System.out.print("Enter time (0-23): ");
            int time = sc.nextInt();

            LongCall l = new LongCall(d, code, time);
            System.out.println("Bill = " + l.calculateBill());
        } 
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}





















class Staff {
    private int code;
    private String name;

    public Staff() {}

  
    public Staff(int code, String name) {
        this.code = code;
        this.name = name;
    }

   
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Code: ");
        setCode(sc.nextInt());
        System.out.print("Enter Name: ");
        setName(sc.next());
    }

    public void display() {
        System.out.println("Code: " + getCode());
        System.out.println("Name: " + getName());
    }
}

class Teacher extends Staff {
    private String subject;
    private String publication;

    public Teacher() {}

    public Teacher(int code, String name, String subject, String publication) {
        super(code, name);
        this.subject = subject;
        this.publication = publication;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getPublication() { return publication; }
    public void setPublication(String publication) { this.publication = publication; }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Subject: ");
        setSubject(sc.next());
        System.out.print("Enter Publication: ");
        setPublication(sc.next());
    }

    public void display() {
        super.display();
        System.out.println("Subject: " + getSubject());
        System.out.println("Publication: " + getPublication());
    }
}


class Officer extends Staff {
    private String grade;

    public Officer() {}

    public Officer(int code, String name, String grade) {
        super(code, name);
        this.grade = grade;
    }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Grade: ");
        setGrade(sc.next());
    }

    public void display() {
        super.display();
        System.out.println("Grade: " + getGrade());
    }
}


class Typist extends Staff {
    private int speed;

    public Typist() {}

    public Typist(int code, String name, int speed) {
        super(code, name);
        this.speed = speed;
    }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Speed: ");
        setSpeed(sc.nextInt());
    }

    public void display() {
        super.display();
        System.out.println("Speed: " + getSpeed());
    }
}

class RegularTypist extends Typist {
    private int remuneration;

    public RegularTypist() {}

    public RegularTypist(int code, String name, int speed, int remuneration) {
        super(code, name, speed);
        this.remuneration = remuneration;
    }

    public int getRemuneration() { return remuneration; }
    public void setRemuneration(int remuneration) { this.remuneration = remuneration; }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Remuneration: ");
        setRemuneration(sc.nextInt());
    }

    public void display() {
        super.display();
        System.out.println("Remuneration: " + getRemuneration());
    }
}


class CasualTypist extends Typist {
    private int dailyWages;

    public CasualTypist() {}

    public CasualTypist(int code, String name, int speed, int dailyWages) {
        super(code, name, speed);
        this.dailyWages = dailyWages;
    }

    public int getDailyWages() { return dailyWages; }
    public void setDailyWages(int dailyWages) { this.dailyWages = dailyWages; }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Daily Wages: ");
        setDailyWages(sc.nextInt());
    }

    public void display() {
        super.display();
        System.out.println("Daily Wages: " + getDailyWages());
    }
}

public class Driver {
    public static void main(String[] args) {

        System.out.println("\n--- Teacher ---");
        Teacher t = new Teacher();
        t.input();
        t.display();

        System.out.println("\n--- Officer ---");
        Officer o = new Officer();
        o.input();
        o.display();

        System.out.println("\n--- Regular Typist ---");
        RegularTypist rt = new RegularTypist();
        rt.input();
        rt.display();

        System.out.println("\n--- Casual Typist ---");
        CasualTypist ct = new CasualTypist();
        ct.input();
        ct.display();
    }
}