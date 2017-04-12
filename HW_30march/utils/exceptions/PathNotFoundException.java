package HW_30march.utils.exceptions;

/**
 * Created by Timbaev on 12.04.2017.
 */
public class PathNotFoundException extends FileManagerException {

    public PathNotFoundException() {
        super();
    }

    public PathNotFoundException(String msg) {
        super(msg);
    }
}
