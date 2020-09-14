package com.example.order.center.manual;

/**
 * @author shihao
 * @Title: OrderProductList
 * @ProjectName Second-order-center
 * @Description: 订单商品
 * @date Created in
 * @Version: $
 */
public class OrderProductList {
    private Integer goodsId;//物品id
    private Integer productId;//商品id
    private String productName;//商品名称
    private String productDesc;//商品描述
    private String prouctFile;//商品图
    private Integer isPutaway;//是否上架
    private String productState;//商品状态
    private Integer sellPrice;//售卖价格
    private Integer linePrice;//划线价格
    private Integer quantity;//购买数量
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProuctFile() {
        return prouctFile;
    }

    public void setProuctFile(String prouctFile) {
        this.prouctFile = prouctFile;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(Integer linePrice) {
        this.linePrice = linePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
