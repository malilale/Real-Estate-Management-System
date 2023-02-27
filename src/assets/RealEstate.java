/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

/**
 *
 * @author Muhammed Ali
 */
public class RealEstate {
    public int estateID;
    public int type;
    public int price;
    public int area;
    public String address;

    public RealEstate() {
    }

    public RealEstate(int estateID, int type, int price, int area, String address) {
        this.estateID = estateID;
        this.type = type;
        this.price = price;
        this.area = area;
        this.address = address;
    }
    
    public String getType(){
        if (type==1)
            return "Arazi";
        else
            return "Daire";
    }
}
