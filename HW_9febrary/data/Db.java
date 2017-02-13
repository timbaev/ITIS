package CW_9Febrary.data;

public interface Db {
    public void save(Object obj) throws DbException;
    public Object[] findAll() throws DbException;
}
