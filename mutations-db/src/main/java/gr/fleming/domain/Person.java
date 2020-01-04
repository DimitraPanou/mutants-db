package gr.fleming.domain;

import java.io.Serializable;
import java.time.LocalDate;

//@Table
//@Entity
public class Person implements Serializable {
	private Integer id;
	private String name;
	private LocalDate date;
	private Person parent;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Person getParent() {
		return parent;
	}
	public void setParent(Person parent) {
		this.parent = parent;
	}
		
}
