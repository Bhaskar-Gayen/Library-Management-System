package com.plazmateq.UserManageService.borrow;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.plazmateq.UserManageService.model.Borrow;
import com.plazmateq.UserManageService.model.BorrowId;

@Service
public class BorrowService {

	@Autowired
	private BorrowRepository borrowRepo;
	
	//Checking
	public ResponseEntity<String> checkIn(Borrow borrow){
		borrowRepo.save(borrow);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully done");
	}
	
	//checkout
	public ResponseEntity<String> checkOut(int bookId, int cardId){
		Borrow borrow=borrowRepo.findByBorrowId(new BorrowId(bookId, cardId));
		if(borrow==null)
			return ResponseEntity.status(HttpStatus.CREATED).body("Record Not found");
		float panalty =palantyCalculate(borrow.getCheckIn(), LocalDate.now());
		borrow.setCheckOut(LocalDate.now().toString());
		borrow.setFine(panalty);
		borrowRepo.save(borrow);
		return ResponseEntity.status(HttpStatus.CREATED).body("Success and panalty: "+panalty);
	}
	
	//penalty calculate
	public float palantyCalculate(String start, LocalDate end) {
		if(ChronoUnit.DAYS.between(LocalDate.parse(start), end)>30)
			return 100;
		return 0;
	}
	

}
