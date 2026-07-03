package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n === Teste 1 : seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n === Teste 2 : Seller findByDepartment");
        Department department = new Department(2 , null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list){
            System.out.println(s);
        }


        System.out.println("=== Teste 3 : Seller findAll");
        Department list1 = new Department(2 , null);
        list = sellerDao.findAll();
        for (Seller s : list){
            System.out.println(s);
        }



    }
}
