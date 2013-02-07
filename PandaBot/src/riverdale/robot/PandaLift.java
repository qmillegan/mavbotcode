/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdale.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author FIRST
 */
public class PandaLift {
    
    private Jaguar jagLiftLeft;
    private Jaguar jagLiftRight;
    private DigitalInput upSwitch; //limit switch top
    private DigitalInput downSwitch; //limit switch bottom
    
    PandaLift(Jaguar jagLiftLeftPort, Jaguar jagLiftRightPort, int upSwitchPort, int downSwitchPort, int joyPort){
        this.jagLiftLeft = jagLiftLeftPort;
	this.jagLiftRight = jagLiftRightPort;
        upSwitch = new DigitalInput(upSwitchPort);
        downSwitch = new DigitalInput(downSwitchPort);
    }
    
    public void lift(){
	
    }
}