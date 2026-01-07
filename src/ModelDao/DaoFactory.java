package ModelDao;

import ModelDaoImpl.SellerDaoJDBC;

public class DaoFactory {
	public static SellerDao createSellerDao() { 
		return new SellerDaoJDBC();
	}
}
