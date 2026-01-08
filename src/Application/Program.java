package Application;


import java.util.List;

import ModelDao.DaoFactory;
import ModelDao.SellerDao;
import ModelEntities.Department;
import ModelEntities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===Test 1: seller findById =====");
		
		Seller seller = sellerDao.FindById(3);
		
		System.out.println(seller);
		
		System.out.println("===Test 2: seller findByDepartment =====");
		Department department = new Department (2, null);
		List<Seller> list = sellerDao.FindByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}

	}

}
