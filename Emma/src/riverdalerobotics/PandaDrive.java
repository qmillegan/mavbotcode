/**
 * Panda Drive
 */
package riverdalerobotics;

/**
 *
 * @author FIRST
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
        double speed = joystick.getY();
        jagRight.set(speed);
        jagLeft.set(speed);
}
    
}
