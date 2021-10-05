package hu.uni.me.iit.felevesFeladat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentDto {
	
	@NotNull
	private Long id;
	
	@NotBlank
	@NotNull
	private String name;
	@NotBlank
	private String neptunCode;
	@Min(10)
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNeptunCode() {
		return neptunCode;
	}
	public void setNeptunCode(String neptunCode) {
		this.neptunCode = neptunCode;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
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
		return "StudentDto [id=" + id + ", name=" + name + ", neptunCode=" + neptunCode + ", age=" + age
				+ ", getName()=" + getName() + ", getNeptunCode()=" + getNeptunCode() + ", getAge()=" + getAge()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
