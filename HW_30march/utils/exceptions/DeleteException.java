package HW_30march.utils.exceptions;

/**
 * Created by Timbaev on 12.04.2017.
 */
public class DeleteException extends FileManagerException {
    public DeleteException() {
        super();
    }

    public DeleteException(String msg) {
        super(msg);
    }
}
