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
    private DriverStationLCD lcd = DriverStationLCD.getInstance();
    private Timer timer = new Timer();
    
    /*
    private double delay = 1000000;
    private double timeStarted = 0;
    // timeStarted tracks when the current shoot sequence started
    private double spinDownTime = 1;
    // spinDownTime tracks how long until the shooter motor needs to stop
    private boolean running = true;
    private boolean running = false;
    private boolean delay = false;
    private boolean trigger = false;
    private double time = 750000;
    private double lastTime = timer.get();
    private double timeLeft = 750000;
    */
    final int offState = 0;
    final int spinningState = 1;
    final int shootingState = 2;
    final int delayState = 3;
    int m_state = offState;
    double m_endTime = 0;

    PandaShoot(Jaguar rotaryJag, Jaguar hopperJag, Jaguar camJag, Joystick joystick) {
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
	this.camJag = camJag;
	this.joystick = joystick;
	timer.start();
    }
    
    public void step() {
	camJag.set(joystick.getY());
	switch (m_state)
	{
	    case offState:
		rotaryJag.set(0);
		if (joystick.getRawButton(10) && !joystick.getRawButton(11)) {
		    hopperJag.set(0.25);
		} else if (!joystick.getRawButton(10) && joystick.getRawButton(11)) {
		    hopperJag.set(-0.25);
		} else {
		    hopperJag.set(0);
		}
		if (joystick.getTrigger())
		{
		    m_state = spinningState;
		    m_endTime = timer.get() + 0.2;
		    rotaryJag.set(1);
		}
		break;
	    case spinningState:
		if (timer.get() > m_endTime)
		{
		    m_state = shootingState;
		    m_endTime = timer.get() + 0.71;
		    hopperJag.set(1);
		}
		break;
	    case shootingState:
		crioOut("Time left: " + (timer.get() - m_endTime));
		if (timer.get() > m_endTime)
		{
		    if (joystick.getTrigger()) {
			m_endTime = timer.get() + 0.71;
		    } else {
			m_state = delayState;
			m_endTime = timer.get() + 0.2;
			hopperJag.set(0);
		    }
		}
		break;
	    case delayState:
		if (timer.get() > m_endTime)
		{
		    m_state = offState;
		}
		break;
	}
    }
    public void crioOut(String out) {
	lcd.println(DriverStationLCD.Line.kUser2, 1, out);
	lcd.updateLCD();
    }
    
    public void deadCode() {
		/*
	if (joystick.getTrigger()) {
	    // Turn the hopper
	    hopperJag.set(-0.9);
	    //may want to introduce a time delay here to prevent rapid fire frisbees
	} else {
	    hopperJag.set(0);
	}
	// // //
	if (joystick.getTrigger()) {
	    hopperJag.set(1.0);
	} else {
	    hopperJag.set(0);
	}
	
	if (joystick.getTwist() <= 0) {
	    rotaryJag.set(1.0);
	    //may want to introduce a time delay here to prevent rapid fire frisbees
	} else {
	    rotaryJag.set(0);
	}
	*/
    }
}