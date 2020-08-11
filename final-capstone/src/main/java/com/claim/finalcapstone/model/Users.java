package com.claim.finalcapstone.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="users")
public class Users {
public Users() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="phone_number")
	private String phone;
	
	@Column(name="email")
	private String email;
	
//	public List<Show> getShows() {
//		return shows;
//	}
//	public void setShows(List<Show> shows) {
//		this.shows = shows;
//	}

	@Column(name="password")
	private String password;
	
//	@ManyToMany
//	@JoinTable(
//		name="user_shows",
//		joinColumns = @JoinColumn(name="users_id"),
//		inverseJoinColumns = @JoinColumn(name="show_id"))
//	private List<Show> shows;
	
	@Transient //used for validation, not to be persisted to database
	private String repeatpass;
	
	private String role;
	
	@Transient
	MultipartFile file;
	private String image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatpass() {
		return repeatpass;
	}
	public void setRepeatpass(String repeatpass) {
		this.repeatpass = repeatpass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", lname=" + lname + ", fname=" + fname + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", repeatpass=" + repeatpass + ", role=" + role + ", file=" + file
				+ ", image=" + image + "]";
	}
	
}



