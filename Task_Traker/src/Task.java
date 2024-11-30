package Task_Traker.src;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private String status; // "todo", "in-progress", "done"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo"; // Default status
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters và Setters
    public int getId() { 
        return id; 
    }
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
    public LocalDateTime getUpdatedAt() { 
        return updatedAt; 
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
