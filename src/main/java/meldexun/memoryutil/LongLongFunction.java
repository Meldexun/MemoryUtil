package meldexun.memoryutil;

@FunctionalInterface
public interface LongLongFunction<T> {

	T apply(long x, long y);

}
