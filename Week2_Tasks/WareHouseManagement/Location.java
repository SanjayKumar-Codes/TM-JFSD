package WareHouseManagement;

public class Location {
    private int aisle; // Aisle number in the warehouse
    private int shelf; // Shelf number
    private int bin;   // Bin number

    // Getter for aisle
    public int getAisle() {
        return aisle;
    }

    // Setter for aisle
    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    // Getter for shelf
    public int getShelf() {
        return shelf;
    }

    // Setter for shelf
    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    // Getter for bin
    public int getBin() {
        return bin;
    }

    // Setter for bin
    public void setBin(int bin) {
        this.bin = bin;
    }

    // Method to get the full location as a string
    public String getLocationString() {
        return "Aisle: " + aisle + ", Shelf: " + shelf + ", Bin: " + bin;
    }
}

