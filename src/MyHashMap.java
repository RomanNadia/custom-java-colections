public class MyHashMap<K,V> {
    private final int START_CAPACITY = 10;
    private Entry[] array;
    private int size = 0;

    private static class Entry<K, V> {
        int hash;
        K key;
        Entry<K, V> next = null;
        V value;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        array = new Entry[START_CAPACITY];
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
                } else {
                    Entry current = array[id];
                    boolean rewriteValue = false;
                    while (current.next != null) {
                        if (current.key.equals(key)) {
                            current = new Entry(hash, key, value);
                            rewriteValue = true;
                        }
                        current = current.next;
                    }

                    if (rewriteValue == false) {
                        current.next = new Entry(hash, key, value);
                        size++;
                    }


                }
            }
        }
    }


    public V get(K key) {
        if (key == null) {
            return (V) array[0].value;
        } else {
            int hash = hash(key.hashCode());
            int id = countId(hash, array.length);
            if (id < array.length) {
                if (array[id].key.equals(key)) {
                    return (V) array[id].value;
                } else if (array[id].next != null) {
                    Entry current = array[id];
                    while (current.next != null) {
                        if (current.key.equals(key)) {
                            return (V) current.value;
                        }
                        current = current.next;
                    }
                }
                throw new NotExistedKeyExeption(key + " does not exist");
            }
            throw new NotExistedKeyExeption(key + " does not exist");
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
                    newArray[0] = e;
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


    private void rewriteValueInNewArr(Entry[] newArray, int newId, Entry e) {
        if (newArray[newId] == null) {
            newArray[newId] = e;
            newArray[newId].next = null;
        } else {
            Entry currentN = newArray[newId];
            while (currentN.next != null) {
                currentN = currentN.next;
            }
            currentN.next = e;
            currentN.next.next = null;
        }
    }


    public void remove(K key) {
        for(int i = 0; i < array.length; i++) {
            Entry e = array[i];
            if(e != null) {
                if(e.key == null) {
                    nullEntry(e);
                } else {
                    if (e.key.equals(key) && e.next == null) {
                        nullEntry(e);
                    } else if (e.key.equals(key) && e.next != null) {
                        Entry forRemove = e;
                        e = e.next;
                        nullEntry(forRemove);
                    } else if (e.next != null) {
                        Entry current = e;
                        while (current.next != null) {
                            if (current.key.equals(key)) {
                                nullEntry(current);
                            }
                            current = current.next;
                        }
                    }
                }
            }
        }
    }


    private void nullEntry(Entry e) {
        e.hash = 0;    /// just e=null
        e.key = null;
        e.next = null;
        e.value = null;
        e = null;
    }

}


