package com.plazmateq.UserManageService.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import net.bytebuddy.utility.nullability.NeverNull;

@Embeddable
public class BorrowId implements Serializable {
	private static final long serialVersionUID = 1L;

	@NeverNull
	private int bookId;
	@NeverNull
	private int cardId;
	
	public BorrowId() {
	}

	public BorrowId(int boookId, int cardId) {
		super();
		this.bookId = boookId;
		this.cardId = cardId;
	}

	public int getBoookId() {
		return bookId;
	}

	public void setBoookId(int boookId) {
		this.bookId = boookId;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || getClass()!=o.getClass()) return false;
		BorrowId obj=(BorrowId)o;
		return (this.bookId==obj.bookId)&&(this.cardId==obj.cardId);
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(bookId, cardId);
    }
}
