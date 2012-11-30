package riverdalerobotics;

public class MavBot extends SimpleRobot
{
    
    Joystick m_leftJoystick;
    Joystick m_rightJoystick;
    Jaguar m_leftFrontMotor;
    Jaguar m_rightFrontMotor;
    Jaguar m_leftRearMotor;
    Jaguar m_rightRearMotor;
    
    @Override
    protected void robotInit() 
    {
        m_leftJoystick = new Joystick(1);
        m_rightJoystick = new Joystick(2);
        m_leftFrontMotor = new Jaguar(1);
        m_rightFrontMotor = new Jaguar(2);
        m_leftRearMotor = new Jaguar(3);
        m_rightRearMotor = new Jaguar(4);        
    }
    
    @Override
    public void autonomous() 
    {
        
    }

    @Override
    public void operatorControl() 
    {
        double leftSpeed = m_leftJoystick.getY();
        double rightSpeed = m_rightJoystick.getY();
        m_leftFrontMotor.set(leftSpeed);
        m_leftRearMotor.set(leftSpeed);
        m_rightFrontMotor.set(rightSpeed);
        m_rightRearMotor.set(rightSpeed);
    }
}
