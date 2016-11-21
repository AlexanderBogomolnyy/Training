package ua.training.list;

import java.util.*;

/**
 * <p> The Array List implementation.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.11.2016.
 */
public class ArrayList<T> implements List<T> {

    private int size = 0;
    private int capacity = 10;
    private double resize = 1.5;
    private Object[] array = new Object[capacity];

    public ArrayList() {
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public ArrayList(Collection<T> collection) {
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }

    //Resize array of store elements if is is necessary
    private void resize(int shift) {
        if (size + shift >= array.length) {
            int newSize = (int) (array.length * resize + 1);
            Object[] result = new Object[newSize];
            System.arraycopy(array, 0, result, 0, size);
            array = result;
            resize(shift);
        }
    }

    @Override
    public boolean add(T t) {
        resize(1);
        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) return false;
        T removed = remove(index);
        return removed.equals(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        resize(c.size());
        for(T t: c)
            array[size++] = t;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndex(index);
        int shift = c.size();
        resize(shift);
        System.arraycopy(array, index, array, index + shift, size - index);
        int i = index;
        for (T element: c) {
            array[i++] = element;
        }
        size += shift;
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // checks index to keep in bounds
    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        if (index == size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        T old = (T) array[index];
        array[index] = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        resize(1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
        checkIndex(index);
        T old = (T) array[index];
        System.arraycopy(array,index + 1,array, index, size - index);
        size--;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (array[i]==null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(array[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIter(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    /**
     * This class provides Iterator for proposed implementation of Array List
     */
    private class Iter implements Iterator<T> {

        int current;
        int lastReturned = -1;

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public T next() {
            int i = current;
            if (i >= size)
                throw new NoSuchElementException();
            current = i + 1;
            return (T) array[lastReturned = i];
        }

        @Override
        public void remove() {
            if (lastReturned < 0)
                throw new IllegalStateException();
            ArrayList.this.remove(lastReturned);
            current = lastReturned;
            lastReturned = -1;
        }
    }

    /**
     * This class provides List Iterator for proposed implementation of Array List
     */
    private class ListIter extends Iter implements ListIterator<T> {

        ListIter(int index) {
            super();
            checkIndex(index);
            current = index;
        }

        @Override
        public boolean hasPrevious() {
            return current != 0;
        }

        @Override
        public T previous() {
            int i = current - 1;
            if (i < 0)
                throw new NoSuchElementException();
            current = i;
            return (T) array[lastReturned = i];
        }

        @Override
        public int nextIndex() {
            return current;
        }

        @Override
        public int previousIndex() {
            return current - 1;
        }

        @Override
        public void set(T t) {
            if (lastReturned < 0)
                throw new IllegalStateException();
            ArrayList.this.set(lastReturned, t);
        }

        @Override
        public void add(T t) {
            int i = current;
            ArrayList.this.add(i, t);
            current = i + 1;
            lastReturned = -1;
        }
    }
}
