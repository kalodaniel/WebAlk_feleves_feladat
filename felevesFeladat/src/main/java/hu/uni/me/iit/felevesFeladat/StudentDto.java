package hu.uni.me.iit.felevesFeladat;

import javax.validation.constraints.*;

public class StudentDto {
	
	@NotNull
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String neptun;
	@Min(10)
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNeptun() {
		return neptun;
	}
	public void setNeptun(String neptun) {
		this.neptun = neptun;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", neptun=" + neptun + ", age=" + age + ", getName()="
				+ getName() + ", getNeptun()=" + getNeptun() + ", getAge()=" + getAge() + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
