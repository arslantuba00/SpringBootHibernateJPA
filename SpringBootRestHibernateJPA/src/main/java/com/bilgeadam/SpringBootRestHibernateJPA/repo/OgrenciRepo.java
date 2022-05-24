package com.bilgeadam.SpringBootRestHibernateJPA.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bilgeadam.SpringBootRestHibernateJPA.model.Ogrenci;


@Repository
public interface OgrenciRepo extends JpaRepository<Ogrenci, Long>
{

	public Ogrenci findOgrenciByNAME(String name);
	public List<Ogrenci> findAllByNAMELike(String expression, Sort sort);
}