package TrungHA_JavaCore;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainProduct {
    static List<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    private static void addProduct(){
        System.out.println("---ADD PRODUCT---");
        String productId = null;
        boolean duplicateProductId = true;
        do {
            try {
                System.out.print("Product Id: ");
                productId = scanner.nextLine();
                int Id = Integer.parseInt(productId);
                for (Product item : products) {
                    if (Objects.equals(item.getProductId(), productId)) {
                        throw new UseException("ProductId not duplicate");
                    }
                }
                if (productId.length() >=6){
                    throw new MaxLengthException("ProductId have maximum length 6");
                }
                duplicateProductId = false;
            } catch (UseException | MaxLengthException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException e){
                System.out.println("productId must be number ");
            }
        } while (duplicateProductId);

        //
        String  productName= null;
        boolean validateProductName = true;
        do {
            try {
                System.out.print("ProductName: ");
                productName = scanner.nextLine();
                if (productName.isBlank()) {
                    throw new UseException("ProductName an not empty");
                }
                validateProductName = false;
            } catch (UseException e) {
                System.out.println(e.getMessage());
            }
        } while (validateProductName);
        //
        String  productPrice = null;
        boolean validationProductPrice = true;
        do {
            try {
                System.out.print("Product Price: ");
                productPrice = scanner.nextLine();
                float price = Float.parseFloat(productPrice);

                if (Float.parseFloat(productPrice)<100||Float.parseFloat(productPrice)>1000) {
                    throw new UseException("productPrice out of range");
                }
                validationProductPrice = false;
            } catch (UseException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("product price must be number ");
            }
        } while (validationProductPrice);
        scanner.nextLine();
        //

        String available  = "";
        boolean validationAvailable = true;
        do {
            System.out.print("Available(true/false): ");
            available = scanner.nextLine();
            try {
                if (!available.equals("true") && !available.equals("false")) {
                    throw new UseException("Available was wrong formatter");
                }
                validationAvailable = false;
            } catch (UseException e) {
                System.out.println(e.getMessage());
            }
        } while (validationAvailable);
        //

        Date saleDate = null;
        boolean validationSaleDate = true;
        do {
            try {
                System.out.print("SaleDate (dd/MM/yyyy): ");
                String saleDateStr = scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                saleDate = sdf.parse(saleDateStr);
                validationSaleDate = false;
            } catch (ParseException e) {
                System.out.println("saleDate was wrong formatter");
            }
        } while (validationSaleDate);
        //
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductPrice(Float.parseFloat(productPrice));
        product.setAvailable(Boolean.parseBoolean(available));
        product.setSaleDate(saleDate);
        products.add(product);
    }
    private static void showProduct(){
        System.out.println("---DISPLAY PRODUCT--");
        products.sort(Comparator.comparing(Product::getProductId));
        products.forEach(Product::displayInformationProduct);
    }
    private static void searchProductByPrice(){
        System.out.println("---SEARCH PRODUCT BY PRICE--");
        //search
        for (Product product : products) {
            if (product.getProductPrice() >= 300 && product.getProductPrice() <= 600) {
                product.displayInformationProduct();
            }
        }
    }
    private static void searchProductByAvailable(){
        System.out.println("---SEARCH PRODUCT BY SALE DATE--");
        //search
        for (Product product : products) {
            if (product.isAvailable()) {
                product.displayInformationProduct();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("---CASE OF INFORMATION PRODUCT--");
        System.out.println("---case 1: Input information product");
        System.out.println("---case 2: Display  products");
        System.out.println("---case 3: Search product by price");
        System.out.println("---case 4: Search product by sale date");
        System.out.println("---case 5: End programming");
        System.out.print("---SELECT CASE YOU WANT TO ACTION---: ");
        int caseOfMenu = scanner.nextInt();
        scanner.nextLine();
        do {
            switch (caseOfMenu) {
                case 1:
                    //Bai 1: add
                    MainProduct.addProduct();
                    break;
                case 2:
                    //Bai2: display
                    MainProduct.showProduct();
                    break;
                case 3:
                    //Bai3: search
                    MainProduct.searchProductByPrice();
                    break;
                case 4:
                    //Bai 4: search
                    MainProduct.searchProductByAvailable();
                    break;

            }

            System.out.println("---CASE OF INFORMATION PRODUCT--");
            System.out.println("---case 1: Input information product");
            System.out.println("---case 2: Display  products");
            System.out.println("---case 3: Search product by price");
            System.out.println("---case 4: Search product by sale date");
            System.out.println("---case 5: End programming");
            System.out.print("---SELECT CASE YOU WANT TO ACTION---: ");
            caseOfMenu = scanner.nextInt();
            scanner.nextLine();

        } while (caseOfMenu >= 1 && caseOfMenu <= 4);
    }
}
