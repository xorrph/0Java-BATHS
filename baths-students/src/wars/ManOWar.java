/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author nagli
 */
public class ManOWar extends Ship
{
     /** Constructor requires the name of the Ship, the captains name, amount of
     * decks, amount of marines, amount of cannons and if the ship has a doctor 
     * or pinnace.
     * Also initialises the ships state to reserve, calls the abstract methods 
     * setNavyRules and setFee and finalises the HashMap for a finished set up
     * @param nameIn the name of the ship
     * @param capIn the name of the captain
     * @param bsIn the battle skill of the ship
     * @param dIn amount of decks
     * @param mIn amount of marines
     * @param cIn amount of cannons
     * @param dcIn if doctor or pinnace is on the ships
     */ 
    public ManOWar(String nameIn, String capIn, int bsIn, int dIn, int mIn, int cIn, boolean dcIn)
    {
        super(nameIn, capIn, dIn, mIn, cIn, dcIn);
        this.type = "ManOWar";
        this.battleSkill = bsIn;
    }
    
    /** Sets blockade to true since ManOWars can fight blockade
     **/
    @Override
    public void setNavyRules()
    {
        this.blockade = true;   
    }
    
    /** Sets the fee based on decks
     * 3 and above = 500
     * 2 and below = 300
     **/
    @Override
    public int setFee()
    {
        if (this.decks <= 2)
        {
            return 300;
        }
        return 500; //cost is 500 unless only having 2 decks (might change to == since spec is unclear)
    }
}
