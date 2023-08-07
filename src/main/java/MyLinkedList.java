
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private int size = 0;
    private Entry<E> first;
    private Entry<E> last;

    private static class Entry<E> {
        E element;
        Entry<E> next;
        Entry<E> prev;

        Entry(Entry<E> prev, E element) {
            this.element = element;
            this.prev = prev;
        }

        Entry(E element) {
            this.element = element;
        }

        Entry(E element, Entry<E> next) {
            this.element = element;
            this.next = next;
        }

    }

    public Iterator<E> iterator() {
        return new MyLinkedList.MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int i = 0;
        private Entry<E> e = first;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            i++;
            E current = e.element;
            e = e.next;
            return current;
        }
    }


    public int getSize() {
        return size;
    }

    public void add(E odject) {
        if(size == 0) {
            Entry<E> newEntry = new Entry<>(odject);
            first = newEntry;
            last = newEntry;
        } else {
            Entry<E> newEntry = new Entry<>(last, odject);
            last.next = newEntry;
            last = newEntry;
        }
        size++;
    }


    public void add(int id, E odject) {
        if(id > size + 1 || id <= 0) {
            throw new NotExistedIdException(id + " does not exist");
        } else if(id == 1) {
            Entry<E> newEntry = new Entry<>(odject, first);
            first.prev = newEntry;
            first = newEntry;
            size++;
        } else if(id == size + 1) {
            Entry<E> newEntry = new Entry<>(last, odject);
            last.next = newEntry;
            last = newEntry;
            size++;
        } else {
            Entry<E> newEntry = new Entry<>(odject);
            Entry<E> privios = searchById(id - 1);
            newEntry.prev = privios;
            newEntry.next = privios.next;
            if(id == size) {
                last = privios.next;
            }
            privios.next.prev = newEntry;
            privios.next = newEntry;
            size++;
        }
    }


    public E get(int id) {
        if(id > size || id <= 0) {
            throw new NotExistedIdException(id + " does not exist");
        } else if(id == 1) {
            return first.element;
        } else if(id == size) {
            return last.element;
        } else {
            return searchById(id).element;
        }
    }


    private Entry<E> searchById(int id) {
        if(id > size || id <= 0) {
            throw new NotExistedIdException(id + " does not exist");
        } else if(id <= (size/2)) {
            Entry<E> current = first;
            for (int i = 1; i <= (size/2) && (i < id); i++) {
                current = current.next;
            }
            return current;
        } else {
            Entry<E> current = last;
            for (int i = size; i > (size/2) && (i > id); i--) {
                current = current.prev;
            }
            return current;
        }
    }


    public void set(int id, E odject) {
        if(id > size || id <= 0) {
            throw new NotExistedIdException(id + " does not exist");
        } else {
            searchById(id).element = odject;
        }
    }


    public void remove(int id) {
        if(id > size || id <= 0) {
            throw new NotExistedIdException(id + " does not exist");
        } else {
            if(id == 1) {
                Entry<E> removed = first;
                first = removed.next;
                makeNullElement(removed);
            } else if(id == size) {
                Entry<E> removed = last;
                last = removed.prev;
                makeNullElement(removed);
            } else {
                Entry<E> removed = searchById(id);
                removed.prev.next = removed.next;
                removed.next.prev = removed.prev;
                makeNullElement(removed);
            }
            size--;
        }
    }


    public void remove(E value) {
        int id = searchIdByValue(value);
        remove(id);
    }


    private int searchIdByValue(E value) {
        Entry<E> current = first;
        for (int i = 1; i <= size; i++) {
            if(current.element.equals(value)) {
                return i;
            }
            current = current.next;
        }
        throw new NotExistedValueException(value + " does not exist");
    }


    private void makeNullElement(Entry<E> e) {
        e.next = null;
        e.prev = null;
        e.element = null;
    }


    public void printAll() {
        System.out.println("Print: ");
        Entry<E> current = first;
        for (int i = 1; i <= size; i++) {
            System.out.println(current.element);
            //if(current.next != null) {
                current = current.next;
            //}
        }
    }


    public E[] convertToArray() {
        E[] newArray = (E[]) new Object[size];
        Entry<E> current = first;
        for(int i = 0; i < size; i++) {
            newArray[i] = current.element;
            current = current.next;
        }
        return newArray;
    }

}
