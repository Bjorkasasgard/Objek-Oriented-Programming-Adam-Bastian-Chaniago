public class Main {
    public static void main(String[] args) {

        // PrintedBook objects
        PrintedBook pb1 = new PrintedBook("Java Programming", "James Smith", 2022, 250);
        PrintedBook pb2 = new PrintedBook("OOP Basics", "John Doe", 2021, 150);

        // EBook objects
        EBook eb1 = new EBook("AI Basics", "Sarah Lee", 2023, 40);
        EBook eb2 = new EBook("Machine Learning", "Andrew Ng", 2020, 60);

        // Output PrintedBook
        pb1.displayInfo();
        pb1.readingTime();
        System.out.println();

        pb2.displayInfo();
        pb2.readingTime();
        System.out.println();

        // Output EBook
        eb1.displayInfo();
        eb1.downloadTime(10);
        System.out.println();

        eb2.displayInfo();
        eb2.downloadTime(20);
    }
}