package rppbackend.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: TuristickaAgencija
 *
 */
@Entity
@Table(name = "TuristickaAgencija", schema = "public")
@NamedQuery(name="TuristickaAgencija.findAll", query="SELECT t FROM TuristickaAgencija t")

public class TuristickaAgencija implements Serializable {

	   
	@Id
	@SequenceGenerator(name="TURAG_ID_GENERATOR", sequenceName="TURAG_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TURAG_ID_GENERATOR")
	private Integer id;
	private String naziv;
	private String adresa;
	private String kontakt;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "agencija")
	@JsonIgnore
	private List<Aranzman> aranzman;
	
	public TuristickaAgencija() {
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
	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}   
	public String getKontakt() {
		return this.kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
   
}
