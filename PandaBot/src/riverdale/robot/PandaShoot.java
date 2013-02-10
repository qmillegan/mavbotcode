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
    private Joystick joystick;
    private double timeStarted = 0;
    // timeStarted tracks when the current shoot sequence started
    private double spinDownTime = 1000000;
    // spinDownTime tracks how long until the shooter motor needs to stop
    private boolean running = true;
    Timer clock = new Timer();

    PandaShoot(Jaguar rotaryJag, Jaguar hopperJag, Joystick joystick) {
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
	this.joystick = joystick;
	clock.start();
    }
    
    public void step() {
	if (joystick.getTrigger() && !running) {
	    // Start the shooting sequence
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
		spinDownTime = 1000000;
		rotaryJag.set(0);
	    }
	}
    }
}
