package com.SWE.HW3.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SWE.HW3.model.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long>{

}
