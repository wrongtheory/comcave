package september.woche2.tag5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Aufgabe {

	static Person reduce1(List<Person> listPerson) {

		/*
		 * Optional<T> reduce(BinaryOperator<T> accumulator); public interface
		 * BinaryOperator<T> extends BiFunction<T,T,T> public interface BiFunction<T, U,
		 * R> R apply(T t, U u);
		 * 
		 */

		Person result = Stream.of(listPerson)
				.parallel()
				.flatMap(person -> person.stream())
				.reduce((person1, person2) -> {
					String resultVorname;
					String resultNachname;

					resultVorname = person1.getVorname().compareTo(person2.getVorname()) > 0 ? 
							person1.getVorname() : person2.getVorname();

					resultNachname = person1.getNachname().compareTo(person2.getNachname()) > 0 ? 
							person1.getNachname() : person2.getNachname();

					return new Person(resultVorname, resultNachname);
			}).get();

		System.out.println(result);
		return result;

	}

	static Person reduce2(List<Person> listPerson) {

		/*
		 * T reduce(T identity, BinaryOperator<T> accumulator); 
		 * public interface BinaryOperator<T> extends BiFunction<T,T,T> 
		 * public interface BiFunction<T, U, R> 
		 * R apply(T t, U u);
		 */

		Person result = Stream.of(listPerson)
				.parallel()
				.flatMap(person -> person.stream())
				.reduce(new Person("", ""), (person1, person2) -> {
					String resultVorname;
					String resultNachname;

					resultVorname = person1.getVorname().compareTo(person2.getVorname()) > 0 ? 
							person1.getVorname() : person2.getVorname();

					resultNachname = person1.getNachname().compareTo(person2.getNachname()) > 0 ? 
							person1.getNachname() : person2.getNachname();

					return new Person(resultVorname, resultNachname);
			});

		System.out.println(result);
		return result;
	}
	
	static Person reduce3(List<Person> listPerson) {

		/*
		 * <U> U reduce(U identity,
         * BiFunction<U, ? super T, U> accumulator,
         * BinaryOperator<U> combiner);
         *        
         * public interface BiFunction<T, U, R> 
         * R apply(T t, U u);
         * 
         * public interface BinaryOperator<T> extends BiFunction<T,T,T> 
         * public interface BiFunction<T, U, R> 
         * R apply(T t, U u);
         *        
		 */
		
		Person identity = new Person("", "");
		
		BiFunction<Person, Person, Person> accumulator =  (person1, person2) -> {
			String resultVorname;
			String resultNachname;

			resultVorname = person1.getVorname().compareTo(person2.getVorname()) > 0 ? 
					person1.getVorname() : person2.getVorname();

			resultNachname = person1.getNachname().compareTo(person2.getNachname()) > 0 ? 
					person1.getNachname() : person2.getNachname();

			return new Person(resultVorname, resultNachname);
		};
		
		BinaryOperator<Person> combiner = (person1, person2) -> {
			String resultVorname;
			String resultNachname;

			resultVorname = person1.getVorname().compareTo(person2.getVorname()) > 0 ? 
					person1.getVorname() : person2.getVorname();

			resultNachname = person1.getNachname().compareTo(person2.getNachname()) > 0 ? 
					person1.getNachname() : person2.getNachname();

			return new Person(resultVorname, resultNachname);
	   };

		Person result = Stream.of(listPerson)
				.parallel()
				.flatMap(person -> person.stream())
				.reduce(identity, accumulator, combiner);

		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		
		Person[] personen = { new Person("Tom", "Katze"), 
							  new Person("Jerry", "Maus"),
							  new Person("Alexander", "Poe") 
							};

		List<Person> listPerson = Arrays.asList(personen);

		reduce1(listPerson);
		reduce2(listPerson);
		reduce3(listPerson);

	}// end of main

}// end of public class
