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
    private ArrayList<Ship> squadron;
    private ArrayList<Ship> reserve;
    private FilteredList<Ship> ships;
    private int size;
     
    public Fleet()//baIn
    {
        this.ships =  new FilteredList<Ship>();
    }
    
    public Fleet(ArrayList<Ship> ss)
    {
        this.ships =  new FilteredList<Ship>(ss);
    }
    
    public ArrayList<Ship> allShips()
    {
        return ships.getAll();
    }
    
    public ArrayList<Ship> sunkShips()
    {
        return ships.getFiltered(ship -> ship.getState() == ShipState.SUNK);
    }
    
    public ArrayList<Ship> reserve()
    {
        return ships.getFiltered(ship -> ship.getState() == ShipState.RESERVE);
    }
      
    
    public ArrayList<Ship> squadron()
    {
        return ships.getFiltered(ship -> ship.getState() == ShipState.ACTIVE || ship.getState() == ShipState.RESTING);
    }
    
    public void commission(Ship s)
    {
        //this.reserve().remove(s);
        //this.squadron().add(s);
        s.activateShip();
    }
    
    public void decommission(Ship s)
    {
        //this.squadron().remove(s);
        s.decommissionShip();
        //this.reserve().add(s);

    }
    
    public void restShip(Ship s)
    {
        s.shipRest();
    }
    
    public void restoreRestingShip(Ship s)
    {
        s.activateShip();
    }
    
    public Ship findShip(String name)
    {
        for (Ship s: this.ships.getAll())
        {
            if(s.getName().equals(name))
            {
                return s;
            }
        }
        return null;
    }
    
    public Ship findShip(String name, ArrayList<Ship> managingFleet)
    {
        for (Ship s: managingFleet)
        {
            if(s.getName().equals(name))
            {
                return s;
            }
        }
        return null;
    }
    
    public String toString()
    {
        String str = "";
        for (Ship s: this.ships.getAll())
        {
                str = str + s.toString()+ "\n";
        }
        return str;
    }
    
    

}
