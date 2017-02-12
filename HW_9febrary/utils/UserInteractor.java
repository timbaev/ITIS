public interface UserInteractor {
    public String readCommand() throws UserInteractorReadException ;
    public String readAddCommand() throws UserInteractorReadException;
    public void print(String output) throws UserInteractorWriteException ;
}
