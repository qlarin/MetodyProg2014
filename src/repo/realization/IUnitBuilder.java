package repo.realization;

import java.sql.ResultSet;
import java.sql.SQLException;

import metody.Unit;

public interface IUnitBuilder<TUnit extends Unit> {

	public TUnit build(ResultSet rs) throws SQLException;
	
}