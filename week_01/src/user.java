public class User {
    String name;
    String id;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void introduce(){
        System.out.println("My name is " + this.name + " and my id is " + this.id);
    }
}