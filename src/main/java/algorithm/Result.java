package algorithm;

public class Result {
	private Person min;
	private Person max;
	private long distance;

	public Result() {
	}

	public Result(Person min, Person max) {
		this.min = min;
		this.max = max;
		distance = max.getBirthDate().getTime() - min.getBirthDate().getTime();
	}

	public Person getMin() {
		return min;
	}

	public Person getMax() {
		return max;
	}

	public long getDistance() {
		return distance;
	}
}
