/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.util.HashMap;
/**
 *
 * @author nagli
 */
public class Encounters
{
    private HashMap<Integer,Encounter> encounters;

    public Encounters()
    {
        this.encounters = new HashMap<Integer,Encounter>(); //creating a blank HashMap to add to
    }
    
    public void encounterFound(Encounter e) // check if Encounter exists
    {
        this.encounters.put(e.getEncounterNo(),e);
    }
        
    public int getSize() //get the size of the hashmap
    {
        return this.encounters.size();
    }
    
    public void encounterFinished(Encounter e) //remove encounter from the hashMap
    {
        this.encounters.remove(e.getEncounterNo());
    }
    
    public Encounter findEncounter(int id) //retrieve object encounter from id (return null if not found)
    {
        return this.encounters.get(id);
    }
    
    public String toString() //Return String representation of all encounters
    {
        String str = "";
        for (int i: this.encounters.keySet())//keyset turns into a list of keys
        {
                str = str + this.encounters.get(i).toString()+ "\n";// access the value pair(encounter object)
        }
        return str;
    }

}
