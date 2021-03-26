package com.motoboys.motoboys.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Datas implements Serializable{

    private static final long serialVersionUID = 1L;   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date = new Date();
    private Integer comandInt;
    private Integer total;
    private String address;
    private Float valueAddress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public Datas(){
        super();
    }

    public Datas(Integer id, Date date, Integer comandInt, Integer total, String address, Float valueAddress,
			Users users) {
		super();
		this.id = id;
		this.date = date;
		this.comandInt = comandInt;
		this.total = total;
		this.address = address;
		this.valueAddress = valueAddress;
		this.users = users;
	}

	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Integer getComandInt() {
        return comandInt;
    }
    public void setComandInt(Integer comandInt) {
        this.comandInt = comandInt;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

    public Users getUser() {
        return users;
    }
    public void setUser(Users user) {
        this.users = user;
    }

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getValueAddress() {
		return valueAddress;
	}

	public void setValueAddress(Float valueAddress) {
		this.valueAddress = valueAddress;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Datas other = (Datas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}