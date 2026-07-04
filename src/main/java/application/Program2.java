package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n === Teste 1 : department findById: ");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("\n === Teste 2 : department findAll: ");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }


        System.out.println("\n=== Teste 3 : department Insert:");
        Department department = new Department(null, "Musica");
        departmentDao.insert(department);
        System.out.println("Novo Id: " + department.getId() + " , " + department.getName());


        System.out.println("\n=== Teste 4 : department Update:");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Comida");
        departmentDao.update(dep2);
        System.out.println("Update completo");

        System.out.println("\n === Teste 5 : department Delete: ");
//       usuario digita o ID
        System.out.print("Entre com o ID para o delete: ");
        int id = sc.nextInt();
        departmentDao.deletebyId(id);
        System.out.println("Delete finalizado");

        sc.close();
    }
}
