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
    
    /**returns an ArrayList of all Ships in reserve state
    * @returns an ArrayList of all Ships in reserve state
    */

    public ArrayList<Ship> reserve()
    {
        return ships.getFiltered(ship -> ship.getState() == ShipState.RESERVE);
    }
      
    /**Returns an ArrayList representation of all the ships with an active state
    * @return an ArrayList representation of all the ships with an active state
    **/
    public ArrayList<Ship> squadron()
    {
        return ships.getFiltered(ship -> ship.getState() == ShipState.ACTIVE);
    }
    
    public void decommission(Ship s)
    {
        if(s.state != ShipState.SUNK)
        {
            s.decommissionShip();
        }

    }
    
    public void restShip(Ship s)
    {
        if(s.state != ShipState.SUNK)
        {
            s.shipRest();
        }
    }
    
    public void shipActivate(Ship s)
    {
        if(s.state != ShipState.SUNK)
        {
            s.activateShip();
        }
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
