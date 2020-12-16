package com.webapp.taskcreation;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityLinks;;

@RestController
public class TaskController {

	@Autowired
	TaskRepository taskRepo;

	@GetMapping(path = "/tasks")
	public List<Task> retrieveTasks() throws ParseException {

		return taskRepo.findAll();

	}

	@PostMapping("/createTasks")
	public ResponseEntity<Object> addTask(@RequestBody Task task) {
		Task createdTask=taskRepo.save(task);
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(createdTask.getTaskid()).toUri();
		return ResponseEntity.created(location).build();	

	}
	
	@PutMapping("/updateTasks")
	public void updateTask(@RequestBody Task task) throws Exception{
		
		Optional<Task> taskupdate = taskRepo.findById(task.getTaskid());
		
		if(taskupdate!=null){
			taskRepo.save(task);
		}
		else
			throw new Exception();
	}
	
	@GetMapping("/getTask/{id}")
	public Optional<Task> getTask(@PathVariable int id) throws Exception{
		
		Optional<Task> task = taskRepo.findById(id);
		
		if(task == null)
			throw new Exception();
		
		/*Resource<Task> response = new Resource<Task>(task.get()); 
		
      EntityLinks<Task> resource = EntityModel.of(Task);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		response.add(linkTo.withRel("all-users"));*/
		
		return task;
		
	}
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable int id){
		Optional<Task> task = taskRepo.findById(id);
		if(task!=null)
			taskRepo.deleteById(id);
	}
}
