package org.usfirst.frc.team1350.robot.commands;

/**
 *
 */
public class ResetLiftHome extends AbstractLiftObject {
	
	private static final double liftTime = 1.5;
	private static final double liftSpeed = -.5;

	//Singleton
	private static ResetLiftHome instance;
	public static ResetLiftHome getInstance(){
		if (instance == null){
			instance = new ResetLiftHome();
		}
		return instance;
	}
	
    public ResetLiftHome() {
    	super();
    }

	@Override
	void commandToRun() {
			liftInstance.lowerLift(liftSpeed);
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
		return oi.isBottomLimitHit();
	}

	@Override
	boolean isEncLimitReached() {
		if(isLimitHit()){
			liftInstance.resetEncoder();
		}
		return isLimitHit();
	}
}
