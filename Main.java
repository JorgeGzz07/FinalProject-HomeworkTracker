import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Task> pendingTasks = new ArrayList<>();
    static Task[] completedTasks = new Task[100];
    static int completedCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        pendingTasks = FileHandler.loadTasks("pending.txt");

        System.out.println("== Homework Task Tracker ==");

        while (true) {
            printMenu();
            int choice = getUserInput(scanner);

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    completeTask(scanner);
                    break;
                case 4:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Save and Exit");
        System.out.print("Choose an option: ");
    }

    public static int getUserInput(Scanner scanner) {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getUserInput(scanner); // Recursive call
        }
    }

    public static void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter due date (e.g. 07/05): ");
        String dueDate = scanner.nextLine();
        pendingTasks.add(new Task(name, dueDate));
        System.out.println("Task added!");
    }

    public static void listTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            System.out.println("Pending Tasks:");
            for (int i = 0; i < pendingTasks.size(); i++) {
                System.out.println((i + 1) + ". " + pendingTasks.get(i));
            }
        }

        if (completedCount > 0) {
            System.out.println("Completed Tasks:");
            for (int i = 0; i < completedCount; i++) {
                System.out.println("- " + completedTasks[i]);
            }
        }
    }

    public static void completeTask(Scanner scanner) {
        listTasks();
        System.out.print("Enter the number of the task to mark as complete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < pendingTasks.size()) {
                completedTasks[completedCount++] = pendingTasks.remove(index);
                System.out.println("Task marked as completed.");
            } else {
                System.out.println("Invalid index.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void exitProgram() {
        FileHandler.saveTasks(pendingTasks, "pending.txt");

        // Save completed to file
        ArrayList<Task> completedList = new ArrayList<>();
        for (int i = 0; i < completedCount; i++) {
            completedList.add(completedTasks[i]);
        }
        FileHandler.saveTasks(completedList, "completed.txt");

        System.out.println("Tasks saved. Goodbye!");
        System.exit(0);
    }
}
