package ModelDao;

import java.util.List;

import ModelEntities.Department;

public interface DepartmentDao {
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department FindById(Integer id);
	List<Department> FindAll();
}
