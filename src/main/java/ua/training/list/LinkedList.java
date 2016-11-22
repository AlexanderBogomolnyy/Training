package ua.training.list;

import java.util.*;

/**
 * <p> The Linked List implementation.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class LinkedList<E> implements List<E>{
    private Node<E> first;
    private Node<E> last;

    private int size = 0;
    private int modCount = 0;

    public LinkedList() {
        first = null;
        last = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(E data) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, data, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.previous = newNode;
        size++;
        modCount++;
    }

    public void addLast(E data) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, data, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        final E element = f.data;
        final Node<E> next = f.next;
        f.data = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.previous = null;
        size--;
        modCount++;
        return element;
    }

    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        final E element = l.data;
        final Node<E> previous = l.previous;
        l.data = null;
        l.previous = null;
        last = previous;
        if (previous == null)
            first = null;
        else
            previous.next = null;
        size--;
        modCount++;
        return element;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.data == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (o.equals(node.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> node = last; node != null; node = node.previous) {
                index--;
                if (node.data == null)
                    return index;
            }
        } else {
            for (Node<E> node = last; node != null; node = node.previous) {
                index--;
                if (o.equals(node.data))
                    return index;
            }
        }
        return -1;
    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = search(index);
        E oldData = x.data;
        x.data = element;
        return oldData;
    }

    @Override
    public void add(int index, E element) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));

        if (index == size)
            addLast(element);
        else {
            Node<E> node = search(index);
            final Node<E> early = node.previous;
            final Node<E> newNode = new Node<>(early, element, node);
            node.previous = newNode;
            if (early == null)
                first = newNode;
            else
                early.next = newNode;
            size++;
            modCount++;
        }
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        Node<E> node = search(index);
        return node.data;
    }

    @Override
    public void clear() {
        for (Node<E> node = first; node != null; ) {
            Node<E> next = node.next;
            node.data = null;
            node.next = null;
            node.previous = null;
            node = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.data == null) {
                    dropLink(node);
                    return true;
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (o.equals(node.data)) {
                    dropLink(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public E remove(int index) {
        checkElementIndex(index);
        return dropLink(search(index));
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> node = first; node != null; node = node.next)
            result[i++] = node.data;
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            throw new IllegalArgumentException("Array has too small size.");
        int i = 0;
        Object[] result = a;
        for (Node<E> node = first; node != null; node = node.next)
            result[i++] = node.data;
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
        return new ListIter(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    // drops links for current node, returns old value
    private E dropLink(Node<E> drop) {
        final E element = drop.data;
        final Node<E> next = drop.next;
        final Node<E> previous = drop.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            drop.previous = null;
        }

        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            drop.next = null;
        }

        drop.data = null;
        size--;
        modCount++;
        return element;
    }

    // look for node by index
    private Node<E> search(int index) {
        if (index < (size/2)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--)
                node = node.previous;
            return node;
        }
    }

    // checking for IndexOutOfBoundsException
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
    }

    // IndexOutOfBoundsException message
    private String outOfBoundsMessage(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    /**
     * This class provides node for linked list
     *
     * @param <E> - generic
     */
    private static class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        Node(Node<E> previous, E element, Node<E> next) {
            this.data = element;
            this.next = next;
            this.previous = previous;
        }
    }

    /**
     * This class provides Iterator for proposed implementation of Array List
     */
    private class Iter implements Iterator<E> {

        int current = 0;

        int lastReturned = -1;

        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return current != size();
        }

        @Override
        public E next() {
            checkForConcurrentModification();
            try {
                int i = current;
                E next = get(i);
                lastReturned = i;
                current = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForConcurrentModification();
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (lastReturned < 0)
                throw new IllegalStateException();
            checkForConcurrentModification();

            try {
                LinkedList.this.remove(lastReturned);
                if (lastReturned < current)
                    current--;
                lastReturned = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        private void checkForConcurrentModification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }


    /**
     * This class provides List Iterator for proposed implementation of Array List
     */
    private class ListIter implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListIter(int index) {
            next = (index == size) ? null : search(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            checkForConcurrentModification();
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            checkForConcurrentModification();
            if (!hasPrevious())
                throw new NoSuchElementException();
            lastReturned = next = (next == null) ? last : next.previous;
            nextIndex--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            checkForConcurrentModification();
            if (lastReturned == null)
                throw new IllegalStateException();
            Node<E> lastNext = lastReturned.next;
            dropLink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForConcurrentModification();
            lastReturned.data = e;
        }

        @Override
        public void add(E e) {
            checkForConcurrentModification();
            lastReturned = null;
            if (next == null) {
                final Node<E> l = last;
                final Node<E> newNode = new Node<>(l, e, null);
                last = newNode;
                if (l == null)
                    first = newNode;
                else
                    l.next = newNode;
                size++;
                modCount++;
            } else {
                final Node<E> early = next.previous;
                final Node<E> newNode = new Node<>(early, e, next);
                next.previous = newNode;
                if (early == null)
                    first = newNode;
                else
                    early.next = newNode;
                size++;
                modCount++;
            }
            nextIndex++;
            expectedModCount++;
        }

        private void checkForConcurrentModification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

}
