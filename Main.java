import java.util.*;
class Bank {
    private String username;
    private long accountNumber;
    private String accountName;
    private String accountType;
    private static List<Bank> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Bank(String username) 
    {
        this.username = username;
    }

    public Bank(String username, long accountNumber, String accountName, String accountType) 
    {
        this.username = username;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountDetails(long accountNumber, String accountName, String accountType) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
    }

    static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        for (Bank user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists! Try a different one.");
                return;
            }
        }
        Bank newUser = new Bank(username);
        users.add(newUser);
        System.out.println("User registered successfully.");
    }

    static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        for (Bank user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("User " + username + " logged in successfully.");
                return;
            }
        }
        System.out.println("User not found! Please register first.");
    }

    static void addAccount() {
        System.out.print("Enter username: ");
        String username = scanner.next();
    
        for (Bank user : users) {
            if (user.getUsername().equals(username) && user.getAccountNumber() == 0) {
                System.out.print("Enter account number: ");
                long accountNumber = scanner.nextLong();
                System.out.print("Enter account name: ");
                String accountName = scanner.next();
                System.out.print("Enter account type (Savings/Checking): ");
                String accountType = scanner.next();
                user.setAccountDetails(accountNumber, accountName, accountType);
                System.out.println("Account added successfully.");
                return;
            }
        }
        System.out.println("User not found or already has an account.");
    }
    
    static void viewAccountDetails() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        for (Bank user : users) {
            if (user.getUsername().equals(username) && user.getAccountNumber() != 0) {
                System.out.println("Account Number: " + user.getAccountNumber());
                System.out.println("Account Name: " + user.getAccountName());
                System.out.println("Account Type: " + user.getAccountType());
                return;
            }
        }
        System.out.println("No account found for user " + username);
    }

    static void adminPortal() {
        System.out.print("Enter admin password: ");
        String adminPass = scanner.next();
        if (!adminPass.equals("admin")) {
            System.out.println("Invalid admin password! Access denied.");
            return;
        }

        while (true) {
            System.out.println("\nAdmin Panel:");
            System.out.println("1. View all users");
            System.out.println("2. View all accounts");
            System.out.println("3. Delete user");
            System.out.println("4. Delete account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    static void viewAllUsers() {
        System.out.println("All registered users:");
        for (Bank user : users) {
            System.out.println(user.getUsername());
        }
    }
    static void viewAllAccounts() {
        System.out.println("All bank accounts:");
        for (Bank user : users) {
            if (user.getAccountNumber() != 0) {
                System.out.println(user.getAccountNumber() + " - " + user.getAccountName() + " (" + user.getAccountType() + ")");
            }
        }
    }

    static void deleteUser() {
        System.out.print("Enter username to delete: ");
        String username = scanner.next();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                users.remove(i);
                System.out.println("User " + username + " deleted successfully.");
                return;
            }
        }
        System.out.println("User not found.");
    }

    static void deleteAccount() {
        System.out.print("Enter account number to delete: ");
        long accountNumber = scanner.nextLong();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getAccountNumber() == accountNumber) {
                users.remove(i);
                System.out.println("Account " + accountNumber + " deleted successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank System Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add bank account");
            System.out.println("4. View account details");
            System.out.println("5. Admin Login");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Bank.registerUser();
                    break;
                case 2:
                    Bank.loginUser();
                    break;
                case 3:
                    Bank.addAccount();
                    break;
                case 4:
                    Bank.viewAccountDetails();
                    break;
                case 5:
                    Bank.adminPortal();
                    break;
                case 6:
                    System.out.println("Exiting system.... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

