package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/job")
public class JobRestAPI {

	
	@Autowired
	private JobService jobService;
	
	
	  @GetMapping("/jobs")
	  List<Job> all() {
	    return jobService.selectAll();
	  }
	  
	  @GetMapping("/jobs/{id}")
	  Job one(@PathVariable Long id) {
	    return jobService.selectOne(id);
	  }
	  
	  
		@PutMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Job> updateCandidat(@PathVariable(value = "id") int id){
			return new ResponseEntity<>(jobService.updateJob(id),HttpStatus.OK);
		}
}
