package com.example.product.center.manual;

/**
 * @author shihao
 * @Title: WantProductList
 * @ProjectName Second-order-center
 * @Description: 收藏商品列表
 * @date Created in
 * @Version: $
 */
public class WantProductList {
    private Integer productId;//商品id
    private String productName;//商品名称
    private String productFile;//商品图
    private Integer price;//商品价格
    private Integer isWant;//是否收藏
    private String productState;//商品状态
    private Integer wantNumber;//想要数量

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductFile() {
        return productFile;
    }

    public void setProductFile(String productFile) {
        this.productFile = productFile;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIsWant() {
        return isWant;
    }

    public void setIsWant(Integer isWant) {
        this.isWant = isWant;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public Integer getWantNumber() {
        return wantNumber;
    }

    public void setWantNumber(Integer wantNumber) {
        this.wantNumber = wantNumber;
    }
}
