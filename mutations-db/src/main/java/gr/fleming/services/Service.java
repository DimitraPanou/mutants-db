package gr.fleming.services;

import java.util.List;

public abstract class Service<T> {
	protected Class<T> type;
	
	public Service(Class<T> type) {
		this.type = type;
	}
	
	public List<T> getAll() {
		return null;
	}
	
	public long searchCount() {
		return 0l;
	}
	
	public abstract long searchCount(String criterion);
	
	public abstract List<T> search(int from, int count, String criterion);

}
