package com.inventory.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        int choice;

        do {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.print("Enter Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Enter Description: ");
                String desc = sc.nextLine();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                Product p = new Product(name, desc, price, qty);
                session.save(p);

                System.out.println("Product Added");
                break;

            case 2:
                Query<Product> q = session.createQuery("from Product", Product.class);
                List<Product> list = q.list();

                for (Product prod : list) {
                    System.out.println("-------------------");
                    System.out.println("ID: " + prod.getId());
                    System.out.println("Name: " + prod.getName());
                    System.out.println("Desc: " + prod.getDescription());
                    System.out.println("Price: " + prod.getPrice());
                    System.out.println("Qty: " + prod.getQuantity());
                }
                break;

            case 3:
                System.out.print("Enter Product ID to Update: ");
                int uid = sc.nextInt();

                Product up = session.get(Product.class, uid);

                if (up != null) {
                    System.out.print("Enter New Price: ");
                    double np = sc.nextDouble();

                    System.out.print("Enter New Quantity: ");
                    int nq = sc.nextInt();

                    up.setPrice(np);
                    up.setQuantity(nq);

                    session.update(up);
                    System.out.println("Product Updated");
                } else {
                    System.out.println("Product Not Found");
                }
                break;

            case 4:
                System.out.print("Enter Product ID to Delete: ");
                int did = sc.nextInt();

                Product dp = session.get(Product.class, did);

                if (dp != null) {
                    session.delete(dp);
                    System.out.println("Product Deleted");
                } else {
                    System.out.println("Product Not Found");
                }
                break;

            case 5:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        tx.commit();
        session.close();
        sc.close();
    }
}