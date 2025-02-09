package WareHouseManagement;
public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Load existing inventory from file
        inventoryManager.loadInventory();

        // Simulating adding products (uncomment if adding new products)
        Product product1 = new Product();
        product1.setProductID("P001");
        product1.setName("Laptop");
        product1.setQuantity(10);

        Product product2 = new Product();
        product2.setProductID("P002");
        product2.setName("Smartphone");
        product2.setQuantity(15);

        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);

        // Simulating stock update
        inventoryManager.updateProductQuantity("P001", 8);
        inventoryManager.updateProductQuantity("P002", 12);

        // Save inventory before exiting
        inventoryManager.saveInventory();

        // Log completion message
        LogManager.log("Program execution completed. Inventory saved.");
    }
}
