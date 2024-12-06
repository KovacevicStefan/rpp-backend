package rppbackend.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@Table(name = "Hotel", schema = "public")
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")

public class Hotel implements Serializable {

	   
	@Id
	@SequenceGenerator(name="HOTEL_ID_GENERATOR", sequenceName="HOTEL_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOTEL_ID_GENERATOR")
	private Integer id;
	private String naziv;
	private Integer brojZvezdica;
	private String opis;
	
	@ManyToOne
	@JoinColumn(name = "destinacija")
	private Destinacija destinacija;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="hotel")
	@JsonIgnore
	private List<Aranzman> aranzman;

	public Hotel() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}   
	public Integer getBrojZvezdica() {
		return this.brojZvezdica;
	}

	public void setBrojZvezdica(Integer brojZvezdica) {
		this.brojZvezdica = brojZvezdica;
	}   
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Destinacija getDestinacija() {
		return destinacija;
	}
	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}
	
   
}
