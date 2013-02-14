/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package riverdale.robot;

import edu.wpi.first.wpilibj.*;

public class PandaBot extends SimpleRobot
{
    
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
    
    protected void robotInit() 
    {
        m_driveJoystick = new Joystick(1);
        m_shootJoystick = new Joystick(2);
	
        m_leftFrontMotor = new Jaguar(2);
        m_rightFrontMotor = new Jaguar(6);

	m_liftLeftJag = new Jaguar(5);
	m_liftRightJag = new Jaguar(7);
	
	m_shootRotary = new Jaguar(8);
	m_shootHopper = new Jaguar(9);
	m_camJag = new Jaguar(4);
	
        pandaDrive = new PandaDrive(m_leftFrontMotor, m_rightFrontMotor, m_driveJoystick);
	pandaLift = new PandaLift(m_liftLeftJag, m_liftRightJag, m_driveJoystick);
	pandaShoot = new PandaShoot(m_shootRotary, m_shootHopper, m_camJag, m_shootJoystick);
    }
    
    public void autonomous() 
    {
        
    }

    public void operatorControl() 
    {
        while(isOperatorControl())
        {
            getWatchdog().feed();
            Timer.delay(.01);
            //give the drive train a turn
            pandaDrive.drive();
            //give the lifter a turn
	   // pandaLift.step();
            //give the shooter a turn
	    pandaShoot.step();
        }
    }
}
