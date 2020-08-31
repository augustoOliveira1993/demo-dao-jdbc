package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		adicionaTeste(1, "Seller findById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		adicionaTeste(2, "Seller findByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		adicionaTeste(3, "findAll implementation");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
	}
	
	public static void adicionaTeste(int numTeste, String nomeTeste) {
		System.out.printf("\n=== TESTE %d: %s ===\n", numTeste, nomeTeste);
	}

}
