/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstoneproject.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author anhlh
 */
@Entity(name = "Tenant")
@Table(name = "Tenant")
public class Tenant implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "imgArnFront")
    private String imgArnFront;

    @Column(name = "imgArnBack")
    private String imgArnBack;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tenant")
    private List<ContractTenant> lstContract = new ArrayList<>();

    public Tenant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgArnFront() {
        return imgArnFront;
    }

    public void setImgArnFront(String imgArnFront) {
        this.imgArnFront = imgArnFront;
    }

    public String getImgArnBack() {
        return imgArnBack;
    }

    public void setImgArnBack(String imgArnBack) {
        this.imgArnBack = imgArnBack;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ContractTenant> getLstContract() {
        return lstContract;
    }

    public void setLstContract(List<ContractTenant> lstContract) {
        this.lstContract = lstContract;
    }
    
    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ", \"imgArnFront\":\"" + imgArnFront + "\", \"imgArnBack\":\"" + imgArnBack + "\", \"user\":" + user + '}';
    }

     @Override
    public boolean equals(Object obj) {
        if(obj == null)
        {
            return false;
        }else
        {
            Tenant t = (Tenant) obj;
            if(this.id == t.getId())
            {
                return true;
            }
        }
        return false;
    }
}
