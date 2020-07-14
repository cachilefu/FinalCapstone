package com.claim.finalcapstone.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	@Column(name="demographic")
	private String demo;
	@Column(name="genre")
	private String genre;
	@Column(name="studio")
	private String studio;
	@Column(name="year")
	private String year;
	
	public Show() {
	

	}
	
	protected Show(String name, String demo, String genre, String studio, String year) {
		this.name = name;
		this.demo = demo;
		this.genre = genre;
		this.studio = studio;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
