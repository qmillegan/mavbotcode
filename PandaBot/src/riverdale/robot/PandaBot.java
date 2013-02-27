/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package riverdale.robot;

import edu.wpi.first.wpilibj.*;

public class PandaBot extends SimpleRobot {
    Joystick m_driveJoystick; //joystick 1...primarily used for driving
    Joystick m_shootJoystick; //joystick 2...used for shooting
    Jaguar m_leftFrontMotor;
    Jaguar m_rightFrontMotor;
    Jaguar m_leftRearMotor;
    Jaguar m_rightRearMotor;
    Jaguar m_liftLeftJag, m_liftRightJag, m_shootRotary, m_shootHopper, m_camJag;
    PandaLift pandaLift;
    PandaDrive pandaDrive;
    PandaShoot pandaShoot;
    PandaAltShoot pandaAltShoot;
    //DriverStationLCD lcd;
    
    /*Jaguar one;
     * Jaguar two;
     * Jaguar three;
     * Jaguar four;
     * Jaguar five;
     * Jaguar six;
     * Jaguar seven;
     * Jaguar eight;
     * Jaguar nine;
     * Jaguar ten;*/
    
    protected void robotInit() {
	/*one = new Jaguar(1);
	 * two = new Jaguar(2);
	 * three = new Jaguar(3);
	 * four = new Jaguar(4);
	 * five = new Jaguar(5);
	 * six = new Jaguar(6);
	 * seven = new Jaguar(7);
	 * eight = new Jaguar(8);
	 * nine = new Jaguar(9);
	 * ten = new Jaguar(10);*/
        m_driveJoystick = new Joystick(1);
        m_shootJoystick = new Joystick(2);
	
        m_leftFrontMotor = new Jaguar(1);
        m_rightFrontMotor = new Jaguar(6);

	//m_liftLeftJag = new Jaguar(9);
	//m_liftRightJag = new Jaguar(10);
	
	m_shootRotary = new Jaguar(7);
	m_shootHopper = new Jaguar(2);
	m_camJag = new Jaguar(8);
	
        pandaDrive = new PandaDrive(m_leftFrontMotor, m_rightFrontMotor, m_driveJoystick);
	//pandaLift = new PandaLift(m_liftLeftJag, m_liftRightJag, m_driveJoystick);
	pandaShoot = new PandaShoot(m_shootRotary, m_shootHopper, m_camJag, m_shootJoystick);
	pandaAltShoot = new PandaAltShoot(m_shootRotary, m_shootHopper, m_camJag, m_shootJoystick);
    }

    public void autonomous() {
    }

    public void operatorControl() {
	//int num = 0;
	//testDigitalSidecar(0.5);
        while(isOperatorControl())
        {
	    //num++;
            getWatchdog().feed();
	    //lcd = DriverStationLCD.getInstance();
	    //lcd.println(DriverStationLCD.Line.kUser2, 1, "" + num);
	    //lcd.updateLCD();

            //give the drive train a turn
	    pandaDrive.drive();
            //give the lifter a turn
	    //pandaLift.step();
            //give the shooter a turn
	    pandaShoot.step();
	    //turn twist for alternative shooting control
	    if (m_shootJoystick.getTwist() <= 0) {
		pandaAltShoot.step();
	    } else {
		pandaShoot.step();
	    }
	    // Take a short rest
	    Timer.delay(0.01);
        }
    }

    /*public void testDigitalSidecar(double speed) {
     * one.set(speed);
     * two.set(speed);
     * three.set(speed);
     * four.set(speed);
     * five.set(speed);
     * six.set(speed);
     * seven.set(speed);
     * eight.set(speed);
     * nine.set(speed);
     * ten.set(speed);
     * }*/
}
