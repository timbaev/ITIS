package HW_21febrary;

/**
 * Created by Timbaev on 21.02.2017.
 * It is my cool ArrayList
 */
public class EndlessArray<T> implements EndlessArrayInterface<T> {
    private T[] objects;

    @SuppressWarnings("unchecked")
    public EndlessArray() {
        objects = (T[]) new Object[0];
    }

    public void add(T obj) {
        @SuppressWarnings("unchecked")
        T[] newObjects = (T[]) new Object[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[newObjects.length - 1] = obj;
        objects = newObjects;
    }

    public T get(int position) {
        return objects[position];
    }

    public void remove(int position) {
        @SuppressWarnings("unchecked")
        T[] newOBjects = (T[]) new Object[objects.length - 1];
        System.arraycopy(objects, 0, newOBjects, 0, position);
        System.arraycopy(objects, position + 1, newOBjects, position, newOBjects.length - 1);
        objects = newOBjects;
    }

    @Override
    public int size() {
        return objects.length;
    }

}
