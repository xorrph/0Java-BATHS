package wars;

import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the BATHS
 system as required for 5COM2007 Cwk1B BATHS - Feb 2025
 * 
 * @author A.A.Marczyk 
 * @version 16/02/25
 */

public class SeaBattles implements BATHS 
{
    private String admiral;
    private String filename;
    private Fleet fleet;
    private Encounters enc;
    private double warChest;


//**************** BATHS ************************** 
    /** Constructor requires the name of the admiral
     * @param adm the name of the admiral
     */  
    public SeaBattles(String adm)
    {
       this.admiral = adm;
       this.warChest = 1000;
       setupShips();
       setupEncounters();
    }
    
    /** Constructor requires the name of the admiral and the
     * name of the file storing encounters
     * @param admir the name of the admiral
     * @param filename name of file storing encounters
     */  
    public SeaBattles(String admir, String filename)  //Task 3
    {
      
       this.filename = filename;
       this.warChest = 1000;
       setupShips();
       //setupEncounters();
       readEncounters(filename);
    }
    
    
    /**Returns a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     * @return a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     **/
    public String toString()
    {
        String admState = "Not ok";
        if(this.isDefeated() == false)
        {
            admState = "Is OK";
        }
        String str = "Admiral " + this.admiral + "\nState of Warchest: " + this.warChest + "\n";
        str += "Admiral state: " + admState + "\n";
        str += this.getSquadron() + "\n" +this.getReserveFleet();
        return str;
    }
    
    
    /** returns true if War Chest <=0 and the admiral's squadron has no ships which 
     * can be retired. 
     * @returns true if War Chest <=0 and the admiral's fleet has no ships 
     * which can be retired. 
     */
    public boolean isDefeated()
    {
        if (this.warChest <=0 && this.fleet.squadron().size() ==0)
        {
            return true;
        }
        return false;
    }
    
    /** returns the amount of money in the War Chest
     * @returns the amount of money in the War Chest
     */
    public double getWarChest()
    {
        return this.warChest;
    }
    
    
    /**Returns a String representation of all ships in the reserve fleet
     * @return a String representation of all ships in the reserve fleet
     **/
    public String getReserveFleet()
    {   
        String str = "Reserve Ships \n";
        for (Ship s: this.fleet.reserve())
        {
                str = str + s.toString()+ "\n";
        }
        if (this.fleet.reserve().size() > 0)
        {
            return str;
        }
        return "No ships in reserve";
    }
    
    /**Returns a String representation of the ships in the admiral's squadron
     * or the message "No ships commissioned"
     * @return a String representation of the ships in the admiral's fleet
     **/
    public String getSquadron()
    {
        String str = "Squadron Ships \n";
        for (Ship s: this.fleet.squadron())
        {
                str = str + s.toString()+ "\n";
        }
        if (this.fleet.squadron().size() > 0)
        {
            return str;
        }
        return "No ships commissioned";
    }
    
    /**Returns a String representation of the ships sunk (or "no ships sunk yet")
     * @return a String representation of the ships sunk
     **/
    public String getSunkShips()
    {
        String str = "Sunk Ships \n";
        for (Ship s: this.fleet.sunkShips())
        {
                str = str + s.toString()+ "\n";
        }
        if (this.fleet.sunkShips().size() > 0)
        {
            return str;
        }
        return "No Ships sunk yet";
    }
    
    /**Returns a String representation of the all ships in the game
     * including their status
     * @return a String representation of the ships in the game
     **/
    public String getAllShips()
    {
        return this.fleet.toString();
    }
    
    
    /** Returns details of any ship with the given name
     * @return details of any ship with the given name
     **/
    public String getShipDetails(String nme)
    {
        
        Ship s = this.fleet.findShip(nme);
        
        if(s != null)
        {
            return s.toString();
        }
        
        return "\nNo such ship";
    }     
 
    // ***************** Fleet Ships ************************   
    /** Allows a ship to be commissioned to the admiral's squadron, if there 
     * is enough money in the War Chest for the commission fee.The ship's 
     * state is set to "active"
     * @param nme represents the name of the ship
     * @return "Ship commissioned" if ship is commissioned, "Not found" if 
     * ship not found, "Not available" if ship is not in the reserve fleet, "Not 
     * enough money" if not enough money in the warChest
     **/        
    public String commissionShip(String nme)
    {
        Ship s = this.fleet.findShip(nme,this.fleet.reserve()); 
        if(s != null) // In reserve to be commissioned
        {
            if(this.warChest - s.getCommissionFee() >= 0) // enough money check
            {
                this.fleet.shipActivate(s);// commission the ship to squadron
                this.warChest -= s.getCommissionFee();
                return "Ship commissioned";
            }
            return "Not enough money";
        }
        else if(this.fleet.findShip(nme) != null)//check if not in reserve but still in the list
        {
            return "Not available"; // not within reserve for whatever reason 
        }
        return "Not found";
    }
        
