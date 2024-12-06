package rppbackend.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Destinacija
 *
 */
@Entity
@Table(name = "Destinacija", schema = "public")
@NamedQuery(name="Destinacija.findAll", query="SELECT d FROM Destinacija d")

public class Destinacija implements Serializable {

	   
	@Id
	@SequenceGenerator(name="DESTINACIJA_ID_GENERATOR", sequenceName="DESTINACIJA_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DESTINACIJA_ID_GENERATOR")
	private Integer id;
	private String mesto;
	private String drzava;
	private String opis;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="destinacija")
	@JsonIgnore
	private List<Hotel> hotel;

	public Destinacija() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}   
	public String getDrzava() {
		return this.drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}   
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
   
}
