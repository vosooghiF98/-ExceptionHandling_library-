package org.maktab.exceptionHandling.service;

import org.maktab.exceptionHandling.base.BaseService;
import org.maktab.exceptionHandling.entities.Member;
import org.maktab.exceptionHandling.exceptions.MemberNotFoundException;
import org.maktab.exceptionHandling.repository.impl.LibraryRepositoryImpl;
import org.maktab.exceptionHandling.repository.impl.MemberRepositoryImpl;

import java.sql.SQLException;

public abstract class MemberService extends BaseService<Member> {
    public MemberService(){
        setBaseRepository(new MemberRepositoryImpl());
    }

    public MemberService getMemberService(){
        return (MemberService) super.getBaseRepository();
    }
    @Override
    public Member load(Member entity) throws SQLException {
        if (getBaseRepository().load(entity) == null){
            throw new MemberNotFoundException("this member is not found!");
        }
        return getBaseRepository().load(entity);
    }

}
