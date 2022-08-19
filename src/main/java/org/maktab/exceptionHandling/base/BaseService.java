package org.maktab.exceptionHandling.base;

import java.sql.SQLException;

public class BaseService<T> {
    private BaseRepository<T> baseRepository;

    public BaseRepository<T> getBaseRepository() {
        return baseRepository;
    }

    public void setBaseRepository(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public void save(T entity) throws SQLException {
        baseRepository.save(entity);
    }

    public T load(T entity) throws SQLException {
        return baseRepository.load(entity);
    }

    public void edit(T entity) throws SQLException {
        baseRepository.edit(entity);
    }

    public void delete(T entity) throws SQLException{
        baseRepository.delete(entity);
    }
}
