package algorithm;

import java.util.*;

public class Finder {
	private final List<Person> personList;
	private Result closest;
	private Result furthest;

	public Finder(List<Person> p) {
		personList = p;

		sort();
		findClosest();
		findFurthest();
	}

	public Result FindClosest() {
		return closest;
	}
	public Result FindFurthest() {
		return furthest;
	}

	private void sort() {
		Collections.sort(personList);
	}

	private void findFurthest() {
		if (personList.size() > 1) {
			furthest = new Result();
			furthest.person1 = personList.get(0);
			furthest.person2 = personList.get(personList.size() - 1);
			furthest.distance = furthest.person2.getBirthDate().getTime() - furthest.person1.getBirthDate().getTime();
		} else {
			furthest = new Result();
		}
	}

	private void findClosest() {
		closest = new Result();
		closest.distance = Long.MAX_VALUE;
		for (int i = 0; i < personList.size() - 1; ++i) {
			Person person1 = personList.get(i);
			Person person2 = personList.get(i + 1);
			long distance = person2.getBirthDate().getTime() - person1.getBirthDate().getTime();
			if (distance < closest.distance) {
				closest.distance = distance;
				closest.person1 = person1;
				closest.person2 = person2;
			}
		}
	}
}
