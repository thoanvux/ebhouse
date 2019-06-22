/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstoneproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

/**
 *
 * @author anhlh
 */
@Entity(name = "BoardingHouse")
@Table(name = "BoardingHouse")
public class BoardingHouse {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "number_of_room", nullable = false)
    private int numberOfRoom;

    @Column(name = "[description]")
    private String description="";

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date cDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "modify_date")
    private Date mDate;
 
    @Temporal(TemporalType.DATE)
    @Column(name = "delete_date")
    private Date dDate;

    @Column(name = "status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id", referencedColumnName = "id", nullable = false, unique = true)
    private Landlord landLord;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boardingHouse")
    @Where(clause = "status = 1")
    private List<Room> lstRoom = new ArrayList<>();

    public BoardingHouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Landlord getLandLord() {
        return landLord;
    }

    public void setLandLord(Landlord landLord) {
        this.landLord = landLord;
    }

    public List<Room> getLstRoom() {
        return lstRoom;
    }

    public void setLstRoom(List<Room> lstRoom) {
        this.lstRoom = lstRoom;
    }

    

    @Override
    public String toString() {
        return "{\"id\":" + id + ","
                + " \"name\":\"" + name + "\","
                + " \"address\":\"" + address + "\","
                + " \"numberOfRoom\":" + numberOfRoom + ","
                + " \"description\":\"" + description + "\","
                + " \"status\":" + status + "}";
    }


}
