package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;
	
	
	    public List<Job> selectAll() {
	        return jobRepository.findAll();
	    }
	    
	    public Job selectOne(long id) {
	    	return jobRepository.findById(id).get();
	    }
	    
	
	public Job updateJob(long id) {
		
		if ( jobRepository.findById(id).isPresent()) {
			Job existingJob=jobRepository.findById(id).get();
			
			if (existingJob.getService().equals("disponible")) {
				existingJob.setEtat(true);
			}else {
				existingJob.setEtat(false);
			}
			
			
			return jobRepository.save(existingJob);
		}else {
			return null;
		}
	}
	

}
