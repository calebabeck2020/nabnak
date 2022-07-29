package com.revature.nabnak.daos;

public interface Crudable<T> { // generic <T> we can use to assign as ANY potential datatype

    // Create
    T create(T newObject);

    // Read
    T[] findAll();
    T findById(String id);

    // Update
    boolean update(T updatedObject);

    // Delete
    boolean delete(String id);
}
