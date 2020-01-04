package gr.fleming.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Table(name = "Users")
@Entity
public class User {
	private Integer id;
	private String name;
	
	@Id
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JoinColumn(name ="name tou sql table")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
}
