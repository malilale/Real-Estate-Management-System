/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

import java.util.Date;

/**
 *
 * @author Muhammed Ali LALE
 */
public class Advert {
    public int estateID;
    public String description;
    public Date date;

    public Advert() {
    }

    public Advert(int estateID, String description, Date date) {
        this.estateID = estateID;
        this.description = description;
        this.date = date;
    }
    
}
