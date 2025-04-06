/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;
import java.io.Serializable;
import java.util.HashMap;
/**
 *
 * @author nagli
 */
public class Encounters implements Serializable 
{
    private HashMap<Integer,Encounter> encounters;

    /** Constructor initialises a HashMap to pair Integer and Encounters to act 
     * like a list however if in the future encounters are finished their IDS are
     * still the same
     */ 
    public Encounters()
    {
        this.encounters = new HashMap<Integer,Encounter>(); //creating a blank HashMap to add to
    }
    
    /** Add a new Encounter to the HashMap, paired with its Encounter number / id
     * @param e the encounter to be added to the HashMap
     */ 
    public void encounterFound(Encounter e) // check if Encounter exists
    {
        this.encounters.put(e.getEncounterNo(),e);
    }
    
    /** Remove a new Encounter to the HashMap, removed via its Encounter number / id
     * @param e the encounter to be removed from the HashMap
     */ 
    public void encounterFinished(Encounter e) //remove encounter from the hashMap for future implementations
    {
        this.encounters.remove(e.getEncounterNo());
    }
    
    /** Return the size of the HashMap
     * @return the amount of pairs within the HashMap
     */ 
    public int getSize() //get the size of the hashmap
    {
        return this.encounters.size();
    }
    
    /** Return the Encounter object based on its id
     * @param id the unique identifier for the Encounter that the encounter object is paired with
     * @return the corresponding Encounter object based on its id
     */ 
    public Encounter findEncounter(int id) //retrieve object encounter from id (return null if not found)
    {
        return this.encounters.get(id);
    }
    
    /**Return a String representation of all Encounters within the HashMap
     * @return a String representation of all Encounters within the HashMap
     */ 
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
