package test;
import algorithm.Result;
import algorithm.Finder;
import algorithm.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FinderTests {

	private Person sue;
	private Person greg;
	private Person sarah;
	private Person mike;

	@Before
	public void setup() {
		sue = new Person("Sue", new Date(50, 0, 1));
		greg = new Person("Greg", new Date(52, 5, 1));
		sarah = new Person("Sarah",  new Date(82, 0, 1));
		mike = new Person("Mike",  new Date(79, 0, 1));
	}

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<>();
		Finder finder = new Finder(list);

		Result result = finder.FindClosest();
		assertEquals(null, result.getMin());

		assertEquals(null, result.getMax());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<>();
		list.add(sue);

		Finder finder = new Finder(list);

		Result result = finder.FindClosest();

		assertEquals(null, result.getMin());
		assertEquals(null, result.getMax());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		Result result = finder.FindClosest();

		assertEquals(sue, result.getMin());
		assertEquals(greg, result.getMax());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Result result = finder.FindFurthest();

		assertEquals(greg, result.getMin());
		assertEquals(mike, result.getMax());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		Result result = finder.FindFurthest();

		assertEquals(sue, result.getMin());
		assertEquals(sarah, result.getMax());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Result result = finder.FindClosest();

		assertEquals(sue, result.getMin());
		assertEquals(greg, result.getMax());
	}

}
