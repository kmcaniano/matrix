package com.linearalgebra;

/**
 * Interface that all elements within Matrix must extend. Defines the operations that can be performed on a Matrix element.
 */
public interface Element<E>
{
    E add(E other);

    E subtract(E other);

    E multiply(E other);

    <T extends Number> E scalar(T scale);
}
