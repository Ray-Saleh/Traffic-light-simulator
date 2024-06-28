package Data;

public class vehicle {
    private String licensePlate;
    private String type;
    private int size; // For example: Small = 1, Medium = 2, Large = 3

    public vehicle(String licensePlate, String type, int size) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.size = size;
    }

    // Getters and setters
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Additional methods as needed
}
