package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Finder {
	private final List<Person> personList;
	private final Comparator<Result> CLOSEST = (r1, r2) -> (int)(r1.distance - r2.distance < 0 ? -1 : (r1.distance - r2.distance > 0 ? 1 : 0));
	private final Comparator<Result> FURTHEST = (r1, r2) -> (int)(r1.distance - r2.distance < 0 ? 1 : (r1.distance - r2.distance > 0 ? -1 : 0));

	public Finder(List<Person> p) {
		personList = p;
	}

	public Result FindClosest() {
		return findGeneric(CLOSEST);
	}
	public Result FindFurthest() {
		return findGeneric(FURTHEST);
	}

	private Result findGeneric(Comparator<Result> comparator) {
		List<Result> candidateList = precalculateAgeDistance();

		if (candidateList.size() < 1) {
			return new Result();
		}

		Result answer = candidateList.get(0);

		for (Result candidate : candidateList) {
			if (comparator.compare(candidate, answer) < 0) {
				answer = candidate;
			}
		}
		return answer;
	}


	private List<Result> precalculateAgeDistance() {
		List<Result> candidateList = new ArrayList<>();

		for (int i = 0; i < personList.size() - 1; i++) {
			for (int j = i + 1; j < personList.size(); j++) {
				Result result = new Result();
				if (personList.get(i).compareTo(personList.get(j)) < 0) {
					result.person1 = personList.get(i);
					result.person2 = personList.get(j);
				} else {
					result.person1 = personList.get(j);
					result.person2 = personList.get(i);
				}
				result.distance = result.person2.getBirthDate().getTime() - result.person1.getBirthDate().getTime();
				candidateList.add(result);
			}
		}
		return candidateList;
	}
}
