package campus.infrastructure;

import campus.exceptions.CampusException;
import campus.tasks.Task;

/**
 * Deals with interactions with the User
 */
public class Ui {
    public String greet() {
        String message = "------------------------------\n"
                + "Hello! I'm Campus\n"
                + "What can I do for you?\n"
                + "\n"
                + "------------------------------\n";

        return message;
    }

    public String exit() {
        String message = "------------------------------\n"
                + "Bye. Hope to see you again soon!\n"
                + "\n"
                + "------------------------------\n";
        return message;
    }

    /**
     * Displays all the current items in the TaskList in a specified format with numbering
     * @param taskList the object containing all the tasks in a list
     */
    public String display(TaskList taskList) {
        int numOfTasks = taskList.size();
        StringBuilder listOfTasks = new StringBuilder();
        for (int i = 0; i < numOfTasks; i++) {
            int listNum = i + 1;
            Task task = taskList.getIthTaskInteger(i);
            listOfTasks.append(String.format("%s. %s\n", listNum, task.toString()));
        }

        String message = "------------------------------\n"
                + String.format("%s\n", listOfTasks)
                + "------------------------------\n";

        return message;
    }

    public String markDone(Task task) {
        String message = "------------------------------\n"
                + "Nice! I've completed this task successfully:\n"
                + String.format("%s\n", task)
                + "------------------------------\n";

        return message;
    }

    public String markUndone(Task task) {
        String message = "------------------------------\n"
                + "Ok, this task is still not done yet:\n"
                + String.format("%s\n", task)
                + "------------------------------\n";

        return message;
    }

    public String delete(TaskList taskList, Task task) {
        int numOfTasks = taskList.size();

        String message = "------------------------------\n"
                + "Noted. Task deleted successfully. I have removed the following task:\n"
                + String.format("%s\n", task)
                + String.format("Now you have %s task(s) in the list.\n", numOfTasks)
                + "------------------------------\n";

        return message;
    }

    public String add(TaskList taskList, Task task) {
        int numOfTasks = taskList.size();

        String message = "------------------------------\n"
                + "Got it. I've added this to our list of tasks:\n"
                + String.format("added: %s\n", task.toString())
                + String.format("Now you have %s task(s) in the list.\n", numOfTasks)
                + "------------------------------\n";

        return message;
    }

    public String displayErrorMessage(CampusException e) {
        String message = "------------------------------\n"
                + String.format("%s\n", e.getMessage())
                + "------------------------------\n";
        return message;
    }
}
