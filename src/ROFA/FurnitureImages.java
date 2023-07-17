
package ROFA;


public class FurnitureImages {
    private final String _baseUrl;
    public String oakChair;
    public String oakChairWithArmrests;
    public String walnutChair;
    public String walnutChairWithArmrests;
    
    public String oakDesk;
    public String walnutDesk;
    
    public String oakTable_Chrome;
    public String oakTable_Wooden;
    public String walnutTable_Chrome;
    public String walnutTable_Wooden;

    public FurnitureImages() {
        this._baseUrl = "/ROFA/images/";
        
        oakChair = this._baseUrl+"chairs/chair.png";
        oakChairWithArmrests = this._baseUrl+"chairs/chair_armrest.jpg";
        walnutChair = this._baseUrl+"chairs/walnut_chair.jpg";
        walnutChairWithArmrests = this._baseUrl+"chairs/walnut_chair_arm.jpg";

        oakDesk = this._baseUrl+"desk/desk_oak.jpg";
        walnutDesk = this._baseUrl+"desk/desk_walnut.jpg";

        oakTable_Chrome = this._baseUrl+"tables/oaktable_chrome.jpg";
        oakTable_Wooden = this._baseUrl+"tables/oaktable_wooden.jpg";
        walnutTable_Chrome = this._baseUrl+"tables/walnut_table_chrome.jpg";
        walnutTable_Wooden = this._baseUrl+"tables/walnut_table_wooden.jpg";
    }
    
}
