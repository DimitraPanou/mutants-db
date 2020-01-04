package gr.fleming.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gr.fleming.domain.Person;

public class PersonService extends Service<Person> {

	public PersonService() {
		super(Person.class);
	}

	@Override
	public List<Person> getAll() {
		return data();
	}
	
	@Override
	public List<Person> search(int from, int count, String criterion) {
		if (criterion != null && !"".equals(criterion)) {
			return data().stream().filter(p -> p.getName().toLowerCase().contains(criterion.toLowerCase())).limit(count).collect(Collectors.toList());
		} else {
			return data().stream().limit(count).collect(Collectors.toList());
		}
	}
	
	@Override
	public long searchCount(String criterion) {
		// TODO Auto-generated method stub
		if (criterion != null && !"".equals(criterion)) {
			return data().stream().filter(p -> p.getName().toLowerCase().contains(criterion.toLowerCase())).count();
		} else {
			return data().stream().count();
		}
	}
	
	private List<Person> data() {
		List<Person> list = new ArrayList<Person>();
			
		Person mother = new Person();
		mother.setName("Maria");
		list.add(mother);
		
		Person son = new Person();
		son.setName("Giwrgos");
		son.setParent(mother);
		list.add(son);
		
		return list;
	}

}
