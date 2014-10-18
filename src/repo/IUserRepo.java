package repo;

import java.util.*;
import metody.*;

public interface IUserRepo extends IRepo<User> {

	public List<User> withTask(Task task);
	public List<User> withTask(String taskName);
	public List<User> withTask(int taskNumber);
}
