package campus.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Class object which represents a Task, which has a name and a status completion.
 */
public abstract class Task {
    public boolean isCompleted;
    public String taskName;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm dd/MM/yyyy");

    /**
     * Checks to see if the input string is of the correct format pattern.
     * @param input timedate string.
     * @param formatter HHmm dd/MM/yyyy.
     * @return true if yes, false if no.
     */
    public static boolean isValidDateTimeFormat(String input, DateTimeFormatter formatter) {
        try {
            LocalDateTime.parse(input, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public abstract void markComplete();

    public abstract void markIncomplete();

    public abstract String toDbFormat();
}
