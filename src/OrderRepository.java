import java.util.ArrayList;
import java.util.List;

public class OrderRepository<T, P extends Number> {

    private List<Order<T, P>> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order<T, P> order) {
        orders.add(order);
        System.out.println("  [+] Order added: " + order.getName());
    }

    public boolean removeOrder(T id) {
        return orders.removeIf(order -> order.getId().equals(id));
    }

    public Order<T, P> findById(T id) {
        for (Order<T, P> order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public List<Order<T, P>> getAllOrders() {
        return orders;
    }

    public void displayAll() {
        if (orders.isEmpty()) {
            System.out.println("  (No orders found)");
            return;
        }
        for (Order<T, P> order : orders) {
            System.out.println("  " + order);
        }
    }

    public int count() {
        return orders.size();
    }

    public static <T, P extends Number> double calculateTotalPrice(List<Order<T, P>> orderList) {
        double total = 0.0;
        for (Order<T, P> order : orderList) {
            total += order.getPrice().doubleValue();
        }
        return total;
    }

    public static <T, P extends Number> Order<T, P> findMostExpensive(List<Order<T, P>> orderList) {
        if (orderList == null || orderList.isEmpty()) return null;

        Order<T, P> mostExpensive = orderList.get(0);
        for (Order<T, P> order : orderList) {
            if (order.getPrice().doubleValue() > mostExpensive.getPrice().doubleValue()) {
                mostExpensive = order;
            }
        }
        return mostExpensive;
    }
}