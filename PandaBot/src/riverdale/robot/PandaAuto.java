package riverdale.robot;

/*
 * @author Quinn
 */
public class PandaAuto {
    
    private PandaDrive train;
    private PandaShoot shooter;
    private PandaLift lifter;
    
    PandaAuto(PandaDrive train, PandaShoot shooter, PandaLift lifter){
	this.train = train;
	this.shooter = shooter;
	this.lifter = lifter;
    }
    public void step(){
	//do autonomous stuff 
	//QUINN's
        double num = 0;
        while (num != 4) {
            shooter.step();
	    //adding 1 to the number,until it fires four frisbees
            num = num + 1;
    }
}}