package riverdale.robot;

import edu.wpi.first.wpilibj.*;

/*
 * @author Grant, Mr. Morris, Quinn
 */

public class PandaAltShoot {
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

    PandaAltShoot(Jaguar rotaryJag, Jaguar hopperJag, Jaguar camJag, Joystick joystick) {
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
	this.camJag = camJag;
	this.joystick = joystick;
	timer.start();
    }
    
    public void step() {
	camJag.set(joystick.getY());
	if (joystick.getTrigger()) {
	    // Turn the hopper
	    hopperJag.set(-0.9);
	    //may want to introduce a time delay here to prevent rapid fire frisbees
	} else {
	    hopperJag.set(0);
	}
	rotaryJag.set(1.0);
    }
    public void crioOut(String out) {
	lcd.println(DriverStationLCD.Line.kUser2, 1, out);
	lcd.updateLCD();
    }
}