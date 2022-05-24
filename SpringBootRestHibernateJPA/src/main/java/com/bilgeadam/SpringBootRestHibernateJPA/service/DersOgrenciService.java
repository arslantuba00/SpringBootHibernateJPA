package com.bilgeadam.SpringBootRestHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootRestHibernateJPA.model.DersOgrenci;
import com.bilgeadam.SpringBootRestHibernateJPA.repo.DersOgrenciRepo;

import lombok.AllArgsConstructor;

// bu bir porxy katmanı
// bussiness logic için yazılır
@Service
@AllArgsConstructor
public class DersOgrenciService
{
	private DersOgrenciRepo dersOgrenciRepo;

	public List<DersOgrenci> getAll()
	{
		return dersOgrenciRepo.findAll();
	}

	public DersOgrenci getById(Long id)
	{
		return dersOgrenciRepo.findById(id).get(); //getById() kullanılamıyor!
	}


	public DersOgrenci save(DersOgrenci dersOgrenci)
	{
		return dersOgrenciRepo.save(dersOgrenci);
	}

//
	public DersOgrenci update(DersOgrenci dersOgrenci)
	{
		return dersOgrenciRepo.save(dersOgrenci);
	}

	public boolean delete(Long id)
	{
		try
		{
			dersOgrenciRepo.deleteById(id);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
