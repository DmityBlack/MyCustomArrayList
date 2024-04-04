package mycustomarraylist;

import java.util.Collection;
import java.util.Comparator;



public interface ArrayList <E> {
    void add(E e);
    void add(int index, E e);
    boolean addAll(Collection<? extends E> c);
    void clear();
    E get(int index);
    boolean isEmpty();
    boolean remove(int index);
    boolean remove(Object o);
    void sort(Comparator<? super E> c);
}
