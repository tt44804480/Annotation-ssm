package com.project.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class VillageEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String cid;

	@NotNull(message = "{NotNull.villageEntity.address}")
	private String address;
	private String telephone;
	private String villagehead;
	private String description;
	private String idnumber;
	private String name;
	private String areaofthegenus;
	private int datatype;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getVillagehead() {
		return villagehead;
	}
	public void setVillagehead(String villagehead) {
		this.villagehead = villagehead;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreaofthegenus() {
		return areaofthegenus;
	}
	public void setAreaofthegenus(String areaofthegenus) {
		this.areaofthegenus = areaofthegenus;
	}
	public int getDatatype() {
		return datatype;
	}
	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}
	@Override
	public String toString() {
		return "VillageEntity [id=" + id + ", cid=" + cid + ", address="
				+ address + ", telephone=" + telephone + ", villagehead="
				+ villagehead + ", description=" + description + ", idnumber="
				+ idnumber + ", name=" + name + ", areaofthegenus="
				+ areaofthegenus + ", datatype=" + datatype + "]";
	}
	
	

}
