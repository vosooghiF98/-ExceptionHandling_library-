package org.maktab.exceptionHandling.base;

import org.maktab.exceptionHandling.entities.Member;

import java.sql.SQLException;

public interface BaseRepository<T> {
    void save(T entity) throws SQLException;
    T load(T entity) throws SQLException;
    void edit(T entity) throws SQLException;
    void delete(T entity) throws SQLException;

}
