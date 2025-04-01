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
    ArrayList<Ship> managingFleet;
     //blueAdmiral BA
     
    public Fleet()//baIn
    {
        this.squadron = new ArrayList<Ship>();
        this.reserve = new ArrayList<Ship>();
        this.managingFleet = squadron;
        //blueAdmiral BA = baIn;
        
    }
    
    public void setFleetToManage(boolean Res)
    {
        if(Res)
        {
            this.managingFleet = this.reserve;
        }
        else
        {
            this.managingFleet = this.squadron;
        }
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
    
    public Ship findShip(String name)
    {
        for (Ship s: this.managingFleet)
        {
            if(s.getName().equals(name))
            {
                return s;
            }
        }
        return null;
    }
    
    public String showAllShips()
    {
        String str = "";
        for (Ship s: this.managingFleet)
        {
                str = str + s.toString()+ "\n";
        }
        return str;
    }
    
    

}
