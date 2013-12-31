/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Sema
 */
 
public class PandaDock {
    Jaguar m_jagLeft, m_jagRight;
    Joystick m_joystick; 
    PandaDock(Jaguar jagLeft, Jaguar jagRight, Joystick joystick){
        m_jagLeft = jagLeft;
        m_jagRight = jagRight; 
        m_joystick = joystick;      
    }
  void step() {
     //if joystick button 1 is pressed 
      if(m_joystick.getRawButton(1)){
          //set speed equal to zero
          double speed = 0;
          //set motor speed equal to zero 
          m_jagLeft.set(0);
          //set maximum speed equal to 0.1 
          final double maxSpeed = 0.1;
          //When joystick button 2 is not pressed 
          while (!m_joystick.getRawButton(2)){
              //feed the watchdog 
              Watchdog.getInstance().feed();
              //delay for 0.01 sec
              Timer.delay(0.01);
              //if joystick speed is less than the maximum speed
               if(speed < maxSpeed){
                   //set speed greater than or equal to .001 
                  speed += .001; 
                  //set motors equal to speed 
                  m_jagLeft.set(speed);
                  m_jagRight.set(speed);
               }
          }
          //set  motors equal to -.01 (reversing the wheels) 
          m_jagLeft.set(-0.1); 
          m_jagRight.set(-0.1);
          //wait for 1 sec
          Timer.delay(1);
          //set motors equal to 0 
           m_jagLeft.set(0); 
           m_jagRight.set(0);
      }         
  }    
}
