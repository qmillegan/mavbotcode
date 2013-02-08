/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

/**
 *
 * @author FIRST
 */
public class PandaShoot {
    private Jaguar rotaryJag;
    private Jaguar hopperJag;
    private Joystick joystick;

    PandaShoot(Jaguar rotaryJag, Jaguar hopperJag, Joystick joystick){
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
	this.joystick = joystick;
    }
    
    public void step() {
	
    }
}
