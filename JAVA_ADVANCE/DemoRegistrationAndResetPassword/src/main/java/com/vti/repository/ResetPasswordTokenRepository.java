package com.vti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.ResetPasswordToken;

public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Integer>{

	//tim resetPassword bang cach nhap vao token
	public ResetPasswordToken findByToken(String token);
	
	//check xem token da ton tai chua
	public boolean existsByToken(String token);
	
	//delete By Id 
	//Do ResetPasswordToken chi co property la User ma khong co UserID nen phai viet them ham @Query (Delete...)	
	@Transactional
	@Modifying
	@Query("	DELETE 						" 
			+ "	FROM 	ResetPasswordToken 	" 
			+ " WHERE 	user.id = :userId")
	
	public void deleteByUserId(int userId);
	
}
