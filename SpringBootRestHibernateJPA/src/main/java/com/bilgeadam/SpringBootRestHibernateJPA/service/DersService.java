package com.bilgeadam.SpringBootRestHibernateJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootRestHibernateJPA.model.Ders;
import com.bilgeadam.SpringBootRestHibernateJPA.repo.DersRepo;

import lombok.AllArgsConstructor;

// bu bir porxy katmanı
// bussiness logic için yazılır
@Service
@AllArgsConstructor
public class DersService
{
	private DersRepo dersRepo;

	public List<Ders> getAll()
	{
		return dersRepo.findAll();
	}

	public Ders getById(Long id)
	{
		return dersRepo.findById(id).get(); //getById() kullanılamıyor!
	}


	public Ders save(Ders ders)
	{
		return dersRepo.save(ders);
	}

//
	public Ders update(Ders ders)
	{
		return dersRepo.save(ders);
	}

	public boolean delete(Long id)
	{
		try
		{
			dersRepo.deleteById(id);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
