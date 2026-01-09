package ModelDao;

import ModelDaoImpl.DepartmentDaoJDBC;
import db.DB;

public class DaoFactoryDepartment {
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
