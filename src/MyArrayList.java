import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    private final int START_CAPACITY = 10;
    private E[] array;
    private int arraySize = 0;

    public MyArrayList() {
        array = (E[]) new Object[START_CAPACITY];
    }

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < arraySize;
        }

        @Override
        public E next() {
            return (E)array[i++];
        }
    }

    public void add(E object) {
        int capacity = array.length;
        if(arraySize + 1 > capacity) {
            int oldCapacity = capacity;
            rewriteCapacity();
            E[] newArray = (E[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, oldCapacity);
            array = newArray;
        }
        array[arraySize] = object;
        arraySize++;
    }


    public void add(int id, E object) {
        int capacity = array.length;
        if(arraySize + 1 > capacity) {
            capacity = rewriteCapacity();
            E[] newArray = (E[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, id);
            newArray[id] = object;
            System.arraycopy(array, id, newArray, id + 1, arraySize - id);
            array = newArray;
        } else {
            for(int i = arraySize; i >= id; i--) {
                array[i] = array[i + 1];
            }
            array[id] = object;
        }
        arraySize++;
    }


    private int rewriteCapacity() {
        return (array.length * 3)/2 + 1;
    }


    public void replace(int id, E object) {
        if(id < arraySize) {
            array[id] = object;
        } else {
            throw new NotExistedIdException("Id " + id + " does not exist!");
        }
    }


    public E get(int id) {
        if(id < arraySize) {
            return array[id];
        } else {
            throw new NotExistedIdException("Id " + id + " does not exist!");
        }
    }


    public E[] getAll() {
        return array;
    }


    public void remove(int id) {
        if(id < arraySize) {
            for(int i = id; i < arraySize; i++) {
                array[i] = array[i + 1];
            }
        } else {
            throw new NotExistedIdException("Id " + id + " does not exist!");
        }
        arraySize--;
    }


    public void remove(E object) {
        int id = searchObject(object);
        if(id < arraySize) {
            for(int i = id; i < arraySize; i++) {
                array[i] = array[i + 1];
            }
        }
        arraySize--;
    }


    private int searchObject(E object) {
        for(int i = 0; i < arraySize; i++) {
            if (object.equals(array[i])) {
                return i;
            }
        }
        throw new NotExistedValueException(object + " does not exist");
    }


    public void printAll() {
        System.out.println("Prrrrrrint:");
        for(E arr : array) {
            System.out.println(arr);
        }
    }


}
