package Application;


import java.util.Date;
import java.util.List;
import ModelDaoImpl.SellerDaoJDBC;
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
		
		System.out.println("===Test 3: seller findAll =====");
		list = sellerDao.FindAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert =====");
		Seller newSeller = new Seller(0, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}

}

