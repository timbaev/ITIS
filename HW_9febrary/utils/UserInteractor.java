package CW_9Febrary.utils;

public interface UserInteractor {
    public String readCommand() throws UserInteractorReadException ;
    public String readAddCommand() throws UserInteractorReadException;
    public void print(String output) throws UserInteractorWriteException ;
    public boolean pickIputMethod() throws UserInteractorReadException;
}
