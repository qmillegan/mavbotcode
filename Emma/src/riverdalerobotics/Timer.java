/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

/**
 *
 * @author Matt Morrise
 * Meaningless Change
 */
public class Timer
{
    static void delay(double time)
    {
         try
         {
            Thread.sleep((int) (time * 1000));
         }
         catch (Exception e)
         {
         }
    }
}