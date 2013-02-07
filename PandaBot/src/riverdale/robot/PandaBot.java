/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package riverdale.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class PandaBot extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    //private RobotDrive drivetrain;
    //private Joystick joystik;
    private DriverStationLCD lcd;
    private Jaguar jagLeft, jagRight, jagLiftLeft, jagLiftRight, jagShoot;
    
    private RobotDrive train;
    private PandaDrive pandaDrive;
    private PandaLift pandaLift;
    private PandaShoot pandaShoot;
    private PandaAuto pandaAuto;
    private Joystick joystick;
    private Joystick joystick2;
    
    private int upSwitchPort = 1; //fix numbers, for limit switches
    private int downSwitchPort = 2;
    
    public void robotInit(){
        jagLeft = new Jaguar(8);
        jagRight = new Jaguar(2); //initalize others...
	
        train = new RobotDrive(jagLeft, jagRight);
	joystick = new Joystick(1);
	joystick2 = new Joystick(2);
	int joyPort = 1;
	int joy2Port = 2;
	
	//pandaDrive = new PandaDrive(train, joystick);
	//pandaLift = new PandaLift(jagLiftLeft, jagLiftRight, upSwitchPort, downSwitchPort, joy2Port);
	//pandaShoot = new PandaShoot(jagShoot, joy2Port);
	
	//pandaAuto = new PandaAuto(pandaDrive, pandaShoot, pandaLift);
        
        lcd = DriverStationLCD.getInstance();
        
        String time = "WatchTime: " + getWatchdog().getExpiration();
        lcd.println(DriverStationLCD.Line.kUser2, 1, time);
        lcd.updateLCD();
    }
    
    public void autonomous() {
        jagLeft.set(.9);
        jagRight.set(.9);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        runFromArcade();
    }
    
    public void runFromArcade(){
	while(true){
	    getWatchdog().feed();
            train.arcadeDrive(joystick.getY(), -joystick.getX()); //will be replaced by PandaDrive.arcadeDrive();
	
            //String message = "Joystick: " + joystick.getX();
            //lcd.println(DriverStationLCD.Line.kUser2, 1, message);
            //lcd.updateLCD();
        }
    }
    
    public void motorTest(){
        lcd = DriverStationLCD.getInstance();
        //drivetrain = new RobotDrive(9,10);
        //joystik = new Joystick(1);
        double speed = 0.25;
        long i = 0;
        //double actualSpeed;
        
        //lcd.println(DriverStationLCD.Line.kUser2, 1, "Test Message");
        //lcd.updateLCD();
        jagLeft.set(speed);
        jagRight.set(speed);
        while (true)
           {
               i++;
               //drivetrain.arcadeDrive(joystik);
               //speed = joystik.getY();
               //jagLeft.set(speed);
               //jagRight.set(speed);
               //actualSpeed = jagLeft.get();

               //int i;
               //for (i=0; i<100; i++)
               //{
                  getWatchdog().feed();
                  Timer.delay(.009);
                  //lcd.clear();
                  //String msg = "speed: " + actualSpeed;
                  //lcd.println(DriverStationLCD.Line.kUser2, 1, msg);
                  //lcd.updateLCD();
                  
               //}
               //speed = 1-speed;
               
           }
    }
}