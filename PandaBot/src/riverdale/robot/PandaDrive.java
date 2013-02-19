package riverdale.robot;

import edu.wpi.first.wpilibj.*;
import java.lang.Math;

/**
 * reer
 * 
 */
public class PandaDrive {
    
    private Joystick joystick;
    private Jaguar jagLeft, jagRight;
    private Timer timer;
    double lastTime = 0;
    double lastSpeed = 0;
    double reportAccel = 0;
    double accel = 0;
    RobotDrive drive;
    double c_state;
    double p_state;
    double yVal;
    int sc;
    
    
    public PandaDrive(Jaguar jagLeft, Jaguar jagRight, Joystick joystick){
        this.joystick = joystick;
        this.jagLeft = jagLeft;
        this.jagRight = jagRight;
        timer = new Timer();
        timer.start();
	
	//logan's crutch
	drive = new RobotDrive(jagLeft, jagRight);
	drive.setSafetyEnabled(false);
	
	//quinnard's stuff
	c_state =  0.0;
	p_state = 0.0;
	yVal = 0.0;
	//slowing coefficient..higher is slower
	sc = 50;
    }
    public void drive()
    {
	//crioOut("Drive!");
        
        //double yVal = joystick.getY();
	/*
	final double maxAccel = 0.06;
        double time = timer.get();
        //acceleration calculation, etc.
        double timeDif = time-lastTime;
        double speedDif = yVal-lastSpeed;
        accel = speedDif/timeDif;
        if(timeDif == 0 && speedDif == 0)
            accel = 0;
        if(Math.abs(accel) > reportAccel){
            reportAccel = Math.abs(accel);
        }
        //checking to see if the acceleration is too high
        double oldLastSpeed = lastSpeed;
        lastTime = time;
        lastSpeed = yVal;
        if(Math.abs(accel) > maxAccel){
            double newTimeDif = maxAccel*timeDif;
            double newSpeed = newTimeDif+oldLastSpeed;
            yVal = newSpeed;
        } 
        //jagRight.set(yVal);
        //jagLeft.set(yVal);
	 
        arcadeDrive(yVal, joystick.getX());
	*/
	
	//quinnard's controlled acceleration thing
	c_state =  joystick.getY();
	//p_state = robot yVal...let it approach c_state at a certain increment
	p_state = p_state+((c_state-p_state)/sc);
	yVal = p_state;
	//crioOut(yVal+"");
	
	//get yVal from joystick rotary controller thing
	//drive.setMaxOutput(1-((joystick.getTwist()+1)/2));
	//check if it's turbo time
	//if (joystick.getTrigger() == true) 
	//{
	//    //fire lazors
	//    drive.setMaxOutput(5);
	//}
	
	
	//logan's crutch...might want to use the (glorious) arcadeDrive function instead
	//double xVal = -joystick.getX();
	//yVal *= 0.5;
	//xVal *= 0.5;
	//crioOut("XY " + xVal + " : " + yVal);
	drive.arcadeDrive(-joystick.getX(), yVal);
}

    public void arcadeDrive(double moveValue, double rotateValue) 
    {
        boolean squaredInputs = true;
        // local variables to hold the computed PWM values for the motors
        double leftMotorSpeed;
        double rightMotorSpeed;

        //moveValue = limit(moveValue);
        //rotateValue = limit(rotateValue);

        if (squaredInputs) {
            // square the inputs (while preserving the sign) to increase fine control while permitting full power
            if (moveValue >= 0.0) {
                moveValue = (moveValue * moveValue);
            } else {
                moveValue = -(moveValue * moveValue);
            }
            if (rotateValue >= 0.0) {
                rotateValue = (rotateValue * rotateValue);
            } else {
                rotateValue = -(rotateValue * rotateValue);
            }
        }

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }

        //setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
	double getY = joystick.getY();
	double getX = joystick.getX();
	//JOYSTICK DEADZONE IF/ELSE STATEMENT -----------------------------------//---------------------------------// //
	if (getY < 0.005 && getX < 0.005) {
	    jagRight.set(0);
	    jagLeft.set(0);
	} else {
	    jagRight.set(rightMotorSpeed);
	    jagLeft.set(leftMotorSpeed);
	}
    }
    public void crioOut(String out) {
	DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 2, out);
	DriverStationLCD.getInstance().updateLCD();
    }
    public void grantDrive(double joystickX, double joystickY) {
	// A highly experimental (and top-secret!) re-implementation of arcadeDrive
	boolean squareIt = true;
	if (squareIt) {
	joystickX = (joystickX * joystickX * joystickX) / Math.abs(joystickX);
	joystickY = (joystickY * joystickY * joystickY) / Math.abs(joystickY);
	}
	jagLeft.set(joystickY - joystickX);
	jagLeft.set(joystickY + joystickX);
    }
}
