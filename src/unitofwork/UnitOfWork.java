package unitofwork;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import metody.Unit;
import metody.UnitState;

public class UnitOfWork implements IUnitOfWork{

	private Connection connection;
	
	private Map<Unit, IUnitOfWorkRepo> units = new LinkedHashMap<Unit, IUnitOfWorkRepo>();
	
	public UnitOfWork(Connection connection){
		super();
		this.connection = connection;
		
		try{
			connection.setAutoCommit(false);
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void commit(){
		
		for(Unit unit: units.keySet()) {
			
			switch(unit.getState()){
			case Changed:
				units.get(unit).persistUpdate(unit);
				break;
			case Deleted:
				units.get(unit).persistDelete(unit);
				break;
			case New:
				units.get(unit).persistAdd(unit);
				break;
			case Unchanged:
				break;
			default:
				break;
			}
		
		try {
			connection.commit();
			units.clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	}		
		public void rollback(){
			units.clear();
		}
		
		public void markAsNew(Unit unit, IUnitOfWorkRepo repo) {
			unit.setState(UnitState.New);
			units.put(unit, repo);
		}
		
		public void markAsDirty(Unit unit, IUnitOfWorkRepo repo){
			unit.setState(UnitState.Changed);
			units.put(unit, repo);
		}
		
		public void markAsDeleted(Unit unit, IUnitOfWorkRepo repo){
			unit.setState(UnitState.Deleted);
			units.put(unit, repo);
		}
		
}
