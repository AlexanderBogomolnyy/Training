package ua.training.hashmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * <p> The Hash Map implementation.
 * This Hash Map supports null as key
 *
 * @param <K> type of Map key
 * @param <V> type of Map value
 * @author Alexander Bogomolnyy
 * @version 1.0 29.11.2016.
 */
public class HashMap<K, V> implements Map<K, V> {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry[] array;
    private int size;

    private V nullKeyValue;
    private boolean isNullKeyPresent = false;

    public HashMap() {
        array = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    public HashMap(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        array = new Entry[initialCapacity];
    }

    // resizing of array of hash map entries
    private void resize() {
        int oldCapacity = array.length;
        int newCapacity = ((long) oldCapacity * 2 > Integer.MAX_VALUE) ? oldCapacity : oldCapacity * 2;
        if (oldCapacity == newCapacity) {
            return;
        }
        Entry[] newArray = new Entry[newCapacity];
        Entry[] oldArray = array;
        for (Entry<K, V> entry : oldArray) {
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int i = indexOfBucket(entry.hash, newCapacity);
                entry.next = newArray[i];
                newArray[i] = entry;
                entry = next;
            }
        }
        array = newArray;
    }

    @Override
    public void clear() {
        isNullKeyPresent = false;
        nullKeyValue = null;
        for (int index = 0; index < array.length; index++) {
            array[index] = null;
        }
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null)
            return isNullKeyPresent;
        int hash = hash(key.hashCode());
        int index = indexOfBucket(hash, array.length);
        Entry<K, V> entry = array[index];
        while (entry != null) {
            K currentKey = entry.key;
            if (entry.hash == hash && (currentKey == key || key.equals(currentKey))) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (isNullKeyPresent)
            if ((value == null && nullKeyValue == null) || (value != null && value.equals(nullKeyValue)))
                return true;
        for (Entry<K, V> entry : array) {
            while (entry != null) {
                V currentValue = entry.value;
                if (entry.key != null) {
                    if ((value == null && currentValue == null) || (value != null && value.equals(currentValue)))
                        return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(Object key) {
        if (key == null)
            return isNullKeyPresent ? nullKeyValue : null;
        int hash = hash(key.hashCode());
        int index = indexOfBucket(hash, array.length);
        Entry<K, V> entry = array[index];
        while (entry != null) {
            K currentKey = entry.key;
            if (entry.hash == hash && (currentKey == key || key.equals(currentKey))) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            if (isNullKeyPresent) {
                V oldValue = nullKeyValue;
                nullKeyValue = value;
                size++;
                return oldValue;
            } else {
                nullKeyValue = value;
                isNullKeyPresent = true;
                size++;
                return null;
            }
        }
        int hash = hash(key.hashCode());
        int index = indexOfBucket(hash, array.length);
        Entry<K, V> entry = array[index];
        while (entry != null) {
            K currentKey = entry.key;
            if (entry.hash == hash && (currentKey == key || key.equals(currentKey))) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }
        Entry<K, V> currentEntry = array[index];
        array[index] = new Entry<K, V>(key, value, hash, currentEntry);
        if (size++ >= array.length * DEFAULT_LOAD_FACTOR)
            resize();
        return null;
    }

    // hash function of hash table
    private int hash(int key) {
        key ^= (key >>> 20) ^ (key >>> 12);
        return key ^ (key >>> 7) ^ (key >>> 4);
    }

    private int indexOfBucket(int hash, int length) {
        return (length - 1) % hash;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(Object key) {
        if (key == null) {
            if (isNullKeyPresent) {
                isNullKeyPresent = false;
                V oldValue = nullKeyValue;
                nullKeyValue = null;
                size--;
                return oldValue;
            } else {
                return null;
            }
        }

        int hash = hash(key.hashCode());
        int i = indexOfBucket(hash, array.length);
        Entry<K, V> previous = array[i];
        Entry<K, V> entry = previous;
        while (entry != null) {
            Entry<K, V> next = entry.next;
            K currentKey = entry.key;
            if (entry.hash == hash && (currentKey == key || key.equals(currentKey))) {
                size--;
                if (previous == entry)
                    array[i] = next;
                else
                    previous.next = next;
                return entry.value;
            }
            previous = entry;
            entry = next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    /**
     * The class for Hash Map Entry
     *
     * @param <K> - type of key
     * @param <V> - type of value
     */
    class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;
        private final int hash;

        public Entry(K key, V value, int hash, Entry<K, V> entry) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            next = entry;
        }

        public final K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public final V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public int hashCode() {
            int result = (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof Map.Entry))
                return false;
            Map.Entry other = (Map.Entry) obj;
            if (key == null) {
                if (other.getKey() != null)
                    return false;
            } else if (!key.equals(other.getKey()))
                return false;
            if (value == null) {
                if (other.getValue() != null)
                    return false;
            } else if (!value.equals(other.getValue()))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return getKey() + "=" + getValue();
        }

    }

}