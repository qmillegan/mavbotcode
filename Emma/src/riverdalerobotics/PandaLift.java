/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author FIRST
 */
public class PandaLift {
    private Jaguar jagLiftLeft;
    private Jaguar jagLiftRight;
    private Joystick joystick;
    //private DigitalInput upSwitch; //limit switch top
    //private DigitalInput downSwitch; //limit switch bottom
    
    PandaLift(Jaguar jagLiftLeftPort, Jaguar jagLiftRightPort, Joystick joystick){
        this.jagLiftLeft = jagLiftLeftPort;
	this.jagLiftRight = jagLiftRightPort;
	this.joystick = joystick;
        //upSwitch = new DigitalInput(upSwitchPort);
        //downSwitch = new DigitalInput(downSwitchPort);
    }
    
    public void step() {
	if (joystick.getRawButton(3)) {
	    jagLiftLeft.set(0.5);
	    jagLiftRight.set(0.5);
	} else if (joystick.getRawButton(2)) {
	    jagLiftLeft.set(0.5);
	    jagLiftRight.set(0.5);
	} else {
	    jagLiftLeft.set(0);
	    jagLiftRight.set(0);
	}
    }
    
    public void lift(){
	
    }
}
