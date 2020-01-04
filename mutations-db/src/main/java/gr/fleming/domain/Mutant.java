package gr.fleming.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Mutants")
@Entity
public class Mutant {
	private Integer eid;
	private User author; //έστω authorId το κλειδί στους users 
	
	@Id
	public Integer getEid() {
		return eid;
	}
	
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	@JoinColumn(name = "authorId")
	@ManyToOne(targetEntity = User.class)
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
}
