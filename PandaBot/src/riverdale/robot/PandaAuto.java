/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdale.robot;

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
    public void step(){
	//do autonomous stuff
        double num = 0;
        while(num!=4){
            shooter.step();
            num = num + 1;
    }   
    
}}
