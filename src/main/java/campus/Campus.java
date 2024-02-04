package campus;

import campus.infrastructure.Parser;
import campus.infrastructure.Storage;
import campus.infrastructure.TaskList;
import campus.infrastructure.Ui;

/**
 * Contains the logic for the ChatBot named 'Campus'
 */
public class Campus {
    private final Ui ui;
    private final Parser parser;

    /**
     * Creation of a Campus instance
     */
    public Campus() {
        String filePath = "src/test/java/campus/dataTest.txt";
        this.ui = new Ui();
        TaskList taskList = new TaskList();
        Storage storage = new Storage(filePath);
        this.parser = new Parser(this.ui, taskList, storage);
    }

    /**
     * Main Driver Logic for the CampusBot - greet and exit are just sanity, main logic works in parser.listen()
     */
    public void run() {
        this.ui.greet();
        this.parser.listen();
        this.ui.exit();
    }

    public static void main(String[] args) {
        new Campus().run();
    }

    public String getResponse(String input) {
        return "Campus heard: " + input;
    }
}
