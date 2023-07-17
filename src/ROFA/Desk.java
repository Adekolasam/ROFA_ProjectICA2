
package ROFA;


public class Desk extends FurnitureAbs {
    private final float DESKHEIGHT = 80;
    
    public float width;
    public float depth;
    public int noOfDrawers;
    
    public Desk(){
        
    }
    public Desk(int idNumber, String woodType, int qty, float width, float depth, int noOfDrawers){
        this.idNumber = idNumber;
        this.woodType = woodType;
        this.qty = qty;
        this.width = width;
        this.depth = depth;
        this.noOfDrawers = noOfDrawers;
        
        this.init();
    }
    
    public Desk(int idNumber, String woodType, float price, int qty, float width, float depth, int noOfDrawers){
        this.idNumber = idNumber;
        this.woodType = woodType;
        this.price = price;
        this.qty = qty;
        this.width = width;
        this.depth = depth;
        this.noOfDrawers = noOfDrawers;
        
        this.init();
    }
    
    private void init(){
        this.setImage();
        this.setPrice();
    }
    
    @Override
    public final void setImage(){
        if(woodType.equals(OAKTYPE)){
            image = _imageHolder.oakDesk;
        }
        else{
            image = _imageHolder.walnutDesk;
        }
    }
    
    @Override
    public final void setPrice(){
        if(woodType.equals(OAKTYPE)){
            price = (((DESKHEIGHT + width + depth) * 12) + (width * depth) * OAKPRICE)
                    + (noOfDrawers * (float)8.5);
        }
        else{
            price = (((DESKHEIGHT + width + depth) * 12) + (width * depth) * WALNUTPRICE)
                    + (noOfDrawers * (float)8.5);
        }
    }
    
    
    @Override
    public String toString(){
        return (
                "Id Number: " + idNumber
                + ", Item: Desk"
                + ", Price: " + price
                + ", Total Price: " + this.getCharge()
        );
    }
}
