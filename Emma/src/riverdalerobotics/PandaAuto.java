/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

/**
 *
 * @author FIRST
 */
public class PandaAuto {
    
    private PandaDrive train;
    private PandaShoot shooter;
    private PandaLift lifter;
    
    PandaAuto(PandaDrive train, PandaShoot shooter, PandaLift lifter){
	this.train = train;
	this.shooter = shooter;
	this.lifter = lifter;
    }
    
    
}
