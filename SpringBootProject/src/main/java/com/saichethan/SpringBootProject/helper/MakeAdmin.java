package com.saichethan.SpringBootProject.helper;

public class MakeAdmin {
    private int id;

    public MakeAdmin() {
    }

    public MakeAdmin(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MakeAdmin{" +
                "id=" + id +
                '}';
    }
}
