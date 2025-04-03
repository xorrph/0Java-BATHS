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
public class Encouters
{
    private ArrayList<Encounter> encounters;

    public Encouters()
    {
        this.encounters = new ArrayList<Encounter>();
    }
    
    public Encouters(ArrayList<Encounter> es)
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
    
    public Encounter findEncounter(int id)
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
    
    public String showAllEncounters()
    {
        String str = "";
        for (Encounter e: this.encounters)
        {
                str = str + e.toString()+ "\n";
        }
        return str;
    }

}
