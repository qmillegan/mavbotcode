/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.Timer;
import riverdale_emulator.EmmaGui;

/**
 * A simple robot base class that knows the standard FRC competition states (disabled, autonomous, or operator controlled).
 *
 * You can build a simple robot program off of this by overriding the
 * robotinit(), disabled(), autonomous() and operatorControl() methods. The startCompetition() method will calls these methods
 * (sometimes repeatedly).
 * depending on the state of the competition.
**/
public class SimpleRobot extends Thread
{
    // 
    public SimpleRobot()
    {
    }

    //. Called exactly 1 time when the competition starts.
    protected void robotInit() 
    {
    }

    // Called repeatedly while the robot is in the disabled state.
    protected void disabled() 
    {
    }

    // Called repeatedly while the robot is in the autonomous state.
    public void autonomous() 
    {
    }

    // Called repeatedly while the robot is in the operator-controlled state.
    public void operatorControl() 
    {
    }

    // Not implemented but included for completeness
    public void robotMain() 
    {
    }
    
    public boolean isAutonomous()
    {
        return EmmaGui.m_emmaGui.getAutonomous();
    }

        public boolean isOperatorControl()
    {
        return EmmaGui.m_emmaGui.getOperatorControl();
    }

    public boolean  isDisabled()
    {
        return EmmaGui.m_emmaGui.getDisabled();
    }

    /**
     * Start a competition.
     * This code tracks the order of the field starting to ensure that everything happens
     * in the right order. Repeatedly run the correct method, either Autonomous or OperatorControl
     * when the robot is enabled. After running the correct method, wait for some state to change,
     * either the other mode starts or the robot is disabled. Then go back and wait for the robot
     * to be enabled again.
     */
    public void startCompetition() 
    {
        robotMain();
        robotInit();
        Timer timer = new Timer();
        timer.start();
        int cnt = 0;
        int lastState = 0;
        while (true) 
        {
            Timer.delay(0.01);
            Double curTime = timer.get();
            if (isDisabled()) 
            {               
                EmmaGui.m_emmaGui.setFeedback(String.format( "Disabled %.1f", curTime/1000));
                disabled();
                lastState = 0;
            } 
            else if (isAutonomous()) 
            {
                EmmaGui.m_emmaGui.setFeedback(String.format( "Autonomous %.1f", curTime/1000));
                autonomous();
                lastState = 1;
            } 
            else 
            {
                EmmaGui.m_emmaGui.setFeedback(String.format( "Teleop %.1f", curTime/1000));
                if (lastState != 2)
                    getWatchdog().feed();
                operatorControl();
                lastState = 2;
           }
        } /* while loop */
    }
    
    Watchdog getWatchdog()
    {
        return Watchdog.getInstance();
    }
    
    @Override
    public void run()
    {
        startCompetition();
    }
}
