package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

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
		
		adicionaTeste(4, "Seller Insert");
		Seller newSeller = new Seller(null, "Greage", "greage@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo ID = " + newSeller.getId());
		
		adicionaTeste(5, "Seller Update");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		adicionaTeste(5, "Seller delete");
		System.out.println("Entre com um ID para deletar teste: ");
		int id = scan.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");
		scan.close();
	}
	
	public static void adicionaTeste(int numTeste, String nomeTeste) {
		System.out.printf("\n=== TESTE %d: %s ===\n", numTeste, nomeTeste);
	}

}
