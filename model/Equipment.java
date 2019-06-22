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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author ThoanVu
 */
@Entity(name = "Equipment")
@Table(name = "Equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private int status;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "RoomType_Equipment",
            joinColumns = {
                @JoinColumn(name = "id_Equipment")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_RoomType")})
    private Set<RoomType> lstRoomType = new HashSet<>();

    public Equipment() {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public Set<RoomType> getLstRoomType() {
        return lstRoomType;
    }

    public void setLstRoomType(Set<RoomType> lstRoomType) {
        this.lstRoomType = lstRoomType;
    }
    
    

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\", "
                + "\"name\":\"" + name + "\"}";
    }


//    @Override
//    public String toString() {
//        return "{\"id\":\"" + id + "\", \"name\":\"" + name + "\", \"status\":\"" + status + "\", \"cDate\":\"" + cDate + "\", \"mDate\":\"" + mDate + "\", \"dDate\":\"" + dDate +  "\"}";
//    }

}
