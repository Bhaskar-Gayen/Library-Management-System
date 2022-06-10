package com.plazmateq.UserManageService.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Borrow {
	
	@EmbeddedId
	private BorrowId borrowId;
	private String checkIn;
	private String checkOut;
	private float fine;

	public Borrow() {}

	

	public Borrow(BorrowId borrowId, String checkIn, String checkOut, float fine) {
		super();
		this.borrowId = borrowId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.fine = fine;
	}



	public BorrowId getBorrowId() {
		return borrowId;
	}



	public void setBorrowId(BorrowId borrowId) {
		this.borrowId = borrowId;
	}



	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
	public float getFine() {
		return fine;
	}

	public void setFine(float fine) {
		this.fine = fine;
	}

}
