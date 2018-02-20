package algorithm;

import java.util.Date;

public class Person implements Comparable<Person> {
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

	@Override
	public int compareTo(Person other) {
		if (this == other) {
			return 0;
		} else {
			return getBirthDate().compareTo(other.getBirthDate());
		}
	}

	public long distance(Person greater) {
		assert(greater.getBirthDate().getTime() >= getBirthDate().getTime());
		return greater.getBirthDate().getTime() - getBirthDate().getTime();
	}
}

