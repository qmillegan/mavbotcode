/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdale.robot;

import edu.wpi.first.wpilibj.*;

/*
 *
 * @author Grant Vesely
 */

public class PandaShoot {
    private Jaguar rotaryJag;
    private Jaguar hopperJag;
    private Jaguar camJag;
    private Joystick joystick;
    private double timeStarted = 0;
    private double delay;
    DriverStationLCD lcd;
    // timeStarted tracks when the current shoot sequence started
    private double spinDownTime = 1;
    // spinDownTime tracks how long until the shooter motor needs to stop
    private boolean running = true;
    Timer clock = new Timer();

    PandaShoot(Jaguar rotaryJag, Jaguar hopperJag, Jaguar camJag, Joystick joystick) {
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
	this.camJag = camJag;
	this.joystick = joystick;
	clock.start();
    }
    
    public void step() {
	//possibly use joystick.getY() to change teh cam angle?
	/*lcd = DriverStationLCD.getInstance();
	lcd.println(DriverStationLCD.Line.kUser2, 1, "" + rotaryJag.get());
	lcd.updateLCD();
	*/
	camJag.set(joystick.getY());
	
	if (joystick.getTrigger()) {
	    // Turn the hopper
	    hopperJag.set(-0.9);
	    //may want to introduce a time delay here to prevent rapid fire frisbees
	} else {
	    hopperJag.set(0);
	}
	
	//using twist on joy2 as a 'switch' for the rotaryJag
	if (joystick.getTwist() <= 0) {
	    // Turn the hopper
	    //double d = joystick.getTwist();
	    //crioOut(""+d);
	    rotaryJag.set(1.0);
	    //may want to introduce a time delay here to prevent rapid fire frisbees
	} else {
	    rotaryJag.set(0);
	}
	//Sorry grant, and thanks for letting me recycle some of your code. 
	/*
	if (joystick.getTrigger() && !running) {
	    // Turn the hopper
	    running = true;
	    timeStarted = clock.get();
	    rotaryJag.set(0.9);
	    hopperJag.set(1.0);
	} else if (!joystick.getTrigger() && running) {
	    // Stop the hopper motor and spin down the shooter motor
	    hopperJag.set(0);
	    if (spinDownTime > 0) {
		// If the spin time is greater then zero, then the shooter motor
		// is still spinning, so decrement the counter and continue
		spinDownTime -= (clock.get() - timeStarted);
	    } else {
		// If the spin time is lesser than or equal to zero, then stop
		// the spin motor and reset the spin time counter
		running = false;
		spinDownTime = 1;
		rotaryJag.set(0);
	    }
	    
	 }
    */
    }
    public void crioOut(String out) {
	lcd = DriverStationLCD.getInstance();
	lcd.println(DriverStationLCD.Line.kUser2, 1, out);
	lcd.updateLCD();
    }
}
