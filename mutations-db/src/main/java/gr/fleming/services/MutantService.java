package gr.fleming.services;

import java.util.List;

import gr.fleming.domain.Mutant;

public class MutantService extends EntityService<Mutant, Integer> {

	public MutantService(Class<Mutant> type) {
		super(Mutant.class);
	}

	@Override
	public long searchCount(String criterion) {
		return 0;
	}

	@Override
	public List<Mutant> search(int from, int count, String criterion) {
		return null;
	}

}
