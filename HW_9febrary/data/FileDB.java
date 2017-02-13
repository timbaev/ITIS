package CW_9Febrary.data;

import java.util.ArrayList;

public class FileDB implements Db {

    private ArrayList<Object> objects;

    public FileDB() {
        objects = new ArrayList<>();
    }

    @Override
    public void save(Object obj) throws DbException {
        objects.add(obj);
    }

    @Override
    public Object[] findAll() throws DbException {
        objects.add("Hello world!");
        return objects.toArray(new Object[objects.size()]);
    }

}
