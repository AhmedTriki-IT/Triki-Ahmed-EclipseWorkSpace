package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {
	
	@Autowired
	private CandidatRepository candidatRepository;
	
	
	public Candidat addCandidat(Candidat candidat) {
		return candidatRepository.save(candidat);
	}
	
	public Candidat updateCandidat(int id,Candidat newCandidat) {
		if ( candidatRepository.findById(id).isPresent()) {
			Candidat existingCandidat=candidatRepository.findById(id).get();
			existingCandidat.setEmail(newCandidat.getEmail());
			existingCandidat.setPrenom(newCandidat.getPrenom());
			existingCandidat.setNom(newCandidat.getNom());
			
			return candidatRepository.save(existingCandidat);
		}else {
			return null;
		}
	}
	
	public String deleteCandidat(int id) {
		if (candidatRepository.findById(id).isPresent()) {
			candidatRepository.deleteById(id);
			return "Candidat supprimer";
			
		}else {
			return "Candidat non supprimer"; 
		}
	}

}
