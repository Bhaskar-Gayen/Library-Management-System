package com.plazmateq.UserManageService.borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plazmateq.UserManageService.model.Borrow;
import com.plazmateq.UserManageService.model.BorrowId;

public interface BorrowRepository extends JpaRepository<Borrow, BorrowId>{
	Borrow findByBorrowId(BorrowId borrowId);
}
