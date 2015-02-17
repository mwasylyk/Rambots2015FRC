package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.OI;

/**
 * Created by mwasylyk on 2/14/15.
 */
public class LiftBin extends AbstractLiftObject {

    private static final double liftTime = 1;
    private static final double liftSpeed = .7;
    
    private static LiftBin instance;
    public static LiftBin getInstance(){
   	 if(instance == null) {
   		 instance = new LiftBin();
   	 }
   	 return instance;
    }
    
    public LiftBin(){
    	super();
    }

    @Override
    double getLiftTime() {
        return liftTime;
    }

    @Override
    double getLiftSpeed() {
        return liftSpeed;
    }

	@Override
	boolean isLimitHit() {
		// TODO Auto-generated method stub
		return oi.isTopLimitHit();
	}

	@Override
	void commandToRun() {
		// TODO Auto-generated method stub
		liftInstance.moveLiftUp(liftSpeed);
	}

	
	
	
}
