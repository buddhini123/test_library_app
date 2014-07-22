package com.library.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "RESERVATION")
public class Reservation {
	
	@Id
	@Column(name = "RESERVATION_ID", nullable = false)
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="BOOK_ID",referencedColumnName="BOOK_ID")
	private Book book;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="MEMBER_ID",referencedColumnName="MEMBER_ID")
	private Member member;
	
	@Column(name = "RESERVATION_DATE")
	private Date reservationDate;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Reservation(Book book, Member member, Date reservationDate,
			String comments) {
		super();
		this.book = book;
		this.member = member;
		this.reservationDate = reservationDate;
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

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
