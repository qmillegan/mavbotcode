/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

import riverdalerobotics.*;

/*
 *
 * @author Grant Vesely
 */

public class PandaShoot {
    private Jaguar rotaryJag;
    private Jaguar hopperJag;
    private Jaguar camJag;
    private Joystick joystick;
    private boolean running = false;
    private boolean delay = false;
    private boolean trigger = false;
    private double time = 5000000;
    /*
    private double delay = 1000000;
    private double timeStarted = 0;
    // timeStarted tracks when the current shoot sequence started
    private double spinDownTime = 1;
    // spinDownTime tracks how long until the shooter motor needs to stop
    private boolean running = true;
    */
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
	//crioOut("PandaShoot");
	camJag.set(joystick.getY());
	/*
	if (joystick.getTrigger()) {
	    // Turn the hopper
	    hopperJag.set(-0.9);
	    //may want to introduce a time delay here to prevent rapid fire frisbees
	} else {
	    hopperJag.set(0);
	}
	*/
	trigger = joystick.getTrigger();
	
	if (trigger) {
	    if (running) {
		if (time > 0) {
		    // Trigger pulled, hopper spinning, hopper timer not expired
		    time -= clock.get();
		} else {
		    // Trigger pulled, hopper spinning, hopper timer expired
		    hopperJag.set(0);
		    running = false;
		    delay = true;
		    time = 500000;
		}
	    } else {
		if (delay) {
		    if (time > 0) {
			// Trigger pulled, hopper off, delay timer not expired
			time -= clock.get();
		    } else {
			// Trigger pulled, hopper off, delay timer expired
			delay = false;
			time = 500000;
			hopperJag.set(1);
			running = true;
		    }
		} else {
		    // Trigger pulled, hopper off, delay off
		    hopperJag.set(1);
		    running = true;
		    time = 500000;
		}
	    }
	} else {
	    if (running) {
		if (time > 0) {
		    // Trigger released, hopper running, hopper timer not expired
		    time -= clock.get();
		} else {
		    // Trigger released, hopper running, hopper timer expired
		    hopperJag.set(0);
		    running = false;
		    time = 500000;
		    delay = true;
		}
	    }
	    if (delay) {    
		if (time > 0) {
		    // Trigger released, delay on, delay timer not expired
		    time -= clock.get();
		} else {
		    // Trigger released, delay on, delay timer expired
		    delay = false;
		    time = 500000;
		}
	    }
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
}
