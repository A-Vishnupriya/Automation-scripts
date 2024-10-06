//Package Delivery Tracking System
//This system can be used to track the delivery status of a package. Each package has an ID and goes through various stages of delivery.


import java.util.HashMap;
import java.util.Scanner;

class Package {
    private String packageID;
    private String status;

    public Package(String packageID) {
        this.packageID = packageID;
        this.status = "Order Placed";
    }

    public String getPackageID() {
        return packageID;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}

public class PackageTrackingSystem {
    private static HashMap<String, Package> packages = new HashMap<>();

    // Method to add a package
    public static void addPackage(String packageID) {
        Package newPackage = new Package(packageID);
        packages.put(packageID, newPackage);
        System.out.println("Package with ID: " + packageID + " added to the system.");
    }

    // Method to update package status
    public static void updatePackageStatus(String packageID, String status) {
        if (packages.containsKey(packageID)) {
            Package p = packages.get(packageID);
            p.updateStatus(status);
            System.out.println("Status for package " + packageID + " updated to: " + status);
        } else {
            System.out.println("Package with ID: " + packageID + " not found.");
        }
    }

    // Method to check package status
    public static void checkPackageStatus(String packageID) {
        if (packages.containsKey(packageID)) {
            System.out.println("Status for package " + packageID + ": " + packages.get(packageID).getStatus());
        } else {
            System.out.println("Package with ID: " + packageID + " not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        do {
            System.out.println("\nPackage Tracking System Menu");
            System.out.println("1. Add Package");
            System.out.println("2. Update Package Status");
            System.out.println("3. Check Package Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter package ID: ");
                    String packageID = scanner.nextLine();
                    addPackage(packageID);
                    break;
                case 2:
                    System.out.print("Enter package ID: ");
                    packageID = scanner.nextLine();
                    System.out.print("Enter new status (e.g., 'Shipped', 'Out for Delivery', 'Delivered'): ");
                    String status = scanner.nextLine();
                    updatePackageStatus(packageID, status);
                    break;
                case 3:
                    System.out.print("Enter package ID to check status: ");
                    packageID = scanner.nextLine();
                    checkPackageStatus(packageID);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the Package Tracking System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
