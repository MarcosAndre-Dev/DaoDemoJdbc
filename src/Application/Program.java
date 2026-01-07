package Application;


import ModelDao.DaoFactory;
import ModelDao.SellerDao;
import ModelEntities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.FindById(3);
		
		System.out.println(seller);
	}

}
