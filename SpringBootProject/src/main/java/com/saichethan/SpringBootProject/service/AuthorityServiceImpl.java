package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.dao.AuthorityRepository;
import com.saichethan.SpringBootProject.entity.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public List<Authorities> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authorities findById(int theId) {
        Optional<Authorities> result = authorityRepository.findById(theId);

        Authorities temp = result.get();

        System.out.println(temp);
        Authorities theAuthority = null;

        if (result.isPresent()) {
            theAuthority = result.get();
        }
        else {
            // we didn't find the Book
            throw new RuntimeException("Did not find Book id - " + theId);
        }

        return theAuthority;
    }

    @Override
    public void save(Authorities theAuthority) {
        authorityRepository.save(theAuthority);
    }

    @Override
    public void deleteById(int theId) {
        authorityRepository.deleteById(theId);
    }
}
