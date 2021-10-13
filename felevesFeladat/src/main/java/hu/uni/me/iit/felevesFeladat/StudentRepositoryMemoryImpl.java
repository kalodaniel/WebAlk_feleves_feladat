package hu.uni.me.iit.felevesFeladat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class StudentRepositoryMemoryImpl implements StudentRepository {
private final List<StudentDto> students = new ArrayList<>();
	
	public int getStudentById(Long id) {
		int found = -1;
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId().equals(id)) {
				found=i;
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
		int found = getStudentById(id);
		 return found == -1 ? null : students.get(found);
	}

	@Override
	public Long save(StudentDto studentDto) {
		int found = getStudentById(studentDto.getId());
		
		if(found==-1) {
			students.add(studentDto);
		}
		else {
			StudentDto foundStudent = students.get(found);
			foundStudent.setName(studentDto.getName());
			foundStudent.setNeptun(studentDto.getNeptun());
			foundStudent.setAge(studentDto.getAge());
		}
		return null;
	}
	
	@Override
	public void deleteById(Long id) {
		int found = getStudentById(id);

        if (found != -1) {
            students.remove(found);
        }
	}

}
