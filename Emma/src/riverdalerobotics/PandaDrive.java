/**
 * Panda Drive
 */
package riverdalerobotics;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Jaguar;

/**
 * reer
 * 
 */
public class PandaDrive 
{
    private Joystick joystick;
    private Jaguar jagLeft, jagRight;
    private Timer timer;
    double lastTime = 0;
    double lastSpeed = 0;
    double reportAccel = 0;
    double accel = 0;
    PandaDrive drive;
    double c_state;
    double p_state;
    double speed;
    int sc;
    
    
    public PandaDrive(Jaguar jagLeft, Jaguar jagRight, Joystick joystick)
    {
        this.joystick = joystick;
        this.jagLeft = jagLeft;
        this.jagRight = jagRight;
        timer = new Timer();
        timer.start();
	
    }
    public void drive()
    {
       double x = joystick.getX();
       double y = joystick.getY();
	arcadeDrive(y, x);

}
    

    public void arcadeDrive(double moveValue, double rotateValue) 
    {
        boolean squaredInputs = true;
        // local variables to hold the computed PWM values for the motors
        double leftMotorSpeed;
        double rightMotorSpeed;

        //moveValue = limit(moveValue);
        //rotateValue = limit(rotateValue);

        if (squaredInputs) 
        {
            // square the inputs (while preserving the sign) to increase fine control while permitting full power
            if (moveValue >= 0.0)
            {
                moveValue = (moveValue * moveValue);
            } 
            else 
            {
                moveValue = -(moveValue * moveValue);
            }
            if (rotateValue >= 0.0)
            {
                rotateValue = (rotateValue * rotateValue);
            } 
            else 
            {
                rotateValue = -(rotateValue * rotateValue);
            }
        }

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) 
            {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } 
            else 
            {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        }
        else 
        {
            if (rotateValue > 0.0) 
            {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } 
            else 
            {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }

        //setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
        jagRight.set(rightMotorSpeed);
        jagLeft.set(leftMotorSpeed);
   }
}
