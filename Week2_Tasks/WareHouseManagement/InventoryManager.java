package WareHouseManagement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogManager;
import java.util.Map;
import java.util.PriorityQueue;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class InventoryManager {
    private ConcurrentHashMap<String, Product> products;
    private PriorityQueue<Order> orderQueue;

    public InventoryManager() {
        products = new ConcurrentHashMap<>();
        orderQueue = new PriorityQueue<>(new OrderComparator());
    }

    public synchronized void addProduct(Product product) {
        if (products.containsKey(product.getProductID())) {
            System.out.println("Product ID already exists: " + product.getProductID());
            return;
        }
        products.put(product.getProductID(), product);
        LogManager.log("Added product: " + product.getProductID() + " - " + product.getName());
    }

    public void updateProductQuantity(String productID, int newQuantity) {
        Product product = products.get(productID);
        if (product != null) {
            product.setQuantity(newQuantity);
            LogManager.log("Updated quantity of " + productID + " to " + newQuantity);
        }
    }

    private void processSingleOrder(Order order) {
        try {
            for (String productID : order.getProductIDs()) {
                Product product = products.get(productID);
                if (product == null || product.getQuantity() == 0) {
                    throw new CustomExceptions.OutOfStockException("Product " + productID + " is out of stock!");
                }
            }

            for (String productID : order.getProductIDs()) {
                Product product = products.get(productID);
                product.setQuantity(product.getQuantity() - 1);
            }

            LogManager.log("Order " + order.getOrderID() + " successfully processed.");
        } catch (CustomExceptions.OutOfStockException e) {
            LogManager.log("Failed to process order " + order.getOrderID() + ": " + e.getMessage());
        }
    }

    public void saveInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory_data.txt"))) {
            oos.writeObject(products);
            LogManager.log("Inventory saved successfully.");
        } catch (IOException e) {
            LogManager.log("Error saving inventory: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inventory_data.txt"))) {
            products = (ConcurrentHashMap<String, Product>) ois.readObject();
            LogManager.log("Inventory loaded successfully.");
        } catch (FileNotFoundException e) {
            LogManager.log("No previous inventory file found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            LogManager.log("Error loading inventory: " + e.getMessage());
        }
    }
}
