import java.util.List;

public class Main {

    static void header(String title) {
        System.out.println("\n" + "═".repeat(65));
        System.out.println("  " + title);
        System.out.println("═".repeat(65));
    }

    static void section(String title) {
        System.out.println("\n  ── " + title + " ──");
    }

    public static void main(String[] args) {

        header("1. FOOD ORDERS  [Order<String, Double>]");

        OrderRepository<String, Double> foodRepo = new OrderRepository<>();

        section("Adding orders...");
        foodRepo.addOrder(new Order<>("F001", "Nasi Goreng Spesial",  "food", 45000.0));
        foodRepo.addOrder(new Order<>("F002", "Ayam Bakar Madu",      "food", 75000.0));
        foodRepo.addOrder(new Order<>("F003", "Mie Goreng Jumbo",     "food", 35000.0));
        foodRepo.addOrder(new Order<>("F004", "Es Teh Manis",         "food", 8000.0));
        foodRepo.addOrder(new Order<>("F005", "Soto Ayam Lamongan",   "food", 52000.0));

        section("All Food Orders:");
        foodRepo.displayAll();

        List<Order<String, Double>> foodList = foodRepo.getAllOrders();
        double foodTotal = OrderRepository.calculateTotalPrice(foodList);
        Order<String, Double> mostExpensiveFood = OrderRepository.findMostExpensive(foodList);

        section("Summary:");
        System.out.printf("  Total Orders   : %d%n", foodRepo.count());
        System.out.printf("  Total Price    : Rp %.2f%n", foodTotal);
        System.out.printf("  Most Expensive : %s (Rp %.2f)%n",
                mostExpensiveFood.getName(), mostExpensiveFood.getPrice());


        header("2. ELECTRONICS ORDERS  [Order<Integer, Double>]");

        OrderRepository<Integer, Double> electronicsRepo = new OrderRepository<>();

        section("Adding orders...");
        electronicsRepo.addOrder(new Order<>(1001, "Laptop ASUS VivoBook 15",   "electronics", 8500000.0));
        electronicsRepo.addOrder(new Order<>(1002, "Headphone Sony WH-1000XM5", "electronics", 4200000.0));
        electronicsRepo.addOrder(new Order<>(1003, "Mechanical Keyboard Keychron K2", "electronics", 1350000.0));
        electronicsRepo.addOrder(new Order<>(1004, "Mouse Logitech MX Master 3", "electronics", 1100000.0));
        electronicsRepo.addOrder(new Order<>(1005, "Monitor LG 27\" IPS",        "electronics", 3750000.0));

        section("All Electronics Orders:");
        electronicsRepo.displayAll();

        List<Order<Integer, Double>> elecList = electronicsRepo.getAllOrders();
        double elecTotal = OrderRepository.calculateTotalPrice(elecList);
        Order<Integer, Double> mostExpensiveElec = OrderRepository.findMostExpensive(elecList);

        section("Summary:");
        System.out.printf("  Total Orders   : %d%n", electronicsRepo.count());
        System.out.printf("  Total Price    : Rp %.2f%n", elecTotal);
        System.out.printf("  Most Expensive : %s (Rp %.2f)%n",
                mostExpensiveElec.getName(), mostExpensiveElec.getPrice());

        header("3. SERVICE ORDERS  [Order<String, Integer>]");

        OrderRepository<String, Integer> serviceRepo = new OrderRepository<>();

        section("Adding orders...");
        serviceRepo.addOrder(new Order<>("SVC-01", "Web Design & Development",  "service", 5000000));
        serviceRepo.addOrder(new Order<>("SVC-02", "Logo & Branding Package",   "service", 1500000));
        serviceRepo.addOrder(new Order<>("SVC-03", "SEO Optimization (3 bulan)", "service", 2400000));
        serviceRepo.addOrder(new Order<>("SVC-04", "Social Media Management",   "service", 3000000));

        section("All Service Orders:");
        serviceRepo.displayAll();

        List<Order<String, Integer>> svcList = serviceRepo.getAllOrders();
        double svcTotal = OrderRepository.calculateTotalPrice(svcList);
        Order<String, Integer> mostExpensiveSvc = OrderRepository.findMostExpensive(svcList);

        section("Summary:");
        System.out.printf("  Total Orders   : %d%n", serviceRepo.count());
        System.out.printf("  Total Price    : Rp %.2f%n", svcTotal);
        System.out.printf("  Most Expensive : %s (Rp %.2f)%n",
                mostExpensiveSvc.getName(), mostExpensiveSvc.getPrice().doubleValue());

        header("4. REPOSITORY OPERATIONS DEMO");

        section("Find Food Order by ID 'F003':");
        Order<String, Double> found = foodRepo.findById("F003");
        if (found != null) {
            System.out.println("  Found  → " + found);
        }

        section("Remove Food Order 'F003', then display all:");
        boolean removed = foodRepo.removeOrder("F003");
        System.out.println("  Remove F003: " + (removed ? "SUCCESS" : "NOT FOUND"));
        foodRepo.displayAll();

        section("Find Electronics Order by ID 1002:");
        Order<Integer, Double> foundElec = electronicsRepo.findById(1002);
        if (foundElec != null) {
            System.out.println("  Found  → " + foundElec);
        }

        header("5. GRAND SUMMARY");
        double grandTotal = foodTotal + elecTotal + svcTotal;
        System.out.printf("  Food Orders       : %d items  | Total = Rp %.2f%n",
                foodRepo.count(), foodTotal);
        System.out.printf("  Electronics Orders: %d items  | Total = Rp %.2f%n",
                electronicsRepo.count(), elecTotal);
        System.out.printf("  Service Orders    : %d items  | Total = Rp %.2f%n",
                serviceRepo.count(), svcTotal);
        System.out.println("  " + "─".repeat(55));
        System.out.printf("  GRAND TOTAL       :           | Total = Rp %.2f%n", grandTotal);
        System.out.println("\n" + "═".repeat(65));
    }
}