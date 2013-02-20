package riverdale.robot;

import edu.wpi.first.wpilibj.*;

/*
 * @author Quinn
 */
public class PandaAuto {
    
    private PandaDrive train;
    private PandaShoot shooter;
    private PandaLift lifter;
    private Jaguar rotaryJag;
    private Jaguar hopperJag;
    private Timer timer = new Timer();
    double sEndTime = 0;
    double sEndTime2= 0;
    double num=0;
    double delayTime=0.3;
    
    PandaAuto(PandaDrive train, PandaShoot shooter, PandaLift lifter,Jaguar rotaryJag, Jaguar hopperJag){
	this.train = train;
	this.shooter = shooter;
	this.lifter = lifter;
        this.rotaryJag = rotaryJag;
	this.hopperJag = hopperJag;
    }
    public void step(){
	//do autonomous stuff 
        sEndTime = timer.get() + 0.6;
        //starting rotary jag
        rotaryJag.set(1);
        if(timer.get() > sEndTime){
            //starting hopper after sEndTime has passed
            sEndTime = timer.get() + delayTime;
            shooter.shoot();
            if(timer.get() > sEndTime){
                sEndTime = timer.get() + delayTime;
                shooter.shoot();
                    if(timer.get() > sEndTime){
                        sEndTime = timer.get() + delayTime;
                        shooter.shoot();
                            if(timer.get() > sEndTime){
                                sEndTime = timer.get() + delayTime;
                                shooter.shoot();
                                rotaryJag.set(0);
            }
            }
            }
    }
}}