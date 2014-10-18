package repo;

import java.util.*;

public interface IRepo<TUnit> {

	public void save(TUnit unit);
	public void delete(TUnit unit);
	public void update(TUnit unit);
	public TUnit get(int id);
	public List<TUnit> getAll();
	
}
