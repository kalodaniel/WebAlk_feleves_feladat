package hu.uni.me.iit.felevesFeladat;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class StudentRepositoryMemoryTest {

	@Test
	public void findAll_Empty() {
		//GIVEN
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		//WHEN
		List<StudentDto> result = studentRepository.findAll();
		//THEN
		assertEquals(0, result.size());
	}
	
	@Test
	public void findAll_NotEmpty() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(2l);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
		
		//WHEN
		List<StudentDto> result = studentRepository.findAll();
		
		//THEN
		assertEquals(studentDto, result.get(0));
	}
	
	@Test
	public void findById() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		Long id = 2L;
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(id);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
		
		//WHEN
		int result = studentRepository.getStudentById(id);
				
		//THEN
		assertEquals(0, result);
	}
	
	@Test
	public void findById_NotFound() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		Long id = 2L;
		Long notExistingId=4L;
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(id);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
				
		//WHEN
		int result = studentRepository.getStudentById(notExistingId);
				
		//THEN
		assertEquals(-1, result);
	}
	
	@Test
	public void deleteById_exists() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		Long id = 2L;
		Long notExistingId=4L;
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(id);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
				
		//WHEN
		studentRepository.deleteById(id);
				
		//THEN
		assertEquals(0, studentRepository.findAll().size());
	}
	
	@Test
	public void deleteById_NotExists() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		Long id = 2L;
		Long notExistingId=4L;
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(id);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
				
		//WHEN
		studentRepository.deleteById(notExistingId);
				
		//THEN
		assertEquals(1, studentRepository.findAll().size());
	}
	
	@Test
	public void getById_notExists() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		Long id = 2L;
		Long notExistingId=4L;
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(id);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
				
		//WHEN
		StudentDto dto = studentRepository.getById(notExistingId);
				
		//THEN
		assertNull(dto);
	}
	
	@Test
	public void getById_Exists() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		Long id = 2L;
		Long notExistingId=4L;
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(id);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
				
		//WHEN
		StudentDto dto = studentRepository.getById(id);
				
		//THEN
		assertEquals(studentDto, dto);
	}
	
	@Test
	public void save_Update() {
		//Given
		StudentRepositoryMemoryImpl studentRepository = new StudentRepositoryMemoryImpl();
		Long id = 2L;
		Long notExistingId=4L;
		StudentDto studentDto = new StudentDto();
		studentDto.setName("Name");
		studentDto.setNeptun("Neptun");
		studentDto.setId(id);
		studentDto.setAge(23);
		studentRepository.save(studentDto);
						
		//WHEN
		StudentDto studentDto2 = new StudentDto();
		studentDto2.setName("Name2");
		studentDto2.setNeptun("Neptun2");
		studentDto2.setId(id);
		studentDto2.setAge(23);
		studentRepository.save(studentDto2);
						
		//THEN
		List<StudentDto> studentDtoList = studentRepository.findAll();
		assertEquals(1,studentDtoList.size());
		assertEquals(studentDto, studentRepository.getById(id));
	}
	
	
}
