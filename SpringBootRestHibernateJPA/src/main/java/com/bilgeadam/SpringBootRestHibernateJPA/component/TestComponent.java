package com.bilgeadam.SpringBootRestHibernateJPA.component;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.bilgeadam.SpringBootRestHibernateJPA.model.Ders;
import com.bilgeadam.SpringBootRestHibernateJPA.model.Konu;
import com.bilgeadam.SpringBootRestHibernateJPA.model.Ogretmen;
import com.bilgeadam.SpringBootRestHibernateJPA.repo.DersRepo;
import com.bilgeadam.SpringBootRestHibernateJPA.repo.KonuRepo;
import com.bilgeadam.SpringBootRestHibernateJPA.repo.OgretmenRepo;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TestComponent
{
	private OgretmenRepo ogretmenRepo;
	
	private KonuRepo konuRepo;
	
	private DersRepo dersRepo;

	@PostConstruct
	public void test()
	{
		Ogretmen ogretmen = new Ogretmen("berra", false);
		ogretmenRepo.save(ogretmen);
		Ogretmen ogretmen2 = new Ogretmen("tuba", false);
		ogretmenRepo.save(ogretmen2);
		
		Konu konu = new Konu("Java");
		konuRepo.save(konu);
		
		Konu konu2 = new Konu("C++");
		konuRepo.save(konu2);
		
		Konu konu3 = new Konu("C#");
		konuRepo.save(konu3);
		
		Ders ders = new Ders(ogretmen,konu);
		dersRepo.save(ders);
		
		Ders ders2 = new Ders(ogretmen,konu3);
		dersRepo.save(ders2);
		
		Ders ders3 = new Ders(ogretmen2,konu);
		dersRepo.save(ders3);
		
		Ders ders4 = new Ders(ogretmen2,konu2);
		dersRepo.save(ders4);
		
		
		
	}
}
