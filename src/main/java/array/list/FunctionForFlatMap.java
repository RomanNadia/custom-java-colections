package array.list;

import array.list.MyArrayList;

@FunctionalInterface
public interface FunctionForFlatMap<E, R extends Comparable<R>> {
    MyArrayList<R> apply(E e);
}
