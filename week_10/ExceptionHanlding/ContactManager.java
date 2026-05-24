import java.io.*;
import java.util.Scanner;

public class ContactManager {
    private static final String FILE_NAME = "phone.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createFileIfNotExists();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n=== Phone Contact Manager ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    System.out.println("Exiting program. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Error: Invalid input. Please choose a number between 1 and 5.");
            }
        }
        scanner.close();
    }
    // 1. Function to add a new contact with validation
    private static void createFileIfNotExists() {
        try {
            File file = new File(FILE_NAME);
            if (file.createNewFile()) {
                System.out.println("System: Initialized new " + FILE_NAME + " file.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            System.out.println("Error: Name and Phone number cannot be empty.");
            return; // Stop the process and go back to menu
        }

        if (!phone.matches("[0-9]+")) {
            System.out.println("Error: Phone number must contain only numbers.");
            return;
        }

        if (isDuplicatePhone(phone)) {
            System.out.println("Error: The phone number " + phone + " already exists in contacts.");
            return;
        }

        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            bw.write(name + " - " + phone);
            bw.newLine(); // Move cursor to the next line for future data
            System.out.println("Success: Contact saved!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static boolean isDuplicatePhone(String phone) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                // Index 1 contains the phone number
                if (parts.length == 2 && parts[1].equals(phone)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }

    // 2. Function to view all saved contacts
    private static void viewContacts() {
        System.out.println("\n--- All Contacts ---");
        boolean isEmpty = true;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            // Read line by line until end of file (null)
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                isEmpty = false;
            }
            if (isEmpty) {
                System.out.println("No contacts found. The phonebook is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("--------------------");
    }

    // 3. Function to search contact by name or phone number
    private static void searchContact() {
        System.out.print("Enter name or phone number to search: ");
        // Convert input to lowercase to make search case-insensitive
        String keyword = scanner.nextLine().toLowerCase().trim();
        boolean found = false;

        System.out.println("\n--- Search Results ---");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the line contains the keyword
                if (line.toLowerCase().contains(keyword)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No matching contact found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("----------------------");
    }

    // 4. Function to delete a contact
    private static void deleteContact() {
        System.out.print("Enter the exact phone number of the contact to delete: ");
        String phoneToDelete = scanner.nextLine().trim();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("phone_temp.txt");
        boolean isDeleted = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2 && parts[1].equals(phoneToDelete)) {
                    isDeleted = true;
                    continue; 
                }
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }

        // Replace original file with the updated temp file
        if (isDeleted) {
            if (inputFile.delete() && tempFile.renameTo(inputFile)) {
                System.out.println("Success: Contact successfully deleted.");
            } else {
                System.out.println("Error: Failed to update the file after deletion.");
            }
        } else {
            System.out.println("Error: Contact with phone number " + phoneToDelete + " not found.");
            tempFile.delete(); // Delete the unused temp file
        }
    }
}