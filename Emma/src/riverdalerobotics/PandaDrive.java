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
 
    public PandaDrive(Jaguar jagLeft, Jaguar jagRight, Joystick joystick){
        this.joystick = joystick;
        this.jagLeft = jagLeft;
        this.jagRight = jagRight;
    }
    public void drive(){
        final double maxAccel = 5;
        double speed = joystick.getY(); 
        double time = timer;
        double lastSpeed = speed;
        double lastTime = time;
        double timeDif = time-lastTime;
        double speedDif = speed-lastSpeed;
        double accel = speedDif/timeDif;
        if(Math.abs(accel) > maxAccel){
            double newSpeed = maxAccel*timeDif;
            speed = newSpeed;
        } 
        jagRight.set(speed);
        jagLeft.set(speed);
}
    
}
