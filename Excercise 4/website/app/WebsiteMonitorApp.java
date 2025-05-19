package app;

import controller.WebsiteMonitor;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebsiteMonitorApp {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WebsiteMonitor monitor = new WebsiteMonitor(users);

        while (true) {
            System.out.println("\n=== Website Update Monitor ===");
            System.out.println("1. Register User");
            System.out.println("2. Add Website Subscription");
            System.out.println("3. Remove Website Subscription");
            System.out.println("4. View Subscriptions");
            System.out.println("5. Check for Updates");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerUser(scanner);
                case 2 -> addSubscription(scanner);
                case 3 -> removeSubscription(scanner);
                case 4 -> viewSubscriptions();
                case 5 -> monitor.checkWebsites();
                case 0 -> {
                    System.out.println("Exiting.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact (email/phone): ");
        String contact = scanner.nextLine();
        users.add(new User(name, contact));
        System.out.println("User registered.");
    }

    private static void addSubscription(Scanner scanner) {
        if (users.isEmpty()) {
            System.out.println("No users found. Register first.");
            return;
        }
        listUsers();
        System.out.print("Select user index: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        User user = users.get(index);

        System.out.print("Enter website URL: ");
        String url = scanner.nextLine();
        System.out.print("Enter frequency in minutes: ");
        int freq = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Select channel: 1) EMAIL 2) SMS 3) PUSH_NOTIFICATION");
        int channelOption = scanner.nextInt();
        scanner.nextLine();

        CommunicationChannel channel = switch (channelOption) {
            case 1 -> CommunicationChannel.EMAIL;
            case 2 -> CommunicationChannel.SMS;
            case 3 -> CommunicationChannel.PUSH_NOTIFICATION;
            default -> CommunicationChannel.EMAIL;
        };

        WebsiteSubscription sub = new WebsiteSubscription(url, freq, channel);
        user.addSubscription(sub);
        System.out.println("Subscription added.");
    }

    private static void removeSubscription(Scanner scanner) {
        listUsers();
        System.out.print("Select user index: ");
        int userIndex = scanner.nextInt();
        scanner.nextLine();
        User user = users.get(userIndex);

        List<WebsiteSubscription> subs = user.getSubscriptions();
        for (int i = 0; i < subs.size(); i++) {
            System.out.println(i + ". " + subs.get(i));
        }
        System.out.print("Select subscription index to remove: ");
        int subIndex = scanner.nextInt();
        scanner.nextLine();
        user.removeSubscription(subIndex);
        System.out.println("Subscription removed.");
    }

    private static void viewSubscriptions() {
        for (User user : users) {
            System.out.println("\nUser: " + user);
            for (WebsiteSubscription sub : user.getSubscriptions()) {
                System.out.println(" - " + sub);
            }
        }
    }

    private static void listUsers() {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + ". " + users.get(i));
        }
    }
}
