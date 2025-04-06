/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author nagli
 */
public class Sloop extends Ship
{
     /** Constructor requires the name of the Ship, the captains name, amount of
     * decks, amount of marines, amount of cannons and if the ship has a doctor 
     * or pinnace.
     * Also initialises the ships state to reserve, calls the abstract methods 
     * setNavyRules and setFee and finalises the HashMap for a finished set up
     * @param nameIn the name of the ship
     * @param capIn the name of the captain
     * @param cf the commission fee for the Ship since Sloops set their own fee
     * @param dIn amount of decks
     * @param mIn amount of marines
     * @param cIn amount of cannons
     * @param dcIn if doctor or pinnace is on the ships
     */  
    public Sloop(String nameIn, String capIn,int cf, int dIn, int mIn, int cIn, boolean dcIn)
    {
        super(nameIn, capIn, dIn, mIn, cIn, dcIn);
        this.type = "Sloop";// initialise type
        this.battleSkill = 5;// initialise battle skill, all Sloops have 5
        this.commissionFee = cf;//set commission fee
    }
    
    /** Sets blockade to true since Sloops can fight blockade
     **/
    @Override
    public void setNavyRules()
    {
        this.blockade = true;   
    }
    
    /** Sets the ships commission fee
     **/
    @Override
    public int setFee()
    {
        return this.commissionFee ; //sloops set their own fees
    }
    
}
