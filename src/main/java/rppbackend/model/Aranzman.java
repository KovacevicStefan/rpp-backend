package rppbackend.model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aranzman
 *
 */
@Entity
@Table(name = "Aranzman", schema = "public")
@NamedQuery(name="Aranzman.findAll", query="SELECT ar FROM Aranzman ar")

public class Aranzman implements Serializable {

	   
	@Id
	@SequenceGenerator(name="ARANZMAN_ID_GENERATOR", sequenceName="ARANZMAN_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARANZMAN_ID_GENERATOR")
	private Integer id;
	private BigDecimal ukupnaCena;
	private Boolean placeno;
	private Date datumRealizacije;
	
	@ManyToOne
	@JoinColumn(name="hotel")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name="turistickaAgencija")
	private TuristickaAgencija agencija;
	private static final long serialVersionUID = 1L;

	public Aranzman() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public BigDecimal getUkupnaCena() {
		return this.ukupnaCena;
	}

	public void setUkupnaCena(BigDecimal ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}   
	public Boolean getPlaceno() {
		return this.placeno;
	}

	public void setPlaceno(Boolean placeno) {
		this.placeno = placeno;
	}   
	public Date getDatumRealizacije() {
		return this.datumRealizacije;
	}

	public void setDatumRealizacije(Date datumRealizacije) {
		this.datumRealizacije = datumRealizacije;
	}   
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}   
	public TuristickaAgencija getAgencija() {
		return this.agencija;
	}

	public void setAgencija(TuristickaAgencija agencija) {
		this.agencija = agencija;
	}
   
}
