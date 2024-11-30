package Task_Traker.src;
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        if (args.length < 1) {
            System.out.println("Usage: task-cli <command> [options]");
            return;
        }

        String command = args[0];
        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: task-cli add <description>");
                } else {
                    manager.addTask(args[1]);
                }
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: task-cli update <id> <new description>");
                } else {
                    int id = Integer.parseInt(args[1]);
                    manager.updateTask(id, args[2]);
                }
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: task-cli delete <id>");
                } else {
                    int id = Integer.parseInt(args[1]);
                    manager.deleteTask(id);
                }
                break;
            case "list":
                String status = args.length > 1 ? args[1] : null;
                manager.listTasks(status);
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
