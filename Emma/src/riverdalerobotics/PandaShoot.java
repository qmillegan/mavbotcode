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
    private int joystickPort;

    PandaShoot(Jaguar rotaryJag, Jaguar hopperJag, int joystickPort){
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
	this.joystickPort = joystickPort;
    }
    
}
