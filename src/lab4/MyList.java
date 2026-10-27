package lab4;

import java.util.Collection;

public interface MyList<E> {
    void add(E e);
    void add(int index, E element);

    // wildcards (? extends E) за умовою завдання
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int index, Collection<? extends E> c);

    E get(int index);
    E remove(int index);
    void set(int index, E element);
    int indexOf(Object o);
    int size();
    Object[] toArray();
}