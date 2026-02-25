public class User {
    String id;
    String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + " and my ID is " + id);
    }
}