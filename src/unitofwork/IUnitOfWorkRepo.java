package unitofwork;

import metody.Unit;

public interface IUnitOfWorkRepo {

	public void persistAdd(Unit unit);
	public void persistUpdate(Unit unit);
	public void persistDelete(Unit unit);
}
