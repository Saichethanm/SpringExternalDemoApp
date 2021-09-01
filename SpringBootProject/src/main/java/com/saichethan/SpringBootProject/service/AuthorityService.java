package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.entity.Authorities;

import java.util.List;

public interface AuthorityService {

    public List<Authorities> findAll();

    public Authorities findById(int theId);

    public void save(Authorities theAuthority);

    public void deleteById(int theId);
}
