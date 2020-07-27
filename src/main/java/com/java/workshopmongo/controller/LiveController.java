package com.java.workshopmongo.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.workshopmongo.document.LiveDocument;
import com.java.workshopmongo.service.LiveService;

@CrossOrigin(origins = "*")
@RestController
public class LiveController {

	@Autowired
	private LiveService liveService;

	@GetMapping("/lives/{id}")
	public ResponseEntity<LiveDocument> getOneLive(@PathVariable(value = "id") String id) {
		Optional<LiveDocument> liveO = liveService.findById(id);
		if (!liveO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<LiveDocument>(liveO.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping("/lives")
	public ResponseEntity<LiveDocument> saveLive(@RequestBody LiveDocument live) {
		live.setRegistrationDate(LocalDateTime.now());
		return new ResponseEntity<LiveDocument>(liveService.save(live), HttpStatus.CREATED);
	}

	@DeleteMapping("/lives/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
		Optional<LiveDocument> liveO = liveService.findById(id);
		if(!liveO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			liveService.delete(liveO.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping("lives/{id}")
	public ResponseEntity<LiveDocument> updateLive(@PathVariable String id, @RequestBody LiveDocument liveDocument) {
		Optional<LiveDocument> liveO = liveService.findById(id);
		if(!liveO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			liveDocument.setId(liveO.get().getId());
			return new ResponseEntity<LiveDocument>(liveService.save(liveDocument), HttpStatus.OK);
		}
	}
	
}