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
public class firstSeaLord
{
    private ArrayList<Encounter> encounters;

    public firstSeaLord()
    {
        this.encounters = new ArrayList<Encounter>();
    }
    
    public firstSeaLord(ArrayList<Encounter> es)
    {
        this.encounters = es;
    }
    
    public void encounterFound(Encounter e)
    {
        this.encounters.add(e);
    }
    
    public void encounterFinished(Encounter e)
    {
        this.encounters.remove(e);
    }
    
    public Encounter findShip(int id)
    {
        for (Encounter e: this.encounters)
        {
            if(e.getEncounterNo() == id)
            {
                return e;
            }
        }
        return null;
    }
    
    public String showAllShips()
    {
        String str = "";
        for (Encounter e: this.encounters)
        {
                str = str + e.toString()+ "\n";
        }
        return str;
    }

}
