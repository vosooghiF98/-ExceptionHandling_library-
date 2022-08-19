package org.maktab.exceptionHandling;

import org.maktab.exceptionHandling.entities.Library;
import org.maktab.exceptionHandling.entities.Member;
import org.maktab.exceptionHandling.exceptions.LibraryFullException;
import org.maktab.exceptionHandling.exceptions.MemberNotFoundException;
import org.maktab.exceptionHandling.service.LibraryService;
import org.maktab.exceptionHandling.service.impl.LibraryServiceImpl;
import org.maktab.exceptionHandling.service.impl.MemberServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        MemberServiceImpl memberService = new MemberServiceImpl();
        Library library =  new Library("baghketab" , 2);
        Library library2 = libraryServiceImpl.load(library);
        try {
            libraryServiceImpl.isFull(library2);
        }catch (LibraryFullException lfe){
            System.out.println(lfe.getMessage());
        }
        Member member = new Member("a","b",1);
        try {
            memberService.load(member);
        }catch (MemberNotFoundException m){
            System.out.println(m.getMessage());
        }
    }


}