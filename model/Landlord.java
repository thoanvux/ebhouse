/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstoneproject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author anhlh
 */
@Entity(name = "Landlord")
@Table(name = "Landlord")
public class Landlord implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landLord")
    private Set<BoardingHouse> lstBHouse = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landLord")
    private Set<RoomType> lstRoomTypes = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landLord")
    private Set<Contract> lstContract = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    public Landlord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ", \"user\":" + user + "}";
    }

    public Set<BoardingHouse> getLstBHouse() {
        return lstBHouse;
    }

    public void setLstBHouse(Set<BoardingHouse> lstBHouse) {
        this.lstBHouse = lstBHouse;
    }

    public Set<RoomType> getLstRoomTypes() {
        return lstRoomTypes;
    }

    public void setLstRoomTypes(Set<RoomType> lstRoomTypes) {
        this.lstRoomTypes = lstRoomTypes;
    }    

    public Set<Contract> getLstContract() {
        return lstContract;
    }

    public void setLstContract(Set<Contract> lstContract) {
        this.lstContract = lstContract;
    }
    
    
}
