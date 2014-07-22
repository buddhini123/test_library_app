package com.library.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;




@Entity(name = "MEMBER") 
public class Member {
	
	@Id
	@Column(name = "MEMBER_ID", nullable = false)
	private String memberID;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "NIC")
	private String nic;
	
	@Column(name = "JOIN_DATE")
	private Date joinedDate;
	
	@Column(name = "RENEWAL_DATE")
	private Date renewalDate;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberID, String firstName, String lastName,
			String nic, Date joinedDate, Date renewalDate) {
		super();
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.joinedDate = joinedDate;
		this.renewalDate = renewalDate;
	}
	
	

	public Member(String memberID, String firstName, String lastName, String nic) {
		super();
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}
	
}
