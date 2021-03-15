package com.vti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.RegistrationUserToken;

public interface RegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {

	//
	public RegistrationUserToken findByToken(String token);

	//check User dang ki bang token
	public boolean existsByToken(String token);

	//tim token bang userId
	@Query("	SELECT 	token	" + "	FROM 	RegistrationUserToken " + " WHERE 	user.id = :userId")
	public String findByUserId(int userId);
	
	//Xoa User by Id
	//Do ResetPasswordToken chi co property la User ma khong co UserID nen phai viet them ham @Query
	@Transactional
	@Modifying
	@Query("	DELETE " 
			+ "	FROM 	RegistrationUserToken 	"
			+ " WHERE 	user.id = :userId")
	public void deleteByUserId(int userId);

}
