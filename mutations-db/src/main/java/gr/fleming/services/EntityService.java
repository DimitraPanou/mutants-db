package gr.fleming.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class EntityService<T, I extends Serializable>  extends Service<T> {
	protected EntityManager entityManager;

	public EntityService(Class<T> type) {
		super(type);
	}
	
	public T getById(I id) {
		return entityManager.find(type, id);
	}
	
	@Override
	public List<T> getAll() {
		return entityManager.createQuery("Select t from " + 
		type.getSimpleName() + " t").getResultList();
	}
	
	@Override
	public long searchCount() {
		return (long) entityManager.createQuery("Select count(t) from " + 
				type.getSimpleName() + " t").getResultList().get(0);
	}

	@Override
	public long searchCount(String criterion) {
		return 0l;
	}

	@Override
	public List<T> search(int from, int count, String criterion) {
		// TODO Auto-generated method stub
		return null;
	}

}
