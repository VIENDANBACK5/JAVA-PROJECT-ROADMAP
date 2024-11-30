package Task_Traker.src;

import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final String filePath = "tasks.json";

    public TaskManager() {
        loadTasks();
    }

    // Thêm công việc mới
    public void addTask(String description) {
        int newId = tasks.size() + 1;
        Task task = new Task(newId, description);
        tasks.add(task);
        saveTasks();
        System.out.println("Task added successfully (ID: " + newId + ")");
    }

    // Cập nhật công việc
    public void updateTask(int id, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(newDescription);
                saveTasks();
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // Xóa công việc
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        saveTasks();
        System.out.println("Task deleted successfully.");
    }

    // Danh sách công việc theo trạng thái
    public void listTasks(String status) {
        tasks.stream()
            .filter(task -> status == null || task.getStatus().equalsIgnoreCase(status))
            .forEach(System.out::println);
    }

    // Lưu dữ liệu vào tệp JSON
    private void saveTasks() {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Tải dữ liệu từ tệp JSON
    private void loadTasks() {
        try (Reader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            tasks = gson.fromJson(reader, new TypeToken<List<Task>>() {}.getType());
            if (tasks == null) tasks = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("No existing tasks found. Starting fresh.");
        }
    }
}
