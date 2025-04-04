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
        this.encounters = new HashMap<Integer,Encounter>();
    }
    
    public Encounters(HashMap<Integer,Encounter> es)
    {
        this.encounters = es;
    }
    
    public void encounterFound(Encounter e)
    {
        this.encounters.put(e.getEncounterNo(),e);
    }
        
    public int getSize()
    {
        return this.encounters.size();
    }
    
    public void encounterFinished(Encounter e)
    {
        this.encounters.remove(e.getEncounterNo());
    }
    
    public Encounter findEncounter(int id)
    {
        return this.encounters.get(id);
    }
    
    public String showAllEncounters()
    {
        String str = "";
        for (int i: this.encounters.keySet())//keyset turns into a list of keys
        {
                str = str + this.encounters.get(i).toString()+ "\n";// access the value pair(encounter object)
        }
        return str;
    }

}
