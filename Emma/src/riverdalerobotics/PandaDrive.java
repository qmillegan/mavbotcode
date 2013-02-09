/**
 * Panda Drive
 */
package riverdalerobotics;

/**
 *
 * 
 */
public class PandaDrive {

    private Joystick joystick;
    private Jaguar jagLeft, jagRight;
    private Timer timer;
    double lastTime = 0;
    double lastSpeed = 0;
 
    public PandaDrive(Jaguar jagLeft, Jaguar jagRight, Joystick joystick){
        this.joystick = joystick;
        this.jagLeft = jagLeft;
        this.jagRight = jagRight;
        timer = new Timer();
        timer.start();
    }
    public void drive(){
        final double maxAccel = 2.5;
        double speed = joystick.getY(); 
        double time = timer.get();
        double timeDif = time-lastTime;
        double speedDif = speed-lastSpeed;
        double accel = speedDif/timeDif;
        lastTime = time;
        lastSpeed = speed;
        if(Math.abs(accel) > maxAccel){
            double newSpeed = maxAccel*timeDif;
            speed = newSpeed;
        } 
        //jagRight.set(speed);
        //jagLeft.set(speed);
        arcadeDrive(speed, joystick.getX());
}
    

    public void arcadeDrive(double moveValue, double rotateValue) {
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
         jagRight.set(rightMotorSpeed);
        jagLeft.set(leftMotorSpeed);
   }
}
