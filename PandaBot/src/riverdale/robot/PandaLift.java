package riverdale.robot;

import edu.wpi.first.wpilibj.*;

/**
 *
 * @author FIRST
 */
public class PandaLift {
    private Jaguar jagLiftLeft;
    private Jaguar jagLiftRight;
    private Joystick joystick;
    private DriverStationLCD lcd = DriverStationLCD.getInstance();

    //private DigitalInput upSwitch; //limit switch top
    //private DigitalInput downSwitch; //limit switch bottom
    
    PandaLift(Jaguar jagLiftLeft, Jaguar jagLiftRight, Joystick joystick){
        this.jagLiftLeft = jagLiftLeft;
	this.jagLiftRight = jagLiftRight;
	this.joystick = joystick;
        //upSwitch = new DigitalInput(upSwitchPort);
        //downSwitch = new DigitalInput(downSwitchPort);
    }
    
    public void step() {
	if (joystick.getRawButton(3)) {
	    jagLiftLeft.set(1);
	    jagLiftRight.set(1);
	    crioOut("firing 1");
	} else if (joystick.getRawButton(2)) {
	    jagLiftLeft.set(-1);
	    jagLiftRight.set(-1);
	    crioOut("firing -1");
	} else {
	    jagLiftLeft.set(0);
	    jagLiftRight.set(0);
	}
    }
    public void crioOut(String out) {
	lcd.println(DriverStationLCD.Line.kUser2, 1, out);
	lcd.updateLCD();
    }

}
