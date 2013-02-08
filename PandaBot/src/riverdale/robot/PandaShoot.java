/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdale.robot;

//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author FIRST
 */
public class PandaShoot {
    private Jaguar rotaryJag;
    private Jaguar hopperJag;
    private int joystickPort;
    //private GenericHID joystick;
    //private int shootButton = 1;
    //private int port = 1;
    
    //JoystickButton button = new JoystickButton(joystick, shootButton);
    
    PandaShoot(Jaguar rotaryJag, Jaguar hopperJag, int joystickPort){
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
	this.joystickPort = joystickPort;
    }
    
    Joystick joystick = new Joystick(joystickPort);
    
    public void shoot() {
	if (joystick.getTrigger()) {
	    rotaryJag.set(0.9);
	    Timer.delay(1000);		    //cant use timer.delays 
	    rotaryJag.stopMotor();
	}
    }
}