package org.maktab.exceptionHandling.entities.base;

public interface BaseEntity<ID extends Number> {
    ID getId();
    void setId(ID id);
}
