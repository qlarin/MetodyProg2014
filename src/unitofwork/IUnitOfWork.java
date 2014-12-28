package unitofwork;

import metody.Unit;

public interface IUnitOfWork {

	public void commit();
	public void rollback();
	public void markAsNew(Unit unit, IUnitOfWorkRepo repo);
	public void markAsDirty(Unit unit, IUnitOfWorkRepo repo);
	public void markAsDeleted(Unit unit, IUnitOfWorkRepo repo);
	
}
