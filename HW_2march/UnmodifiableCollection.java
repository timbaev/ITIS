package HW_2march;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Timbaev on 21.02.2017.
 * It is my cool ArrayList
 */
class UnmodifiableCollection<T> extends AbstractCollection<T> {
    private T[] objects;

    @SuppressWarnings("unchecked")
    public UnmodifiableCollection(Collection<T> collection) {
        objects = (T[]) new Object[collection.size()];
        Iterator<T> iterator = collection.iterator();
        int position = 0;
        while (iterator.hasNext()) {
            objects[position] = iterator.next();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicUnmodifiableCollectionIterator();
    }

    @Override
    public int size() {
        return objects.length;
    }

    private class BasicUnmodifiableCollectionIterator implements Iterator<T> {
        int position;

        private BasicUnmodifiableCollectionIterator() {
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
    }
}
