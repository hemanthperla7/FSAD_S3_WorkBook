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
        	System.out.println("5. Sort by Price ASC");
        	System.out.println("6. Sort by Price DESC");
        	System.out.println("7. Sort by Quantity (Highest First)");
        	System.out.println("8. Show First 3 Products");
        	System.out.println("9. Show Next 3 Products");
        	System.out.println("10. Count Total Products");
        	System.out.println("11. Count Products where Quantity > 0");
        	System.out.println("12. Min and Max Price");
        	System.out.println("13. Group Products by Description");
        	System.out.println("14. Filter Products by Price Range");
        	System.out.println("15. Names Starting With");
        	System.out.println("16. Names Ending With");
        	System.out.println("17. Names Containing Pattern");
        	System.out.println("18. Names With Exact Length");
        	System.out.println("19. Exit");
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

            	List<Product> ascList =
            	session.createQuery("from Product order by price asc", Product.class)
            	.list();

            	System.out.println("---- Products Sorted by Price (ASC) ----");

            	for(Product prod : ascList) {

            	System.out.println(
            	prod.getId()+" "
            	+prod.getName()+" "
            	+prod.getPrice());

            	}

            	break;
            	
            case 6:

            	List<Product> descList =
            	session.createQuery("from Product order by price desc", Product.class)
            	.list();

            	System.out.println("---- Products Sorted by Price (DESC) ----");

            	for(Product prod : descList) {

            	System.out.println(
            	prod.getId()+" "
            	+prod.getName()+" "
            	+prod.getPrice());

            	}

            	break;
            	
            case 7:

            	List<Product> qtyList =
            	session.createQuery("from Product order by quantity desc", Product.class)
            	.list();

            	System.out.println("---- Products Sorted by Quantity (Highest First) ----");

            	for(Product prod : qtyList) {

            	System.out.println(
            	prod.getId()+" "
            	+prod.getName()+" "
            	+prod.getQuantity());

            	}

            	break;
            	
            case 8:

            	List<Product> first3 =
            	session.createQuery("from Product", Product.class)
            	.setFirstResult(0)
            	.setMaxResults(3)
            	.list();

            	System.out.println("---- First 3 Products ----");

            	for(Product prod : first3) {

            	System.out.println(
            	prod.getId()+" "
            	+prod.getName()+" "
            	+prod.getPrice());

            	}

            	break;
            	
            case 9:

            	List<Product> next3 =
            	session.createQuery("from Product", Product.class)
            	.setFirstResult(3)
            	.setMaxResults(3)
            	.list();

            	System.out.println("---- Next 3 Products ----");

            	for(Product prod : next3) {

            	System.out.println(
            	prod.getId()+" "
            	+prod.getName()+" "
            	+prod.getPrice());

            	}

            	break;
            	
            case 10:

            	Long total =
            	session.createQuery("select count(*) from Product", Long.class)
            	.uniqueResult();

            	System.out.println("Total Products: " + total);

            	break;
            	
            case 11:

            	Long available =
            	session.createQuery(
            	"select count(*) from Product where quantity > 0",
            	Long.class)
            	.uniqueResult();

            	System.out.println("Products with Quantity > 0 : " + available);

            	break;
            	
            case 12:

            	Double minPrice =
            	session.createQuery(
            	"select min(price) from Product",
            	Double.class)
            	.uniqueResult();

            	Double maxPrice =
            	session.createQuery(
            	"select max(price) from Product",
            	Double.class)
            	.uniqueResult();

            	System.out.println("Minimum Price: " + minPrice);
            	System.out.println("Maximum Price: " + maxPrice);

            	break;
            	
            case 13:

            	List<Object[]> groupList =
            	session.createQuery(
            	"select description, count(*) from Product group by description",
            	Object[].class)
            	.list();

            	System.out.println("---- Products Grouped by Description ----");

            	for(Object[] row : groupList){

            	System.out.println(row[0] + " : " + row[1]);

            	}

            	break;
            	
            case 14:

            	System.out.print("Enter Minimum Price: ");
            	double min = sc.nextDouble();

            	System.out.print("Enter Maximum Price: ");
            	double max = sc.nextDouble();

            	List<Product> rangeList =
            	session.createQuery(
            	"from Product where price between :min and :max",
            	Product.class)
            	.setParameter("min", min)
            	.setParameter("max", max)
            	.list();

            	System.out.println("---- Products in Price Range ----");

            	for(Product prod : rangeList){

            	System.out.println(
            	prod.getId()+" "
            	+prod.getName()+" "
            	+prod.getPrice());

            	}

            	break;
            	
            case 15:

            	System.out.print("Enter starting letters: ");
            	String start = sc.next();

            	List<Product> startList =
            	session.createQuery(
            	"from Product where name like :pattern",
            	Product.class)
            	.setParameter("pattern", start + "%")
            	.list();

            	System.out.println("---- Products Starting With ----");

            	for(Product prod : startList){

            	System.out.println(prod.getName());

            	}

            	break;
            	
            case 16:

            	System.out.print("Enter ending letters: ");
            	String end = sc.next();

            	List<Product> endList =
            	session.createQuery(
            	"from Product where name like :pattern",
            	Product.class)
            	.setParameter("pattern", "%" + end)
            	.list();

            	System.out.println("---- Products Ending With ----");

            	for(Product prod : endList){

            	System.out.println(prod.getName());

            	}

            	break;
            	
            case 17:

            	System.out.print("Enter substring: ");
            	String contain = sc.next();

            	List<Product> containList =
            	session.createQuery(
            	"from Product where name like :pattern",
            	Product.class)
            	.setParameter("pattern", "%" + contain + "%")
            	.list();

            	System.out.println("---- Products Containing Pattern ----");

            	for(Product prod : containList){

            	System.out.println(prod.getName());

            	}

            	break;
            	
            case 18:

            	System.out.print("Enter name length: ");
            	int len = sc.nextInt();

            	List<Product> lengthList =
            	session.createQuery(
            	"from Product where length(name) = :len",
            	Product.class)
            	.setParameter("len", len)
            	.list();

            	System.out.println("---- Products With Exact Length ----");

            	for(Product prod : lengthList){

            	System.out.println(prod.getName());

            	}

            	break;
            	
            case 19:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while (choice != 19);

        tx.commit();
        session.close();
        sc.close();
    }
}