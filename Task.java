public class Task {
    private String name;
    private String dueDate;

    public Task(String name, String dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public String toString() {
        return name + " (Due: " + dueDate + ")";
    }

    public String toFileFormat() {
        return name + ";" + dueDate;
    }

    public static Task fromFileFormat(String line) {
        String[] parts = line.split(";");
        return new Task(parts[0], parts[1]);
    }
}
