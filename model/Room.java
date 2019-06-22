/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstoneproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity(name = "Room")
@Table(name = "Room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description="";

    @Column(name = "status", nullable = false)
    private int status;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy")
    private Date cDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "modify_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy")
    private Date mDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "delete_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy")
    private Date dDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_RoomType")
    private RoomType roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_BoardingHouse", referencedColumnName = "id", nullable = false, unique = true)
    private BoardingHouse boardingHouse;
    
    @OneToOne(mappedBy = "room", fetch = FetchType.LAZY)
    @Where(clause = "status = 1 and end_date > GETDATE()")
    private Contract contract;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    @Where(clause = "status = 1")
    private List<ExtraFee> lstExtraFee = new ArrayList<ExtraFee>();

    public Room() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BoardingHouse getBoardingHouse() {
        return boardingHouse;
    }

    public void setBoardingHouse(BoardingHouse boardingHouse) {
        this.boardingHouse = boardingHouse;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }    
    

    @Override
    public String toString() {
        return "{\"id\":" + id + ","
                + " \"name\":\"" + name + "\","
                + "\"description\":\"" + description + "\","               
                + "\"roomType\":" + roomType.toString() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
        {
            return false;
        }else
        {
            Room u = (Room) obj;
            if(this.name.toLowerCase().trim().equals(u.name.toLowerCase().trim()))
            {
                return true;
            }
        }
        return false;
    }
    
    
}
