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
    
    public void step() 
    {
	camJag.set(joystick.getY());
	trigger = joystick.getTrigger();
	if (trigger) 
        {
            rotaryJag.set(1.0);
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
	} 
        else 
        {
            rotaryJag.set(0.0);
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
    }
}
