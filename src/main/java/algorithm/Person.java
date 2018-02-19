package algorithm;

import java.util.Date;

public class Person {
	private String name;
	private Date birthDate;

	public Person(String name, Date birthDate){
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}

