public class EBook extends Book {
    private double fileSize;

    // Constructor
    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year);
        this.fileSize = fileSize;
    }

    public void downloadTime(double speed) {
        double time = fileSize / speed;
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Download Time at " + speed + " MB/s: " + time + " seconds");
    }
}