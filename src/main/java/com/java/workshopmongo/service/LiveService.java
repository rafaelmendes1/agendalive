package com.java.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.workshopmongo.document.LiveDocument;
import com.java.workshopmongo.repository.LiveRepository;

@Service
public class LiveService {

	@Autowired
	private LiveRepository liveRepository;
	
	public Optional<LiveDocument> findById(String id) {
		return liveRepository.findById(id);
	}
	
	public LiveDocument save(LiveDocument liveDocument) {
		return liveRepository.save(liveDocument);
	}
	
	public void delete(LiveDocument liveDocument) {
		liveRepository.delete(liveDocument);
	}
}
