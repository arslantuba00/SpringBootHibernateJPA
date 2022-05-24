package com.bilgeadam.SpringBootRestHibernateJPA.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OgrenciDTO
{
	private String NAME;

	@Column(unique = true)
	private long OGR_NUMBER;

	private long YEAR;

	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ders", cascade =
	{ CascadeType.REMOVE, CascadeType.REFRESH })
	private Set<DersOgrenci> ogretmenDersler = new HashSet<DersOgrenci>();

	public OgrenciDTO(String nAME, long oGR_NUMBER, long yEAR)
	{
		NAME = nAME;
		OGR_NUMBER = oGR_NUMBER;
		YEAR = yEAR;
	}

	@Override
	public String toString()
	{
		return "Ogrenci [NAME=" + NAME + ", OGR_NUMBER=" + OGR_NUMBER + ", YEAR=" + YEAR + "]";
	}

}
