package com.bilgeadam.SpringBootRestHibernateJPA.endpoints;

import java.util.ArrayList;
import java.util.List;
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

import com.bilgeadam.SpringBootRestHibernateJPA.model.Ders;
import com.bilgeadam.SpringBootRestHibernateJPA.model.Ogretmen;
import com.bilgeadam.SpringBootRestHibernateJPA.service.OgretmenService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "ogretmen")
@Tag(description = "Oğretmen endpointleri", name = "ogretmen")
public class OgretmenResource
{
	@Autowired
	public OgretmenService ogretmenService;

	// produces yazmazsam 406 hatası alabiliyorum
	@GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Ogretmen> getAll()
	{
		// localhost:8080/ogretmen/getAll
		ArrayList<Ogretmen> liste = (ArrayList<Ogretmen>) ogretmenService.getAll();
		return liste;
	}
	
	
	
	@GetMapping(path = "getAlll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ogretmen>> getAlld()
	{
		// localhost:8080/ogretmen/getAll
//		ArrayList<Ogretmen> liste = (ArrayList<Ogretmen>) ogretmenService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(ogretmenService.getAll());
	}
	
	
	

	// localhost:8080/ogretmen/getById/1
	@GetMapping(path = "getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogretmen> getByIdEntity(@PathVariable Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ogretmenService.getById(id));
	}

	// localhost:8080/ogretmen/findByName/numan
	@GetMapping(path = "findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogretmen> findByName(@PathVariable String name)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ogretmenService.findByName(name));
	}

	// localhost:8080/ogretmen/searchByName?exp=man
	@GetMapping(path = "searchByName", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Ogretmen> searchByName(@RequestParam(name = "exp") String exp)
	{
		ArrayList<Ogretmen> liste = (ArrayList<Ogretmen>) ogretmenService.findNameLike(exp);
		return liste;
	}

	// localhost:8080/ogretmen/getById/1/dersler
	@GetMapping(path = "getById/{id}/dersler", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Ders>> getByIdDersker(@PathVariable Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ogretmenService.getById(id).getDersler());
	}

	// localhost:8080/ogretmen/save
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ogretmen ogretmen)
	{
		Ogretmen result = ogretmenService.save(ogretmen);
		if (result != null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(result.getNAME() + " isimli öğretmen başarıyla eklendi");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("öğretmen bulunamadı!");
		}
	}


	// localhost:8080/ogretmen/delete/1
	@GetMapping(path = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable Long id)
	{
		if (ogretmenService.delete(id))
		{
			return ResponseEntity.status(HttpStatus.OK).body("Öğretmen silindi");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " id 'li öğretmen bulunamadı");
		}

	}

}
