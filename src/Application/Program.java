package Application;


import java.util.Date;

import ModelDao.DaoFactory;
import ModelDao.SellerDao;
import ModelEntities.Department;
import ModelEntities.Seller;

public class Program {

	public static void main(String[] args) {
	
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		Seller seller = new Seller(21, "Marcos", "Marcos@gmail.com", new Date(), 3000.0, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(sellerDao);
	}

}
