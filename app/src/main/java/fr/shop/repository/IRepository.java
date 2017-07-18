package fr.shop.repository;

/**
 * Created by Chendjou on 09/07/2017.
 */

public interface IRepository<T> {
    T findById(int id);
    T save(T obj);
    T delete(T obj);
    T update(T obj);
}
