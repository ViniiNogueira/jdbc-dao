package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n === Teste 1 : seller findById: ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n === Teste 2 : Seller findByDepartment: ");
        Department department = new Department(2 , null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list){
            System.out.println(s);
        }

        System.out.println("\n === Teste 3 : Seller findAll: ");
        Department list1 = new Department(2 , null);
        list = sellerDao.findAll();
        for (Seller s : list){
            System.out.println(s);
        }


        System.out.println("\n=== Teste 4 : Seller Insert:");
        Seller s = new Seller(null , "Gustavo" , "Gustavo@gmail.com" , new Date() , 4000.00 , department);
        sellerDao.insert(s);
        System.out.println("Inserido: id = " + s.getId());



        System.out.println("\n=== Teste 5 : Seller Update:");
        seller = sellerDao.findById(1);
        seller.setName("John Wayne");
        sellerDao.update(seller);
        System.out.println("Update completo");

        System.out.println("\n === Teste 6 : seller Delete: ");
//        usuario digita o ID
        System.out.println("Digite o ID para o teste do DElETE");
        int idDigitado = sc.nextInt();
        sellerDao.deletebyId(idDigitado);
        System.out.println("DELETE finalizado");

        sc.close();
    }
}
