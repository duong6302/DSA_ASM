import java.util.Scanner;

public class QueueMessageApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue(100);
        Stack stack = new Stack(100);

        while (true) {
            try {
                System.out.println("1. Input message");
                System.out.println("2. Send Message");
                System.out.println("3. Received message / View message");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Enter the message (less than 250 characters): ");
                    String msg = scanner.nextLine();
                    if (msg.length() <= 250) {
                        queue.enqueue(msg);
                    } else {
                        System.out.println("Error: Message exceeds 250 characters.");
                    }

                } else if (choice == 2) {
                    while (!queue.isEmpty()) {
                        String message = queue.dequeue();
                        stack.push(message);
                        System.out.println("Sending message: " + message);
                    }

                } else if (choice == 3) {
                    System.out.println("Received messages:");
                    while (!stack.isEmpty()) {
                        String message = stack.pop();
                        System.out.println(message);
                    }

                } else if (choice == 4) {
                    break;

                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