    /** Returns true if the ship with the name is in the admiral's squadron, false otherwise.
     * @param nme is the name of the ship
     * @return returns true if the ship with the name is in the admiral's squadron, false otherwise.
     **/
    public boolean isInSquadron(String nme)
    {
        if(this.fleet.findShip(nme,this.fleet.squadron()) != null)
        {
            return true;
        }
        return false;
    }
    
    /** Decommissions a ship from the squadron to the reserve fleet (if they are in the squadron)
     * pre-condition: isInSquadron(nme)
     * @param nme is the name of the ship
     * @return true if ship decommissioned, else false
     **/
    public boolean decommissionShip(String nme)
    {
        if(this.isInSquadron(nme) == true)
        {
            Ship s = this.fleet.findShip(nme);
            this.fleet.decommission(s);
            this.warChest += (s.getCommissionFee() / 2);
            return true;
        }
        return false;
    }
    
  
    /**Restores a ship to the squadron by setting their state to ACTIVE 
     * @param ref the name of the ship to be restored
     */
    public void restoreShip(String ref)
    {
        if(this.fleet.findShip(ref) != null)
        {
            this.fleet.shipActivate(this.fleet.findShip(ref));
        }
        
    }
    
//**********************Encounters************************* 
    /** returns true if the number represents a encounter
     * @param num is the reference number of the encounter
     * @returns true if the reference number represents a encounter, else false
     **/
     public boolean isEncounter(int num)
     {
         Encounter e = this.enc.findEncounter(num);
         if (e != null)
         {
             return true;
         }
         return false;
     }
     
     
/** Retrieves the encounter represented by the encounter 
      * number.Finds a ship from the fleet which can fight the 
      * encounter.The results of fighting an encounter will be 
      * one of the following: 
      * 0-Encounter won by...(ship reference and name)-add prize money to War 
      * Chest and set ship's state to RESTING,  
      * 1-Encounter lost as no ship available - deduct prize from the War Chest,
      * 2-Encounter lost on battle skill and (ship name) sunk" - deduct prize 
      * from War Chest and set ship state to SUNK.
      * If an encounter is lost and admiral is completely defeated because there 
      * are no ships to decommission,add "You have been defeated " to message, 
      * -1 No such encounter
      * Ensure that the state of the war chest is also included in the return message.
      * @param encNo is the number of the encounter
      * @return a String showing the result of fighting the encounter
      */ 
    public String fightEncounter(int encNo)
    {
       if (this.isEncounter(encNo))
       {
           Encounter e = enc.findEncounter(encNo);
           for(Ship s: this.fleet.squadron())
           {
               if(s.canFight(e.getType()))
               {
                   if(s.getBattleSkill() >= e.getReqSkill())
                   {
                       this.warChest += e.getPrizeMoney();
                       s.shipRest();
                       return "Encounter won by " + s.getName() + " led by " + s.getCaptain() +"\n" + "Warchest is now: " + this.warChest;
                   }
                   else
                   {
                       this.warChest -= e.getPrizeMoney();
                       s.shipSunk();
                       return "Encounter lost on battle skill and" + s.getName() + "sunk"+"\n" + "Warchest is now: " + this.warChest;
                   }
               }
           }
           if(this.isDefeated() == true)
           {
               return "You have been defeated" +  "\n" + "Warchest is now: " + this.warChest;
           }
           this.warChest -= e.getPrizeMoney();
           return "no ship available to fight encounter" + "\n" + "Warchest is now: " + this.warChest;
       }
       
       return "No such encounter";
    }

    /** Provides a String representation of an encounter given by 
     * the encounter number
     * @param num the number of the encounter
     * @return returns a String representation of a encounter given by 
     * the encounter number
     **/
    public String getEncounter(int num)
    {
        if (this.isEncounter(num))
        {
            Encounter e = enc.findEncounter(num);
            return e.toString();
        }
        return "\nNo such encounter";
    }
    
