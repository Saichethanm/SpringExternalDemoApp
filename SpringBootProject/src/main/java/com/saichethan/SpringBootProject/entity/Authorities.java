package com.saichethan.SpringBootProject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY, mappedBy = "instructor", cascade = CascadeType.ALL)
////    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
////    @JoinColumn(name = "user_id")
//    private User user;

    @Column(name = "authority")
    private String authority;


    public Authorities() {
    }

    public Authorities(String authority) {
        this.authority = authority;
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Authorities{" +
                "id=" + id +
//                ", user=" + user +
                ", authority='" + authority + '\'' +
                '}';
    }
}
