/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

/**
 *
 * @author FIRST
 */
public class PandaLift {
    private Jaguar jagLiftLeft;
    private Jaguar jagLiftRight;
    //private DigitalInput upSwitch; //limit switch top
    //private DigitalInput downSwitch; //limit switch bottom
    
    PandaLift(Jaguar jagLiftLeftPort, Jaguar jagLiftRightPort, Joystick joystick){
        this.jagLiftLeft = jagLiftLeftPort;
	this.jagLiftRight = jagLiftRightPort;
        //upSwitch = new DigitalInput(upSwitchPort);
        //downSwitch = new DigitalInput(downSwitchPort);
    }
    
    public void step() {
	
	
    }
    
    public void lift(){
	
    }
}
