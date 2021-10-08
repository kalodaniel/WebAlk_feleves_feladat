package hu.uni.me.iit.felevesFeladat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {
	private final int MAXIMUM_STUDENT_COUNT=20;
	private final StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentDto> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public StudentDto getById(Long id) {
		return studentRepository.getById(id);
	}

	@Override
	public Long save(StudentDto studentDto) {
		if(studentRepository.findAll().size()<MAXIMUM_STUDENT_COUNT) {
			return studentRepository.save(studentDto);
		}
		else {
			throw new TooMuchStudentException();
		}
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
}
