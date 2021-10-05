package hu.uni.me.iit.felevesFeladat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentRepositoryMemoryImpl implements StudentRepository {
	private final List<StudentDto> students = new ArrayList<>();
	
	private int findStudentById(Long id) {
		int found = -1;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getNeptunCode().equals(id)) {
				found = i;
				break;
			}
		}
		return found;
	}
	
	@Override
	public List<StudentDto> findAll() {
		return students;
	}

	@Override
	public StudentDto getById(Long id) {
		return null;
	}

	@Override
	public Long save(StudentDto studentDto) {
		int found = findStudentById(studentDto.getId());
		
		if(found!=-1) {
			StudentDto foundStudent = students.get(found);
			foundStudent.setName(studentDto.getName());
			foundStudent.setAge(studentDto.getAge());
		}else {
			students.add(studentDto);
		}
		return null;
	}

	@Override
	public void deleteById(Long id) {
		int found = findStudentById(id);
		
		if(found!=-1) {
			students.remove(found);
		}

	}

}
