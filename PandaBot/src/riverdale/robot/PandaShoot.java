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
    private Jaguar jagShoot;
    private int port;
    //private GenericHID joystick;
    //private int shootButton = 1;
    //private int port = 1;
    
    //JoystickButton button = new JoystickButton(joystick, shootButton);
    
    PandaShoot(Jaguar jagShoot, int port){
        this.jagShoot = jagShoot;
	this.port = port;
    }
    
    Joystick joystick = new Joystick(port);
    
    public void testState() {
	if (joystick.getTrigger()) {
	    jagShoot.set(0.9);
	    Timer.delay(1000);
	    jagShoot.stopMotor();
	}
    }
    public void shoot(){ //sample code, change
        jagShoot.set(0.9);
        Timer.delay(1000);
        jagShoot.stopMotor();
    }
}