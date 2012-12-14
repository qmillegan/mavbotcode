/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class JoystickBot extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    private RobotDrive drivetrain;
    private Joystick joystik;
    private Jaguar jag;
    private DriverStationLCD lcd;
    
            
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        jag = new Jaguar(8);
        lcd = DriverStationLCD.getInstance();
        //drivetrain = new RobotDrive(9,10);
        joystik = new Joystick(1);
        double speed = 1.0;
        
        lcd.println(DriverStationLCD.Line.kUser2, 1, "Test Message");
        lcd.updateLCD();
        while (true)
           {
               //drivetrain.arcadeDrive(joystik);
               speed = joystik.getY();
               jag.set(speed);
               //int i;
               //for (i=0; i<100; i++)
               //{
                  getWatchdog().feed();
                  Timer.delay(.009);
                  
               //}
               //speed = 1-speed;
           }
    }
}
