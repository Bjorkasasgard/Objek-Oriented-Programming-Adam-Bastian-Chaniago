public class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String title, String author, int year, int pages){
        super(title, author, year);
        this.pages = pages;
    }

    public void readingTime(){
        int time = pages * 2;
        System.out.println("Pages: " + pages);
        System.out.println("Reading time " + time + " minutes");
    }
}
