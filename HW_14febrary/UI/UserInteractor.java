package HW_14febrary.UI;

import HW_14febrary.UI.exceptions.UserInteractorInputException;
import HW_14febrary.UI.exceptions.UserInteractorReadException;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public interface UserInteractor {
    public String readCommand() throws UserInteractorReadException;
    public String readKeyword() throws UserInteractorReadException;
    public int readTrackNumber() throws UserInteractorInputException;
}
