package com.example.onetoone;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;


    @GetMapping("/instructors")
    public List < Instructor > getInstructors() {
        return instructorRepository.findAll();
    }
    
    
   @PostMapping("/instructors/default")
   public Instructor createInstructorsDefault(){
		System.out.print("createInstructorsDefault....");
		Instructor in = new Instructor("Ramesh","Fedrate","ramesh@gmail.com");
		InstructorDetail indetail = new InstructorDetail("Java Guides", "Cricket Playing");
		in.setInstructorDetail(indetail);
		return instructorRepository.save(in);
		
		
   }
   
   @PostMapping("/instructors")
   public Instructor createInstructors(@RequestBody Instructor instructor ){
		System.out.print("createInstructors....");
		InstructorDetail indetail = new InstructorDetail("Java Guides", "Cricket Playing");
		instructor.setInstructorDetail(indetail);
		return instructorRepository.save(instructor);
		
		
   }

   @DeleteMapping("/instructors/{id}")
   public int deleteInstructors(@PathVariable Long id ){
		System.out.print("deleteInstructors....");
		 instructorRepository.deleteById(id);
		return 1;
   }
   
   @PutMapping("/instructors/{id}")
   public Instructor updateInstructors(@PathVariable Long id, @RequestBody Instructor instructor ){
		System.out.print("updateInstructors....");
		InstructorDetail indetail = new InstructorDetail("Java Guides", "Cricket Playing");
		instructor.setInstructorDetail(indetail);
		Instructor instructorupdate = instructorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("updateInstructors", "id", id));
		instructorupdate.setFirstName(instructor.getFirstName());
		instructorupdate.setLastName(instructor.getLastName());
		instructorupdate.setEmail(instructor.getEmail());
		return instructorRepository.save(instructor);
		
		
   }

  
   
}