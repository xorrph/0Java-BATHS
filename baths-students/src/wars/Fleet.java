/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author nagli
 */
public class Fleet implements Serializable 
{
    private FilteredList<Ship> ships;
    
     /**Constructor for the fleet, initialises a FilteredList called ships which
     *  containing all the ships
     */ 
    public Fleet()
    {
        this.ships =  new FilteredList<Ship>();
    }
    
     /**Constructor for the fleet, initialises a FilteredList called ships which
     *  containing all the ships
     *  @param ss pass in a list to initialise Fleet without being empty and adding each item one by one
     */ 
    public Fleet(ArrayList<Ship> ss)
    {
        this.ships =  new FilteredList<Ship>(ss);
    }
    
     /**Method for returning an ArrayList version of all the ships
     * @return an ArrayList of all the ships inside of the ships attribute
     */ 
    public ArrayList<Ship> allShips()
    {
        return ships.getAll();
    }
    
    /**returns an ArrayList of all Ships in sunk state
    * @returns an ArrayList of all Ships in sunk state
    */
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
    
    /**Sets a specific ship to a RESERVE state
     * @param s the ship to be decommissioned
    */
    public void decommission(Ship s)
    {
        if(s.state != ShipState.SUNK)
        {
            s.decommissionShip();
        }

    }
    
    /**Sets a specific ship to a RESTING state
     * @param s the ship to rest
    */
    public void restShip(Ship s)
    {
        if(s.state != ShipState.SUNK)
        {
            s.shipRest();
        }
    }
    
    /**Sets a specific ship to a ACTIVE state
     * @param s the ship to be commissioned or restored
    */
    public void shipActivate(Ship s)
    {
        if(s.state != ShipState.SUNK)
        {
            s.activateShip();
        }
    }
    
    /**Finds and returns the ship object with a the matching name out of every Ship ever
     * @param name the ship to be decommissioned
     * @return the Ship object found by its name
    */
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
    
    /**Finds and returns the ship object with a the matching name out of a sublist
     * @param name the ship to be decommissioned
     * @param managingFleet the sublist of ships to search through
     * @return the Ship object found by its name
    */
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
    
    /**Finds and returns the ship object with a the matching name out of every Ship ever
     * @return all Ship details included within the ships attribute
    */
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
