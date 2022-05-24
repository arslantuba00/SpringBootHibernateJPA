package com.bilgeadam.SpringBootRestHibernateJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilgeadam.SpringBootRestHibernateJPA.model.DersOgrenci;

public interface DersOgrenciRepo extends JpaRepository<DersOgrenci,Long>
{

}
