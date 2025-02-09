package WareHouseManagement;
import java.util.*;

import javax.tools.DocumentationTool.Location;

public class Product {
    private String productID;  // Unique product identifier
    private String name;       // Product name
    private int quantity;      // Stock quantity (updated manually)
    private Location location; // Location in the warehouse

    // Getter for productID
    public String getProductID() {
        return productID;
    }

    // Setter for productID (allows modification)
    public void setProductID(String productID) {
        this.productID = productID;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for quantity (ensuring no negative values)
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for location
    public void setLocation(Location newLocation) {
        this.location = newLocation;
    }

    // Getter for location
    public Location getLocation() {
        return location;
    }
}
