package CW_9Febrary;

import CW_9Febrary.data.Db;
import CW_9Febrary.data.DbException;
import CW_9Febrary.data.FileDB;
import CW_9Febrary.recognizer.VoiceInput;
import CW_9Febrary.utils.*;

import java.util.Arrays;

public class App extends Application{

    private UserInteractor terminal;
    private Db db;
    private VoiceInput voiceInput;

    public static void main(String[] args) {
        App app = new App(args);
    }

    private App(String[] args) {
        super(args);
    }

    @Override
    public void init() {
        this.terminal = new TerminalUserInteractor();
        this.db = new FileDB();
        this.voiceInput = new VoiceInput();
        System.setProperty("console.encoding","Cp866");
    }

    @Override
    public void start() {
        try {
            String command;
            while((command = this.voiceInput.getCommand()) != null){
                System.out.println("You command is: " + command);
                switch(command){
                    case "read all":
                        //this.terminal.print(Arrays.toString(this.db.findAll()));
                        this.voiceInput.sayText(this.db.findAll());
                        break;
                    case "save":
                        if((command = this.terminal.readAddCommand()) != null) {
                            this.db.save(command);
                        }
                        break;
                    default:
                        this.terminal.print("Unkown command");
                }
            }
        } catch (UserInteractorReadException ex) {
            System.out.println("Can't read user input due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (UserInteractorWriteException ex) {
            System.out.println("Can't print data to user due error:");
            System.err.println(ex.getMessage());
            System.exit(1);
        } catch (DbException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

}
