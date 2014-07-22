package com.library.domain;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;


public class LibraryDAO {
	
	private EntityManager manager;
	
	
	

	
	public LibraryDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

		manager = factory.createEntityManager();	
	}





	public void createNewMember(String id, String fname,String lname,String nic) {

		EntityTransaction tx = manager.getTransaction();

		tx.begin();

		try {
			manager.persist(new Member(id,fname,lname,nic));

		} catch (Exception e) {

		e.printStackTrace();

		}

		tx.commit();

	}
	
	public List<Member> listMembers(){

		List<Member> resultList = manager.createQuery("Select a From com.library.domain.Member a", Member.class).getResultList();
		return resultList;

		}
	
	
	public List<Book> listBooks(){

		List<Book> resultList = manager.createQuery("Select a From com.library.domain.Book a", Book.class).getResultList();
		return resultList;

		}
	
	
	public void lendBook(String memberid, String bookid, Date dueReturnDate,String comments) {
		EntityTransaction tx = manager.getTransaction();

		tx.begin();

		try {
			Member member = new Member();
			member.setMemberID(memberid);
			
			Book book = new Book();
			book.setBookId(bookid);
			
			manager.persist(new Borrow(book,member,new Date(),dueReturnDate,comments));

		} catch (Exception e) {

		e.printStackTrace();

		}

		tx.commit();
	}
	
	public Member getLastRegisteredMember(){
		return manager.createQuery("select m from com.library.domain.Member m where m.memberID = (select max(mm.memberID) from com.library.domain.Member mm)",Member.class).getResultList().get(0);
	
	}

}
