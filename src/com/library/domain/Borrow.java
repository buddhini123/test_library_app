package com.library.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "BORROW") 
public class Borrow {
	
	@Id
	@Column(name = "BORROW_ID", nullable = false)
	@GeneratedValue
	private Integer id;

	@ManyToOne(optional=false)
    @JoinColumn(name="BOOK_ID",referencedColumnName="BOOK_ID")
	private Book book;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="MEMBER_ID",referencedColumnName="MEMBER_ID")
	private Member member;
	
	@Column(name = "BORROW_DATE")
	private Date borrowDate;
	
	@Column(name = "DUE_RETURN_DATE")
	private Date dueReturnDate;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Borrow(Book book, Member member, Date borrowDate,
			Date dueReturnDate, String comments) {
		super();
		this.book = book;
		this.member = member;
		this.borrowDate = borrowDate;
		this.dueReturnDate = dueReturnDate;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getDueReturnDate() {
		return dueReturnDate;
	}

	public void setDueReturnDate(Date dueReturnDate) {
		this.dueReturnDate = dueReturnDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
