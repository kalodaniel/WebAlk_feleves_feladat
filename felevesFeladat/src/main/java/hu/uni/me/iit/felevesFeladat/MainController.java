package hu.uni.me.iit.felevesFeladat;

import java.util.ArrayList;
import java.util.List;

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
	private final List<StudentDto> students = new ArrayList<>();
	
	@GetMapping(path="", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDto> allStudents(){
		return students;
	}
	
	@GetMapping(path="/{id}", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public StudentDto studentById(@PathVariable("id") String id) {
		int found = findStudentsById(id);
		return students.get(found);
	}
	
	@PostMapping(path="")
	public void newStudent(@RequestBody StudentDto articleDto) {
		students.add(articleDto);
	}
	
	@PutMapping(path="/{id}")
	public void replaceStudent(@PathVariable("id") String id, @RequestBody StudentDto studentDto) {
		int found = findStudentsById(id);
		
		if(found!=-1) {
			StudentDto foundStudent = students.get(found);
			foundStudent.setName(studentDto.getName());
			foundStudent.setAge(studentDto.getAge());
		}
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteStudent(@PathVariable("id") String id) {
		int found = findStudentsById(id);
		
		if(found!=-1) {
			students.remove(found);
		}
	}
	
	private int findStudentsById(String id) {
		int found = -1;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getNeptunCode().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}
}
