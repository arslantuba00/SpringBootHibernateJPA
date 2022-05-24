package com.bilgeadam.SpringBootRestHibernateJPA.endpoints;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilgeadam.SpringBootRestHibernateJPA.model.DersOgrenci;
import com.bilgeadam.SpringBootRestHibernateJPA.model.Ogrenci;
import com.bilgeadam.SpringBootRestHibernateJPA.model.Ogretmen;
import com.bilgeadam.SpringBootRestHibernateJPA.service.OgrenciService;

@RestController
@RequestMapping(value = "ogrenci")
public class OgrenciResource
{
	@Autowired
	public OgrenciService ogrenciService;

	// produces yazmazsam 406 hatası alabiliyorum
	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Ogrenci> getAll()
	{
		// localhost:8080/ogrenci/getAll
		ArrayList<Ogrenci> liste = (ArrayList<Ogrenci>) ogrenciService.getAll();
		return liste;
	}

	// localhost:8080/ogrenci/getById/1
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> getByIdEntity(@PathVariable Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ogrenciService.getById(id));
	}

	// localhost:8080/ogrenci/findByName/numan
	@GetMapping(path = "findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogrenci> findByName(@PathVariable String name)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ogrenciService.findByName(name));
	}

	// localhost:8080/ogrenci/searchByName?exp=man
	@GetMapping(path = "searchByName", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Ogrenci> searchByName(@RequestParam(name = "exp") String exp)
	{
		ArrayList<Ogrenci> liste = (ArrayList<Ogrenci>) ogrenciService.findNameLike(exp);
		return liste;
	}

	// localhost:8080/ogrenci/getById/1/dersler
	@GetMapping(path = "getById/{id}/dersler", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<DersOgrenci>> getByIdDersker(@PathVariable Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ogrenciService.getById(id).getOgrenciDersler());
	}

	// localhost:8080/ogrenci/save
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ogrenci ogrenci)
	{
		Ogrenci result = ogrenciService.save(ogrenci);
		if (result != null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(result.getNAME() + " isimli öğrenci başarıyla eklendi");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("öğrenci bulunamadı!");
		}
		
	}

	// localhost:8080/ogrenci/delete/1
	@GetMapping(path = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable Long id)
	{
		
		if (ogrenciService.delete(id))
		{
			return ResponseEntity.status(HttpStatus.OK).body("Öğrenci silindi");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " id 'li öğrenci bulunamadı");
		}

	}

}
