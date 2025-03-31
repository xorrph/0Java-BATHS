/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.util.ArrayList;
/**
 *
 * @author nagli
 */
public class Fleet 
{
    ArrayList<Ship> squadron;
    ArrayList<Ship> reserve;
     //blueAdmiral BA
    boolean manageSR;
     
    public Fleet()//baIn
    {
        ArrayList<Ship> squadron = new ArrayList<>();
        ArrayList<Ship> reserve = new ArrayList<>();
        //blueAdmiral BA = baIn;
        boolean manageSR = true;
        
    }
    
    public void addShip(Ship s)
    {
        this.reserve.remove(s);
        this.squadron.add(s);
        s.commissionShip();
        //BA.updateChest(s.getComissionFee() * -1)
    }
    
    public void decommission(Ship s)
    {
        this.squadron.remove(s);
        s.decommissionShip();
        this.reserve.add(s);
        //BA.updateChest(s.getComissionFee()/ 2)
    }
    
    public void restShip(Ship s)
    {
        s.shipRest();
    }
    
    public void restoreRestingShip(Ship s)
    {
        s.restoreShip();
    }
    
    public void findSquadronShip(String name)
    {
        
    }

}
