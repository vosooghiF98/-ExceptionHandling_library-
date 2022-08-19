package org.maktab.exceptionHandling.entities;

import org.maktab.exceptionHandling.entities.base.BaseEntity;

public class User implements BaseEntity<Integer> {
    Integer id;
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer integer) {
        id = integer;
    }
}
