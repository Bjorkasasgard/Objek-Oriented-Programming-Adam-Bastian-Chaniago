public class Main {
    public static void main(String[] args) {

        Cat c = new Cat();
        c.name = "Kucing";
        c.age = 2;

        c.breathing();
        c.eating();
        c.voice();

        System.out.println();

        Sapi s = new Sapi();
        s.name = "Sapi";
        s.age = 8;

        s.breathing();
        s.eating();
        s.voice();
    }
}