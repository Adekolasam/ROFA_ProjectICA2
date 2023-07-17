/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ROFA;



//implements IFurniture
abstract class FurnitureAbs {
    final protected FurnitureImages _imageHolder;
    
    final protected String OAKTYPE = "Oak";
    //final private String WALNUTTYPE = "Walnut";
    final protected float OAKPRICE = 4;
    final protected float WALNUTPRICE = 3;
    
    protected int idNumber;
    protected String woodType;
    protected float price;
    protected int qty;
    protected String image;

    FurnitureAbs() {
        this._imageHolder = new FurnitureImages();
    }
    
    public abstract void setImage();
    public abstract void setPrice();
    
    @Override
    public abstract String toString();
    
    public float getCharge(){
        return (price*qty);
    }
       //abstract methods
//    protected abstract void setIdNumber(int id);
//    protected abstract void setWoodType(String woodType);
//    protected abstract void setPrice(float price);
//    protected abstract void setQty(int qty);
//    protected abstract void setImage(String image);
    
    
//    @Override
//    public void setIdNumber(int id) {
//        this.idNumber = id;
//    }
//    
//    @Override
//    public void setWoodType(String woodType) {
//        this.woodType = woodType;
//    }
//    
//    @Override
//    public void setPrice(float price) {
//        this.price = price;
//    }
//    
//    @Override
//    public void setQty(int qty) {
//        this.qty = qty;
//    }
//
//    @Override
//    public void setImage(String image) {
//        this.image = image;
//    }
     
}
