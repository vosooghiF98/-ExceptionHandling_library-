package org.maktab.exceptionHandling.service.impl;

import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.entities.Member;
import org.maktab.exceptionHandling.repository.MemberRepository;
import org.maktab.exceptionHandling.repository.impl.MemberRepositoryImpl;
import org.maktab.exceptionHandling.service.LibraryService;
import org.maktab.exceptionHandling.service.MemberService;

import java.sql.SQLException;

public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository = new MemberRepositoryImpl();
    LibraryService libraryService = new LibraryServiceImpl();

    @Override
    public void register(String firstName, String lastName, int libraryId) throws SQLException {
        Member member = new Member(firstName, lastName, libraryId);
        memberRepository.save(member);
    }

    @Override
    public void unRegister(String firstName, String lastName) throws SQLException {
        Member member = new Member(firstName, lastName, -1);
        memberRepository.remove(member);
    }

    @Override
    public Member load(String firstName, String lastName) throws SQLException {
        Member member = new Member(firstName, lastName, -1);
        return memberRepository.load(member);
    }

    @Override
    public void edit(Member member, String newFirstName, String newLastName) throws SQLException {
        memberRepository.edit(member, newFirstName, newLastName);
    }
}
