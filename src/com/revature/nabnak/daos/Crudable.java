package com.revature.nabnak.daos;

import com.revature.nabnak.util.custom_collections.LinkedList;

public interface Crudable<T> { // generic <T> we can use to assign as ANY potential datatype

    // Create
    T create(T newObject);

    // Read
    LinkedList<T> findAll();
    T findById(String id);

    // Update
    boolean update(T updatedObject);

    // Delete
    boolean delete(String id);
}
