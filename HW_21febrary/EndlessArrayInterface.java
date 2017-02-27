package HW_21febrary;

/**
 * Created by Timbaev on 21.02.2017.
 * Interface for EndlessArray
 */
public interface EndlessArrayInterface<T> {
    void add(T obj);
    T get(int position);
    void remove(int position);
    int size();
}
