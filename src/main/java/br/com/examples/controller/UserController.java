package br.com.examples.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.examples.dto.UserDTO;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@RequestMapping(value="/helloworld", method=RequestMethod.GET)
	public String helloWorld(){
		return "Hello World";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAll(){
		List<UserDTO>response =  new ArrayList<UserDTO>();
		
		UserDTO user = new UserDTO();
		user.setId(1);
		user.setName("David");
		user.setAge(22);
		response.add(user);
		
		user = new UserDTO();
		user.setId(2);
		user.setName("Jose");
		user.setAge(18);
		response.add(user);
		
		return new ResponseEntity<List<UserDTO>>(response, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserById(@PathVariable(value="id") int id){
		UserDTO user = new UserDTO();
		user.setId(id);
		user.setName("David");
		user.setAge(22);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<UserDTO> insertUser( @RequestBody UserDTO user){
		return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
	}	
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> updateUser( @RequestBody UserDTO user){
		user.setName(user.getName());
		user.setId(user.getId());
		user.setAge(user.getAge());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	@RequestMapping(method=RequestMethod.PATCH)
	public ResponseEntity<Void> partialUpdateUser( @RequestBody UserDTO user){
		user.setName(user.getName());
		user.setId(user.getId());
		user.setAge(user.getAge());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable(value="id") int id){
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
