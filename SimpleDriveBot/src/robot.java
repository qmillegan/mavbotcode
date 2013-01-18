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
public class robot extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    private RobotDrive dri;
    private Joystick joystik;
    private Jaguar jag_back_left;
    private Jaguar jag_back_right;
    private Jaguar jag_front_left;
    private Jaguar jag_front_right;
    
    private DriverStationLCD lcd;
    
            
    public void autonomous() {
        dri = new RobotDrive(2,1,3,8);
        dri.setMaxOutput(2);
        while (true)
           {
               //woogie boogie donut
               dri.drive(1.0,0.5);
               
               getWatchdog().feed();
               Timer.delay(.009);
                  
           }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        //jag_back_left = new Jaguar(8);
        //jag_back_right = new Jaguar(1);
        //jag_front_left = new Jaguar(3);
        //jag_front_right = new Jaguar(2);
        lcd = DriverStationLCD.getInstance();
        dri = new RobotDrive(2,1,3,8);
        dri.setMaxOutput(2);
        joystik = new Joystick(1);
        //double speed = 0;
        lcd.println(DriverStationLCD.Line.kUser2, 1, "It's running!");
        lcd.updateLCD();
        while (true)
           {
               dri.arcadeDrive(joystik.getY(),-joystik.getX());
               //speed = joystik.getY();
               String speed_text = joystik.getY() + "";
               lcd.println(DriverStationLCD.Line.kUser2, 1, speed_text);
               lcd.updateLCD();
               //jag_back_left.set(speed);
               //jag_back_right.set(speed);
               //jag_front_left.set(speed);
               //jag_front_right.set(speed);
               
               getWatchdog().feed();
               Timer.delay(.009);
                  
           }
    }
}
