package hu.uni.me.iit.felevesFeladat;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="students")
public class MainController {
	
	private final StudentService studentService;

	public MainController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDto> allStudents(){
		return studentService.findAll();
	}
	
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public StudentDto getStudentById(@PathVariable("id") Long id) {
		return studentService.getById(id);
	}
	
	@PostMapping(path="")
	public void newStudent(@Valid @RequestBody StudentDto studentDto) {
		studentService.save(studentDto);
	}
	
	@PutMapping(path="")
	public void replaceStudent(@Valid @RequestBody StudentDto studentDto) {
		studentService.save(studentDto);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		studentService.deleteById(id);
	}
}
