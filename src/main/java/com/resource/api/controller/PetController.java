package com.resource.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.resource.api.entity.Pet;
import com.resource.api.service.PetService;

@RestController
@CrossOrigin(origins = "*")
public class PetController {
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;

	@Autowired
	private PetService petService;

	@GetMapping("/pets")
	public List<Pet> listaNegocios() {
		return petService.findAll();
	}
	
	@GetMapping("/pets/{petid}")
	public Pet obtener(@PathVariable(value="petid") Long petid) {
		return petService.findById(petid);
	}
	
	@GetMapping("/pets/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		
		Path path = Paths.get(STORAGEPATH).resolve(filename);
		
		if(!Files.exists(path)) {
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new UrlResource(path.toUri());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(STORAGEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}
	
	@PostMapping("/pets")
	public Pet addPet (@RequestParam(name="image", required=false) MultipartFile image, @RequestBody Pet pet) throws IOException {
		if (image != null && !image.isEmpty()) {
			String filename = System.currentTimeMillis() + image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
			pet.setPetimage(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(image.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		petService.savePet(pet);
		return pet;
	}

}
