package com.pharmatunisie.pharmatunisie.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pharmatunisie.pharmatunisie.security.entity.UserEntity;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	/*@Modifying
	@Query("update user u set u.enable = :enable where u.id = :id")
	int setUserByEnable(@Param("enable") Integer enable, @Param("id") Integer id);
*/
}
