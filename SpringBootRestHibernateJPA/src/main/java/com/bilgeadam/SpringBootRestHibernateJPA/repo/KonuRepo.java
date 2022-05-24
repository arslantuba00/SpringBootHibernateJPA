package com.bilgeadam.SpringBootRestHibernateJPA.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bilgeadam.SpringBootRestHibernateJPA.model.Konu;

public interface KonuRepo extends JpaRepository<Konu,Long>
{

	public Konu findKonuByNAME(String isim);

	public List<Konu> findKonuByNAMELike(String string, Sort by);

}
