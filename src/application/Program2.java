package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: Insert Departement ===");
		Department newDepartment = new Department(null, "Musica");
		depDao.insert(newDepartment);
		System.out.println("Inserido! Novo Department");
		
		System.out.println("\n=== TESTE 2: findById Departement ===");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 3: findAll Departement ===");
		List<Department> list = new ArrayList<>();
		list = depDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
	}

}
