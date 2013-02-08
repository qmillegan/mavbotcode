package riverdalerobotics;

public class PandaBot extends SimpleRobot
{
    
    Joystick m_leftJoystick;
    Joystick m_rightJoystick;
    Jaguar m_leftFrontMotor;
    Jaguar m_rightFrontMotor;
    Jaguar m_leftRearMotor;
    Jaguar m_rightRearMotor;
    PandaDrive pandaDrive;
    
    @Override
    protected void robotInit() 
    {
        m_leftJoystick = new Joystick(1);
        m_rightJoystick = new Joystick(2);
        m_leftFrontMotor = new Jaguar(1);
        m_rightFrontMotor = new Jaguar(2);
        m_leftRearMotor = new Jaguar(3);
        m_rightRearMotor = new Jaguar(4);   
        pandaDrive = new PandaDrive(m_leftFrontMotor, m_rightFrontMotor, m_leftJoystick);
    }
    
    @Override
    public void autonomous() 
    {
        
    }

    @Override
    public void operatorControl() 
    {
        while(true){
            //give the drive train a turn
            pandaDrive.drive();
            //give the lifter a turn
            //give the shooter a turn
       
            
        }
    }
}
