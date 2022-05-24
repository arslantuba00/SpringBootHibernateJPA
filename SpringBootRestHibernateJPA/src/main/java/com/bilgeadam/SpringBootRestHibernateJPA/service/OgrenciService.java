package com.bilgeadam.SpringBootRestHibernateJPA.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootRestHibernateJPA.model.Ogrenci;
import com.bilgeadam.SpringBootRestHibernateJPA.repo.OgrenciRepo;

import lombok.AllArgsConstructor;

// bu bir porxy katmanı
// bussiness logic için yazılır
@Service
@AllArgsConstructor
public class OgrenciService
{
	private OgrenciRepo ogrenciRepo;

	public List<Ogrenci> getAll()
	{
		return ogrenciRepo.findAll();
	}

	public Ogrenci getById(Long id)
	{
		return ogrenciRepo.findById(id).get(); //getById() kullanılamıyor!
	}

	public Ogrenci findByName(String isim)//hoca metod ismini find yazdı.
	{
		return ogrenciRepo.findOgrenciByNAME(isim);
	}

	public List<Ogrenci> findNameLike(String expression)
	{
		return ogrenciRepo.findAllByNAMELike("%" + expression + "%", Sort.by(Order.desc("ID")));
//		return ogretmenRepo.findAllByNAMELikeOrderByNAMEDesc("%" + expression + "%");
		// return ogretmenRepo.findByOgretmenName("%" + expression + "%");
	}

	public Ogrenci save(Ogrenci ogrenci)
	{
		return ogrenciRepo.save(ogrenci);
	}

//
	public Ogrenci update(Ogrenci ogrenci)
	{
		return ogrenciRepo.save(ogrenci);
	}

	public boolean delete(Long id)
	{
		try
		{
			ogrenciRepo.deleteById(id);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