    /** Provides a String representation of all encounters 
     * @return returns a String representation of all encounters
     **/
    public String getAllEncounters()
    {
        if(enc.getSize() > 0)
        {
            return enc.toString();
        }
        return "No encounters";
    }
    

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
     private void setupShips()
     {
       ManOWar Victory = new ManOWar("Victory","Alan Aikin",3, 3, 30, 0, false); 
       Frigate Sophie = new Frigate("Sophie","Ben Baggins",8,0,0,16,true);
       ManOWar Endeavour = new ManOWar("Endeavour","Col Cannon",4,2,20,0,false);
       Sloop Arrow = new Sloop("Arrow","Dan Dare",150,0,0,0,true);
       ManOWar Belerophon = new ManOWar("Belerophon","Ed Evans",8,3,50,0,false);
       Frigate Surprise = new Frigate("Surprise","Fred Fox",6,0,0,10,false);
       Frigate Jupiter = new Frigate("Jupiter","Gil Gamage",7,0,0,20,false);
       Sloop Paris = new Sloop("Paris","Hal Henry",200,0,0,0,true);
       Sloop Beast = new Sloop("Beast","Ian Idle",400,0,0,0,false);
       Sloop Athena = new Sloop("Athena","John Jones",100,0,0,0,true);
       Fleet ss = new Fleet(new ArrayList<Ship>(List.of(Victory,Sophie,Endeavour,Arrow,Belerophon,Surprise,Jupiter,Paris,Beast,Athena)));
       this.fleet = ss;
     }
     
    private void setupEncounters()
    {
        Encounter e1 = new Encounter(1,EncounterType.BATTLE,"Trafalgar",3,300);
        Encounter e2 = new Encounter(2,EncounterType.SKIRMISH,"Belle Isle",3,120);
        Encounter e3 = new Encounter(3,EncounterType.BLOCKADE,"Brest",3,150);
        Encounter e4 = new Encounter(4,EncounterType.BATTLE,"St Malo",9,200);
        Encounter e5 = new Encounter(5,EncounterType.BLOCKADE,"Dieppe",7,90);
        Encounter e6 = new Encounter(6,EncounterType.SKIRMISH,"Jersey",8,45);
        Encounter e7 = new Encounter(7,EncounterType.BLOCKADE,"Nantes",6,130);
        Encounter e8 = new Encounter(8,EncounterType.BATTLE,"Finisterre",4,100);
        Encounter e9 = new Encounter(9,EncounterType.SKIRMISH,"Biscay",5,200);
        Encounter e10 = new Encounter(10,EncounterType.BATTLE,"Cadiz",1,250);
        Encounters e = new Encounters();
        e.encounterFound(e1);
        e.encounterFound(e2);
        e.encounterFound(e3);
        e.encounterFound(e4);
        e.encounterFound(e5);
        e.encounterFound(e6);
        e.encounterFound(e7);
        e.encounterFound(e8);
        e.encounterFound(e9);
        e.encounterFound(e10);
        System.out.println("Encounters initialised");
        this.enc = e;
    }
    
    /** Provides an EncounterType object from a string
     * @param type string text of the encounter type
     * @return returns  an EncounterType object from a string
     **/
    private EncounterType getEncounterType(String type)
    {
        HashMap<String,EncounterType> encTypes = new HashMap<String,EncounterType>();
        encTypes.put("Battle",EncounterType.BATTLE);
        encTypes.put("Skirmish",EncounterType.SKIRMISH);
        encTypes.put("Blockade",EncounterType.BLOCKADE);
        return encTypes.get(type);
    }
// Useful private methods to "get" objects from collections/maps

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3 ************************************************/

    
    //******************************** Task 3.5 **********************************
    /** reads data about encounters from a text file and stores in collection of 
     * encounters.Data in the file is editable
     * @param filename name of the file to be read
     */
    public void readEncounters(String filename)
    { 
        this.enc = new Encounters();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            int i = 0;
            while((line = reader.readLine()) != null)
            {
               String[] s = line.split("[,]",0);
               this.enc.encounterFound(new Encounter(i,this.getEncounterType(s[0]),s[1],Integer.parseInt(s[2]),Integer.parseInt(s[3])));
               i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }   
 
    
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname)
    {   // uses object serialisation 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname))) 
        {
            oos.writeObject(this);
            //System.out.println("Serialized: " + this);
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as an SeaBattles object)
     */
    public SeaBattles loadGame(String fname)
    {   // uses object deserialisation 
        SeaBattles loaded = null;
        System.out.println("beforeTEST");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname))) 
        {
            System.out.println("TEST");
            loaded = (SeaBattles) ois.readObject();
            System.out.println("Deserialized: " + loaded);
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.out.println("TESTFAIL");
            e.printStackTrace();
        }
        return loaded;
    } 
    
 
}



