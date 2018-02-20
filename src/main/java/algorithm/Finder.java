package algorithm;

import java.util.*;

public class Finder {
	public static final Result EMPTY_RESULT = new Result();
	private final List<Person> personList;
	private Result closest;
	private Result furthest;

	public Finder(List<Person> p) {
		personList = p;

		sort();
		cacheClosest();
		cacheFurthest();
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

	private void cacheFurthest() {
		if (personList.size() > 1) {
			furthest = new Result(personList.get(0), personList.get(personList.size() - 1));
		} else {
			furthest = EMPTY_RESULT;
		}
	}

	private void cacheClosest() {
		long minDistance = Long.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < personList.size() - 1; ++i) {
			Person person1 = personList.get(i);
			Person person2 = personList.get(i + 1);
			long distance = person2.getBirthDate().getTime() - person1.getBirthDate().getTime();
			if (distance < minDistance) {
				minDistance = distance;
				minIndex = i;
			}
		}
		if (minIndex != -1) {
			closest = new Result(personList.get(minIndex), personList.get(minIndex + 1));
		} else {
			closest = EMPTY_RESULT;
		}
	}
}
