package com.saichethan.SpringBootProject.dao;

import com.saichethan.SpringBootProject.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authorities,Integer> {
}
