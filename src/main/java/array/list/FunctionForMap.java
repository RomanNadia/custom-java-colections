package array.list;

@FunctionalInterface
public interface FunctionForMap<E, R extends Comparable<R>> {
    R apply(E e);
}
