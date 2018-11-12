package com.demo.model;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String account;
    private String parent_account;

    public Department(String account, String parent_account) {
        this.account = account;
        this.parent_account = parent_account;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getParent_account() {
        return parent_account;
    }

    public void setParent_account(String parent_account) {
        this.parent_account = parent_account;
    }
}
