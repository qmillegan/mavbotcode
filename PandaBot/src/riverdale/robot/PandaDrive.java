/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdale.robot;

import edu.wpi.first.wpilibj.*;

/**
 *
 * @author FIRST
 */
public class PandaDrive {

    private RobotDrive train;
    private Joystick joystick;
    
    public PandaDrive(RobotDrive train, Joystick joystick){
        this.train = train;
        this.joystick = joystick;
    }
    
    void step(){  //formerly arcadeDrive()
	//needs to be continually run as check - TODO make run in seperate thread???
        train.arcadeDrive(joystick.getY(), -joystick.getX()); //This is (hopefully) right
    }
}