package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.User;
import com.vti.entity.UserStatus;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	// check tai khoan ton tai bang userName
	public boolean existsByUsername(String username);

	// check tai khoan ton tai bang email
	public boolean existsByEmail(String email);

	// Xem tai khoan da kich hoat chua bang email
	@Modifying
	@Query("	SELECT 	status 		" + "	FROM 	User 		" + " WHERE 	email = :email")

	public UserStatus findStatusByEmail(String email);

	//tim User bang userName
	public User findByUsername(String username);

	//tim User bang email
	public User findByEmail(String email);

}
