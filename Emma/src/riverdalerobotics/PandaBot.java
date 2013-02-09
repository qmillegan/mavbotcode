package riverdalerobotics;

public class PandaBot extends SimpleRobot
{
    
    Joystick m_driveJoystick; //joystick 1...primarily used for driving
    Joystick m_shootJoystick; //joystick 2...used for shooting
    Jaguar m_leftFrontMotor;
    Jaguar m_rightFrontMotor;
    Jaguar m_leftRearMotor;
    Jaguar m_rightRearMotor;
    Jaguar m_liftLeftJag, m_liftRightJag, m_shootRotary, m_shootHopper;
    PandaLift pandaLift;
    PandaDrive pandaDrive;
    PandaShoot pandaShoot;
    
    @Override
    protected void robotInit() 
    {
        m_driveJoystick = new Joystick(1);
        m_shootJoystick = new Joystick(2);
        m_leftFrontMotor = new Jaguar(1);
        m_rightFrontMotor = new Jaguar(2);
       
	m_liftLeftJag = new Jaguar(5);
	m_liftRightJag = new Jaguar(6);
	
	m_shootRotary = new Jaguar(7);
	m_shootHopper = new Jaguar(8);
        pandaDrive = new PandaDrive(m_leftFrontMotor, m_rightFrontMotor, m_driveJoystick);
	pandaLift = new PandaLift(m_liftLeftJag, m_liftRightJag, m_driveJoystick);
	pandaShoot = new PandaShoot(m_shootRotary, m_shootHopper, m_shootJoystick);
    }
    
    @Override
    public void autonomous() 
    {
        
    }

    @Override
    public void operatorControl() 
    {
        while(isOperatorControl())
        {       
            getWatchdog().feed();
            Timer.delay(.01);
            //give the drive train a turn
            pandaDrive.drive();
            //give the lifter a turn
	    pandaLift.step();
            //give the shooter a turn
	    pandaShoot.step(); 
        }
    }
}
