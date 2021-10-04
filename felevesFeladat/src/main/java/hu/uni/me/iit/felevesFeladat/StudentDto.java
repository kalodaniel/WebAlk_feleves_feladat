package hu.uni.me.iit.felevesFeladat;

public class StudentDto {
	private String name;
	private String neptunCode;
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
	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", neptunCode=" + neptunCode + ", age=" + age + "]";
	}
	
	
}
