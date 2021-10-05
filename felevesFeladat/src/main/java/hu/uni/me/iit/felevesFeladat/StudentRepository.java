package hu.uni.me.iit.felevesFeladat;

import java.util.List;

public interface StudentRepository {
	List<StudentDto> findAll();
	StudentDto getById(Long id);
	Long save(StudentDto studentDto);
	void deleteById(Long id);
}
