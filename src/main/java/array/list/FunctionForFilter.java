package array.list;

@FunctionalInterface
public interface FunctionForFilter<E>  {
    Boolean apply(E e);
}
