/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author nagli
 */
public class Frigate extends Ship
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
    public Frigate(String nameIn, String capIn, int bsIn, int dIn, int mIn, int cIn, boolean dcIn)
    {
        super(nameIn, capIn, dIn, mIn, cIn, dcIn);
        this.type = "Frigate";
        this.battleSkill = bsIn;
    }
    
    /**Sets blockade to true only if the ship has a
     * doctor or pinnace, also sets skirmish to true 
     **/
    @Override
    public void setNavyRules()
    {
        if(this.ifDocPin)// pinnance checks
        {
            this.blockade = true;
        }
        this.skirmish = true;
    }
    
    /** Sets the ships commission fee based on cannons
     * £10 per cannon
     **/
    @Override
    public int setFee()
    {
        return this.cannons * 10; // every cannon costs £10
    }
}
