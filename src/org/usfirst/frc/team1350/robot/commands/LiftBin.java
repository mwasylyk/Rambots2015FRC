package org.usfirst.frc.team1350.robot.commands;

/**
 * Created by mwasylyk on 2/14/15.
 */
public class LiftBin extends AbstractLiftObject {

    private static final double liftTime = 1.5;
    private static final double liftSpeed = 1;
    
    private static final int ENCODER_LIMIT = 10;
    
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
		return oi.isTopLimitHit();
	}

	@Override
	void commandToRun() {
		liftInstance.moveLiftUp(liftSpeed);
	}

	@Override
	boolean isEncLimitReached() {
		return liftInstance.getEncoderCount() >= ENCODER_LIMIT;
	}

	
	
	
}
