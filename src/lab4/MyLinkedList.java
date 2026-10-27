package lab4;

import java.util.Collection;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(E e) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(l, e, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);
        } else {
            Node<E> target = node(index);
            final Node<E> pred = target.prev;
            final Node<E> newNode = new Node<>(pred, element, target);
            target.prev = newNode;
            if (pred == null)
                head = newNode;
            else
                pred.next = newNode;
            size++;
        }
    }

    // реалізація wildcard
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null || c.isEmpty()) return false;
        for (E element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (c == null || c.isEmpty()) return false;
        int currentIndex = index;
        for (E element : c) {
            add(currentIndex++, element);
        }
        return true;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public E remove(int index) {
        Node<E> target = node(index);
        final E element = target.item;
        final Node<E> next = target.next;
        final Node<E> prev = target.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            target.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            target.next = null;
        }

        target.item = null;
        size--;
        return element;
    }

    @Override
    public void set(int index, E element) {
        Node<E> target = node(index);
        target.item = element;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            if (o == null ? x.item == null : o.equals(x.item))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    private Node<E> node(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (index < (size >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
}