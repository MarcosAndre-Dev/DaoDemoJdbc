package ModelDao;

import java.util.List;

import ModelEntities.Department;
import ModelEntities.Seller;

public interface SellerDao {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller FindById(Integer id);
	List<Seller> FindAll();
	List<Seller> FindByDepartment(Department department);

}
