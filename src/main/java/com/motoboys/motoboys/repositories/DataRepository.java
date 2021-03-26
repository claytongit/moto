package com.motoboys.motoboys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.motoboys.motoboys.models.Datas;

@Repository
public interface DataRepository extends JpaRepository<Datas, Integer>{

	@Query("SELECT obj FROM Datas obj WHERE obj.users.id = :id_user")
	List<Datas> findAllByUsers(@Param(value = "id_user") Integer id_user);

}