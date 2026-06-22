import java.util.Scanner;

public class Main1 {

    static boolean[] booked = new boolean[200];
    static String[] customer = new String[200];

    static String[] roomType = {
            "AC Single",
            "AC Double",
            "Non-AC Single",
            "Non-AC Double"
    };

    static int[] price = {12000, 18000, 5000, 8000};

    public static void viewRooms() {

        System.out.println("\n----- ROOM DETAILS -----");

        for (int i = 0; i < 200; i++) {

            int typeIndex = i % 4;

            System.out.print("Room " + (i + 1) + " | "
                    + roomType[typeIndex] + " | Rs."
                    + price[typeIndex]);

            if (booked[i]) {
                System.out.println(" | Booked");
            } else {
                System.out.println(" | Available");
            }
        }
    }

    public static void bookRoom(Scanner sc) {

        System.out.print("Enter Room Number (1-200): ");
        int room = sc.nextInt();
        sc.nextLine();

        if (room < 1 || room > 200) {
            System.out.println("Invalid Room Number!");
            return;
        }

        if (!booked[room - 1]) {

            System.out.print("Enter Customer Name: ");
            customer[room - 1] = sc.nextLine();

            booked[room - 1] = true;

            System.out.println("Room Booked Successfully!");

        } else {
            System.out.println("Room Already Booked!");
        }
    }

    public static void checkout(Scanner sc) {

        System.out.print("Enter Room Number (1-200): ");
        int room = sc.nextInt();

        if (room < 1 || room > 200) {
            System.out.println("Invalid Room Number!");
            return;
        }

        if (booked[room - 1]) {

            booked[room - 1] = false;
            customer[room - 1] = null;

            System.out.println("Checkout Successful!");

        } else {
            System.out.println("Room Not Booked!");
        }
    }

    public static void generateBill(Scanner sc) {

        System.out.print("Enter Room Number (1-200): ");
        int room = sc.nextInt();

        if (room < 1 || room > 200) {
            System.out.println("Invalid Room Number!");
            return;
        }

        if (booked[room - 1]) {

            System.out.print("Enter Number of Days: ");
            int days = sc.nextInt();

            int typeIndex = (room - 1) % 4;

            int bill = days * price[typeIndex];

            System.out.println("\n----- BILL -----");
            System.out.println("Customer Name : "
                    + customer[room - 1]);
            System.out.println("Room Number   : "
                    + room);
            System.out.println("Room Type     : "
                    + roomType[typeIndex]);
            System.out.println("Days Stayed   : "
                    + days);
            System.out.println("Total Bill    : Rs."
                    + bill);

        } else {
            System.out.println("Room Not Booked!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n--- USER MENU ---");
                    System.out.println("1. View Rooms");
                    System.out.println("2. Book Room");

                    System.out.print("Enter Choice: ");
                    int userChoice = sc.nextInt();

                    if (userChoice == 1) {
                        viewRooms();
                    } else if (userChoice == 2) {
                        bookRoom(sc);
                    } else {
                        System.out.println("Invalid Choice!");
                    }

                    break;

                case 2:

                    System.out.print("Enter Admin Password: ");
                    String pass = sc.next();

                    if (pass.equals("admin123")) {

                        System.out.println("\n--- ADMIN MENU ---");
                        System.out.println("1. Check Out");
                        System.out.println("2. Generate Bill");

                        System.out.print("Enter Choice: ");
                        int adminChoice = sc.nextInt();

                        if (adminChoice == 1) {
                            checkout(sc);
                        } else if (adminChoice == 2) {
                            generateBill(sc);
                        } else {
                            System.out.println("Invalid Choice!");
                        }

                    } else {
                        System.out.println("Wrong Password!");
                    }

                    break;

                case 3:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}