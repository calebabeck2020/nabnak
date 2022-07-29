package com.revature.nabnak.util.custom_collections;

public interface Collection<E> {

    boolean add(E element);

    boolean contains(E element);

    boolean isEmpty();

    boolean remove(E element);

    int size();
}
