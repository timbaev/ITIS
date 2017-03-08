package HW_2march;

import org.glassfish.grizzly.utils.ArrayUtils;

import java.util.*;

/**
 * Created by Timbaev on 02.03.2017.
 *
 */
public class ModifiableCollection<T> extends AbstractCollection<T> {
    private T[] objects;

    @SuppressWarnings("unchecked")
    public ModifiableCollection() {
        objects = (T[]) new Object[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) throw new NullPointerException();
        T[] newObjects = (T[]) new Object[objects.length + c.size()];
        T[] objectsCollection = (T[]) c.toArray();
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        System.arraycopy(objectsCollection, 0, newObjects, objects.length, objectsCollection.length);
        objects = newObjects;
        return true;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] newObjects = (T[]) new Object[0];
        objects = newObjects;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException();
        for (T object : objects) {
            if (object.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() == 0) throw new NullPointerException();
        int count = 0;
        int size = c.size();
        Iterator<?> collectionIterator = c.iterator();
        while (collectionIterator.hasNext()) {
            T object = (T) collectionIterator.next();
            for (int i = 0; i < objects.length; i++) {
                if (objects[i].equals(object)) {
                    count++;
                }
            }
        }
        return count == size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(objects);
        return result;
    }

    @Override
    public boolean isEmpty() {
        return objects.length == 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) throw new NullPointerException();
        boolean modified = false;
        for (T object : this) {
            if (c.contains(object)) {
                modified = true;
                remove(object);
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() == 0) throw new NullPointerException();
        boolean modified = false;
        for (T object : this) {
            if (!c.contains(object)) {
                remove(object);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public Object[] toArray() {
        return objects;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <A> A[] toArray(A[] a) {
        if (a.length == 0) throw new NullPointerException();
        T[] newObjects = Arrays.copyOf(objects, objects.length);
        for (int i = 0; i < newObjects.length; i++) {
            if (!containElementArray(a, newObjects[i])) {
                newObjects = ArrayUtils.remove(newObjects, newObjects[i]);
            }
        }
        return (A[]) newObjects;
    }

    private <A> boolean containElementArray(A[] array, T object) {
        for (A anArray : array) {
            if (anArray.equals(object)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(T object) {
        if (object == null) throw new NullPointerException();
        @SuppressWarnings("unchecked")
        T[] newObjects = (T[]) new Object[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[newObjects.length - 1] = object;
        objects = newObjects;
        return true;
    }

    public T get(int position) {
        return objects[position];
    }

    public boolean remove(Object object) {
        if (object == null) throw new NullPointerException();
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(object)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicModifiableCollectionIterator();
    }

    @Override
    public int size() {
        return objects.length;
    }

    private class BasicModifiableCollectionIterator implements Iterator<T> {
        int position;

        private BasicModifiableCollectionIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < objects.length;
        }

        @Override
        public T next() {
            if (position > objects.length) throw new NoSuchElementException();
            T object = objects[position];
            position++;
            return object;
        }

        @Override
        public void remove() {
            @SuppressWarnings("unchecked")
            T[] newOBjects = (T[]) new Object[objects.length - 1];
            System.arraycopy(objects, 0, newOBjects, 0, position);
            System.arraycopy(objects, position + 1, newOBjects, position, newOBjects.length - 1);
            objects = newOBjects;
        }
    }
}