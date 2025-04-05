package wars;

import java.io.*;
import java.util.*;
/**
 * Task 2 - provide command line interface
 * 
 * @author A.A.Marczyk
 * @version 16/02/25
 */
public class GameUI
{
    private BATHS myBattles ;
    private Scanner myIn = new Scanner(System.in);
    
    public void doMain()
    {
        int choice;
        System.out.println("Enter admiral's name");
        String name = myIn.nextLine();
        myBattles = new SeaBattles(name); // create
        
        choice = 100;
        while (choice != 0 )
        {
            choice = getMenuItem();
            if (choice == 1)
            {
                System.out.println(myBattles.getReserveFleet());
            }
            else if (choice == 2)
            {
                System.out.println(myBattles.getSquadron());
            }
            else if (choice == 3)
            {
                System.out.println("Enter Ship name to view");
                myIn.nextLine();
                String ref = (myIn.nextLine()).trim();
                System.out.println(myBattles.getShipDetails(ref));
            } 
            else if (choice == 4)
            {
                System.out.println("Enter Ship name to commission");
                myIn.nextLine();
                String ref = (myIn.nextLine()).trim();
                System.out.println(myBattles.commissionShip(ref));

            }
            else if (choice == 5)
            {
                System.out.println(myBattles.getAllEncounters());
                System.out.println("Enter Encounter number to fight");
                int ref = myIn.nextInt();
                System.out.println(myBattles.fightEncounter(ref));
       
                  
            }
            else if (choice ==6)
            {
	        System.out.println("Enter Ship name to restore");
                myIn.nextLine();
                String ref = (myIn.nextLine()).trim();
                myBattles.restoreShip(ref);
                System.out.println(ref + " Restored");
            }
            else if (choice == 7)
            {
                System.out.println("Enter Ship name to decommission");
                myIn.nextLine();
                String ref = (myIn.nextLine()).trim();
                System.out.println("Decommission status: " + myBattles.decommissionShip(ref));
            }
            else if (choice==8)
            {
                System.out.println(myBattles.toString());
            }
            else if (choice == 9) // Task 7 only
            {
                  System.out.println("Write to file");
                  myBattles.saveGame("olenka.dat");
            }
            else if (choice == 10) // Task 7 only
            {
                System.out.println("Recommission from file");
                SeaBattles myBattles2=null;
                myBattles2.loadGame("olenka.dat");
                System.out.println(myBattles2.toString());               
            }  
        }
        System.out.println("Thank-you");
    }
    
    private int getMenuItem()
    {   int choice = 100;  
        System.out.println("Main Menu");
        System.out.println("0. Quit");
        System.out.println("1. List ships in the reserve fleet");
        System.out.println("2. List ships in admirals squadron"); 
        System.out.println("3. View a ship");
        System.out.println("4. Commission a ship into admiral's squadron");
        System.out.println("5. Fight an encounter");
        System.out.println("6. Restore a ship");
        System.out.println("7. Decommission a ship");
        System.out.println("8. View admiral's state");
        System.out.println("9. Save this game");
        System.out.println("10. Restore a game");
       
        
        while (choice < 0 || choice  > 10)
        {
            System.out.println("Enter the number of your choice");
            choice =  myIn.nextInt();
        }
        return choice;        
    } 
    
    public static void main(String[] args)
    {
        GameUI xxx = new GameUI();
        xxx.doMain();
    }
}