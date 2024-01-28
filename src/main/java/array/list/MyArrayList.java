package array.list;

import exeptions.NotExistedIdException;
import exeptions.NotExistedValueException;

import java.util.Iterator;

public class MyArrayList<E extends Comparable<E>> implements Iterable<E>, Comparable<MyArrayList<E>> {
    private final int START_CAPACITY = 10;
    private E[] array;
    private int arraySize = 0;

    public MyArrayList() {
        array = (E[]) new Comparable [START_CAPACITY];
    }

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return (i < arraySize);
        }

        @Override
        public E next() {
            return (E)array[i++];
        }
    }


    @Override
    public int compareTo(MyArrayList o) {
        return 0;
    }

    public int getArraySize() {
        return arraySize;
    }


    public int getArrayLength() {
        return array.length;
    }


    public void add(E object) {
        int capacity = array.length;
        if(arraySize + 1 > capacity) {
            int newCapacity = rewriteCapacity();
            E[] newArray = (E[]) new Comparable[newCapacity];
            System.arraycopy(array, 0, newArray, 0, capacity);
            array = newArray;
        }
        array[arraySize] = object;
        arraySize++;
    }


    public void add(int id, E object) {
        if(id <= arraySize + 1 && id >= 0){
            if (arraySize + 1 > array.length) {
                int newCapacity = rewriteCapacity();
                E[] newArray = (E[]) new Comparable[newCapacity];
                System.arraycopy(array, 0, newArray, 0, id);
                newArray[id] = object;
                System.arraycopy(array, id, newArray, id + 1, arraySize - id);
                array = newArray;
            } else {
                for (int i = arraySize; i > id; i--) {
                    array[i] = array[i - 1];
                }
                array[id] = object;
            }
            arraySize++;
        } else {
            throw new NotExistedIdException();
        }
    }


    private int rewriteCapacity() {
        return (array.length * 3)/2 + 1;
    }


    public void replace(int id, E object) {
        if(id < arraySize && id >= 0) {
            array[id] = object;
        } else {
            throw new NotExistedIdException("Id " + id + " does not exist!");
        }
    }


    public E get(int id) {
        if(id < arraySize && id >= 0) {
            return array[id];
        } else {
            throw new NotExistedIdException("Id " + id + " does not exist!");
        }
    }



    public E[] convertToArray() {
        E[] newArray = (E[]) new Comparable[arraySize];
        System.arraycopy(array, 0, newArray, 0, arraySize);
        return newArray;
    }


    public void remove(int id) {
        if(id < arraySize && id >= 0) {
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
        if(id < arraySize && id >= 0) {
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


    public void mergeSort(int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(array, left, middle, right);
        }

    }


    private void merge(E[] array, int left, int middle, int right) {
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;
        E[] leftArray = (E[]) new Comparable[leftArraySize];
        E[] rightArray = (E[]) new Comparable[rightArraySize];
        System.arraycopy(array, left, leftArray, 0, leftArraySize);
        System.arraycopy(array, middle + 1, rightArray, 0, rightArraySize);

        int pointer = left;
        for(int i = 0, j = 0; i < leftArraySize && j < rightArraySize; pointer++) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[pointer] = (E) leftArray[i];
                i++;
            } else {
                array[pointer] = (E) rightArray[j];
                j++;
            }
        }


    }


    public void printAll() {
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    public <R extends Comparable<R>> MyArrayList<R> map(FunctionForMap<E, R> mapper) {
        MyArrayList<R> newArraylist = new MyArrayList<>();
        for(E e: array) {
            if(e != null) {
                R returnElement = mapper.apply(e);
                newArraylist.add(returnElement);
            }
        }
        return newArraylist;
    }


    public MyArrayList<E> filter(FunctionForFilter<E> filterer) {
        MyArrayList<E> newArraylist = new MyArrayList<>();
        for(E e: array) {
            if(e != null) {
                if (filterer.apply(e))
                    newArraylist.add(e);
            }
        }
        return newArraylist;
    }


    public <R extends Comparable<R>> MyArrayList<R> flatMap(FunctionForFlatMap<E, R> flatMapper) {
        MyArrayList<R> newArraylist = new MyArrayList<>();
        for(E e: array) {
            if(e != null) {
                MyArrayList<R> subArrayList = flatMapper.apply(e);
                for (R i : subArrayList) {
                    newArraylist.add(i);
                }
            }
        }
        return newArraylist;
    }


    public MyArrayList<E> getArraylist() {
        return this;
    }

}
