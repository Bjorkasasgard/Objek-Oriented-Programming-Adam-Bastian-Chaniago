public class Order<T, P extends Number> {

    private T id;
    private String name;
    private String category; // "food", "electronics", "service"
    private P price;

    public Order(T id, String name, String category, P price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public P getPrice() {
        return price;
    }

    // Setters
    public void setId(T id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(P price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Order { id=%-6s | %-25s | category=%-15s | price=%.2f }",
                id, "name=" + name, category, price.doubleValue());
    }
}