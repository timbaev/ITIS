package HW_28febrary;

public class Queue<T> implements Sequence<T> {

    private T[] objects;

    @SuppressWarnings("unchecked")
    public Queue() {
        objects = (T[]) new Object[0];
    }

    @Override
    public void add(T obj) {
        @SuppressWarnings("unchecked")
        T[] newObjects = (T[]) new Object[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[newObjects.length - 1] = obj;
        objects = newObjects;
    }

    @Override
    public T pop() {
        if (objects.length != 0) {
            T obj = objects[0];
            @SuppressWarnings("unchecked")
            T[] newOBjects = (T[]) new Object[objects.length - 1];
            System.arraycopy(objects, 1, newOBjects, 0, newOBjects.length);
            objects = newOBjects;
            return obj;
        } else {
            return null;
        }
    }

    @Override
    public T peek() {
        if (objects.length != 0) {
            return objects[0];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return objects.length;
    }
}
