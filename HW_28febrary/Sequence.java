package HW_28febrary;

public interface Sequence<T> {
    void add(T obj);
    T pop();
    T peek();
    int size();
}
