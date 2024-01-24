package TrungHA_JavaCore;

import java.util.Date;

public class Product {
    private String productId;
    private String productName;
    private float productPrice;
    private boolean available;
    private Date saleDate;

    public Product() {
    }

    public Product(String productId, String productName, float productPrice, boolean available, Date saleDate) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.available = available;
        this.saleDate = saleDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    public void displayInformationProduct(){
        StringBuilder sb = new StringBuilder();
        String productStatus = available ? "con hang":"het hang";
        sb.append("ProductId: ")
                .append(this.productId)
                .append("\n")
                .append("ProductName: ")
                .append(this.productName)
                .append("\n")
                .append("ProductPrince: ")
                .append(this.productPrice)
                .append("\n")
                .append("Available: ")
                .append(productStatus)
                .append("\n")
                .append("SaleDate: ")
                .append(this.saleDate)
                .append("\n");
        System.out.println(sb);
    }
}
