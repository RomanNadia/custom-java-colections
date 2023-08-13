
import java.util.Iterator;

public class MyHashMap<K,V>  implements Iterable {
    private final int START_CAPACITY = 10;
    private Entry[] array;
    private int size = 0;

    public static class Entry<K, V> {
        private int hash;
        private K key;
        private Entry<K, V> next = null;
        private V value;

        private Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "Key is " + this.key + " value is " + this.value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public MyHashMap() {
        array = new Entry[START_CAPACITY];
    }


    public Iterator<Entry<K, V>> iterator() {
        return new MyHashMap.MyIterator();
    }


    private class MyIterator implements Iterator<Entry<K, V>> {
        private int numberOfExtractedE = 0;
        private int arrayId = 0;
        private int prevArrayId = -1;
        private Entry<K, V> prev = null;

        @Override
        public boolean hasNext() {
            return numberOfExtractedE < size;
        }


        @Override
        public Entry<K, V> next() {
            while (arrayId < array.length) {
                if(array[arrayId] != null) {
                    if(prevArrayId == arrayId) {
                        if(prev.next != null) {
                            Entry current = prev.next;
                            prev = prev.next;
                            numberOfExtractedE++;
                            prevArrayId = arrayId;
                            return current;
                        } else {
                            arrayId++;
                        }
                    } else {
                        prev = array[arrayId];
                        numberOfExtractedE++;
                        Entry current = prev;
                        prevArrayId = arrayId;
                        return current;
                    }

                } else {
                    arrayId++;
                }
            }
            throw new NotExistedIdException("Something went wrong");
        }


    }


    public void put(K key, V value) {
        if (size > countThreshold()) {
            int newLength = array.length * 2;
            array = transfer(newLength);
            put(key, value);
        } else {
            if (key == null) {
                putForNullKey(key, value);
            } else {
                int hash = hash(key.hashCode());
                int id = countId(hash, array.length);
                if (array[id] == null) {
                    array[id] = new Entry(hash, key, value);
                    size++;
                } else if(array[id].key.equals(key)) {
                    Entry nextE = array[id].next;
                    array[id] = new Entry(hash, key, value);
                    array[id].next = nextE;
                } else {
                    Entry current = array[id];
                    boolean rewriteValue = false;
                    while (current != null) {
                        if (current.key.equals(key)) {
                            current.value = value;
                            rewriteValue = true;
                        }
                        current = current.next;
                    }

                    if (rewriteValue == false) {
                        current = array[id];
                        while (current.next != null) {
                            current = current.next;
                        }
                        current.next = new Entry(hash, key, value);
                        size++;
                    }


                }
            }
        }
    }


    public V get(K key) {
        if (key == null && array[0] != null) {
            return (V) array[0].value;
        } else {
            int hash = hash(key.hashCode());
            int id = countId(hash, array.length);
            if (id < array.length && array[id] != null) {
                if (array[id].key.equals(key)) {
                    return (V) array[id].value;
                } else if (array[id].next != null) {
                    Entry current = array[id];
                    while (current != null) {
                        if (current.key.equals(key)) {
                            return (V) current.value;
                        }
                        current = current.next;
                    }
                }
                throw new NotExistedKeyExeption(key + " does not exist");
            } else {
                throw new NotExistedKeyExeption(key + " does not exist");
            }
        }
    }


    private void putForNullKey(K key, V value) {
        array[0] = new Entry(0, key, value);
        size++;
    }


    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    private int countId(int hash, int arrLeight) {
        int id = hash % arrLeight;
        if (id == 0)
            id++;
        return id;
    }

    private double countThreshold() {
        return array.length * 0.75;
    }



    private Entry[] transfer(int newLength) {
        Entry[] newArray = new Entry[newLength];
        for (Entry e : array) {
            if (e != null) {
                if (e.key == null) {
                    newArray[0] = makeCopy(e);
                } else {
                    int newId = countId(e.hash, newLength);

                    rewriteValueInNewArr(newArray, newId, e);
                }
                Entry current = e;
                while (current.next != null) {
                    int newId = countId(current.next.hash, newLength);

                    rewriteValueInNewArr(newArray, newId, current.next);

                    current = current.next;
                }
            }
        }
        return newArray;
    }


    private Entry makeCopy(Entry e) {
        return new Entry(e.hash, e.key, e.value);
    }


    private void rewriteValueInNewArr(Entry[] newArray, int newId, Entry e) {
        if (newArray[newId] == null) {
            newArray[newId] = makeCopy(e);
        } else {
            Entry currentN = newArray[newId];
            while (currentN.next != null) {
                currentN = currentN.next;
            }
            currentN.next = makeCopy(e);
        }
    }


    public void remove(K key) {
        if (key == null) {
            array[0] = null;
            size--;
        } else {
            int hash = hash(key.hashCode());
            int id = countId(hash, array.length);
            if (id < array.length) {
                if (array[id] != null) {
                    if (array[id].key.equals(key)) {
                        if (array[id].next == null) {
                            array[id] = null;
                        } else {
                            Entry nextE = array[id].next;
                            array[id] = nextE;
                        }
                        size--;

                    } else if (array[id].next != null) {
                        Entry current = array[id];
                        Entry deletedPrev = array[id];

                        while (current != null) {

                            current = current.next;

                            if (current.key.equals(key)) {
                                Entry deletedNext = current.next;
                                deletedPrev.next = deletedNext;

                                current = null;
                                size--;
                                break;
                            }

                            deletedPrev = deletedPrev.next;

                        }
                    }
                } else {
                    throw new NotExistedKeyExeption(key + " does not exist");
                }
            } else {
                throw new NotExistedKeyExeption(key + " does not exist");
            }
        }
    }


    public Entry[] convertToArray() {
        Entry[] newArray = new Entry[size];
        Iterator<MyHashMap.Entry<K, V>> iterator = this.iterator();

        for(int i = 0; iterator.hasNext(); i++) {
            newArray[i] = iterator.next();
        }
        return newArray;
    }

    public K[] convertKeyToArray() {
        Entry[] newArray = this.convertToArray();
        K[] keyArray = (K[]) new Object[size];

        for(int i = 0; i < newArray.length; i++) {
            keyArray[i] = (K) newArray[i].key;
        }

        return keyArray;
    }


    public V[] convertValueToArray() {
        Entry[] newArray = this.convertToArray();
        V[] valueArray = (V[]) new Object[size];

        for(int i = 0; i < newArray.length; i++) {
            valueArray[i] = (V) newArray[i].value;
        }

        return valueArray;
    }


}


