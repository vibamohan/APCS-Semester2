import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        File saveFile = new File("save.dat");

        if (saveFile.exists()) {
            loadTasks(tasks, saveFile);
        }

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Display tasks");
            System.out.println("2. Add task");
            System.out.println("3. Quit");
            System.out.print("Choice: ");

            String choice = input.nextLine();

            if (choice.equals("1")) {
                displayTasks(tasks);
            } else if (choice.equals("2")) {
                System.out.print("Task name: ");
                String name = input.nextLine();

                System.out.print("Task rank: ");
                int rank = Integer.parseInt(input.nextLine());

                tasks.add(new Task(rank, name));
                sortTasks(tasks);
            } else if (choice.equals("3")) {
                saveTasks(tasks, saveFile);
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }

    public static void loadTasks(ArrayList<Task> tasks, File saveFile) throws IOException {
        Scanner fileInput = new Scanner(saveFile);

        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();

            if (line.contains(":")) {
                String[] parts = line.split(":", 2);
                int rank = Integer.parseInt(parts[0]);
                String name = parts[1];
                tasks.add(new Task(rank, name));
            }
        }

        fileInput.close();
        sortTasks(tasks);
    }

    public static void displayTasks(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("No tasks saved.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public static void sortTasks(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size() - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < tasks.size(); j++) {
                if (tasks.get(j).getRank() < tasks.get(smallestIndex).getRank()) {
                    smallestIndex = j;
                }
            }

            Task temp = tasks.get(i);
            tasks.set(i, tasks.get(smallestIndex));
            tasks.set(smallestIndex, temp);
        }
    }

    public static void saveTasks(ArrayList<Task> tasks, File saveFile) throws IOException {
        FileWriter writer = new FileWriter(saveFile);

        for (Task task : tasks) {
            writer.write(task.toString());
            writer.write("\n");
        }

        writer.close();
    }
}
