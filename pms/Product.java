package pms;

public abstract class Product  {
    private  String icode;
    private  String name;
    private  Double purchased_price;
    private  Double selling_price;
    private int qty;
    private String manufacture;    
    
    public Product( String icode, String name, Double purchased_price,Double selling_price,int qty,String manufacture){
       this.icode =icode;
       this.name=name;
       this.purchased_price= purchased_price;
       this.selling_price = selling_price;
       this.qty=qty;
    }
    
    public Product (String icode, String name,String manufacture){
        this.icode=icode;
        this.name=name;
        this.manufacture = manufacture;
    }
    
    public Product( String icode, Double purchased_price,Double selling_price,int qty){
       this.icode =icode;
       this.purchased_price= purchased_price;
       this.selling_price = selling_price;
       this.qty=qty;
    }
    /**
     * @return the icode
     */
    public String getIcode() {
        return icode;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the purchased_price
     */
    public Double getPurchased_price() {
        return purchased_price;
    }

    /**
     * @param purchased_price the purchased_price to set
     */
    public void setPurchased_price(Double purchased_price) {
        this.purchased_price = purchased_price;
    }

    /**
     * @return the selling_price
     */
    public Double getSelling_price() {
        return selling_price;
    }

    /**
     * @param selling_price the selling_price to set
     */
    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
    }
    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    /**
     * @return the manufacture
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * @param manufacture the manufacture to set
     */
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
    
    public abstract void add_newmedicine();
    public abstract void remove_item();    
   

    
    
     
     
    
    
    
    
    
    
    
    
    
}

