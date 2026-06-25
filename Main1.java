import java.util.Scanner;

public class Main1 {

    static boolean[] booked = new boolean[200];
    static String[] customer_name=new String[200];
    static String[] mobile=new String[200];
    Static String[] address=new String[200];
    Static String[] stayDays= new int[200];

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
            int typeIndex=(room-1)%4;

            System.out.println("Room Type:"+roomType[typeIndex]);
            System.out.println("Price/Day:Rs."+ price[typeIndex]);

            System.out.print("Enter Customer Name: "); 
           customer_name[room-1]=sc.nextLine();

            System.out.print("Enter the Mobile Number: ");
            mobile[room-1]=sc.nextLine();

            System.out print("Enter Adress: ");
            address[room-1]=sc.nextLine();

            System.out.print("Enter Number of Days to Stay: ");
            stayDays[room-1]=sc.nextInt();

            booked[room - 1] = true; 

            System.out.println("Room Booked Successfully!");
            System.out.println("Customer Name : "+ customer_name[room-1]);
            System.out.println("Room Number :"+ room);
            System.out.println("Room Type :"+ roomtype[typeIndex]);
            System.out.println("Stay Days :"+ stayDays[room-1]);
        } 
        else {
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
             System.out.println("Customer " + customerName[room - 1] + " checked out successfully.");

            booked[room - 1] = false;
            customerName[room - 1] = null;
            mobile[room - 1] = null;
            address[room - 1] = null;
            stayDays[room - 1] = 0;

           
        } 
        else {
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

            int typeIndex = (room - 1) % 4;
            int roomCharge = stayDays[room - 1] * price[typeIndex];
            double gst = roomCharge * 0.18;
            double totalBill = roomCharge + gst;

            System.out.println("\n----- BILL -----");
            System.out.println("Customer Name : " + customer_name[room - 1]);
            System.out.println("Mobile Number   : "+ mobile[room-1]);
            System.out.println("Room Number   : "+ room);
            System.out.println("Room Type     : "+ roomType[typeIndex]);
            System.out.println("Days Stayed   : "+ stayDays[room-1]);
            System.out.println("GST (18%) :Rs."+gst);
            System.out.println("Total Bill    : Rs."+ totalbill);

        } 
        else {
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