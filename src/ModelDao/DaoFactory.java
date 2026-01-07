package ModelDao;

import ModelDaoImpl.SellerDaoJDBC;
import db.DB;

public class DaoFactory {
	public static SellerDao createSellerDao() { 	
		return new SellerDaoJDBC(DB.getConnection());
	}
}
