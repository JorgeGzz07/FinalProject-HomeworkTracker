import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveTasks(ArrayList<Task> tasks, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks(String filename) {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromFileFormat(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading data (probably first run): " + e.getMessage());
        }
        return tasks;
    }
}
