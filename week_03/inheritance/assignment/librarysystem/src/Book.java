public class Book {
    protected String title;
    protected String author;
    protected int year;

    // constructor
    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //methofds display info
    public void displayInfo(){
        System.out.println("Title " + title);
        System.out.println("Author " + author);
        System.out.println("Year: "+ year);
    }
}
