package org.usfirst.frc.team1350.robot.commands;

/**
 * Created by mwasylyk on 2/14/15.
 */
public class HomeLift extends AbstractLiftObject {

    private static final double homeLiftSpeed = 0.75;
    private static final double homeTime = 2;
    
    private static final int ENCODER_LIMIT = 2;

    @Override
    protected boolean isFinished() {
        return oi.isBottomLimitHit() || isTimedOut();
    }

    @Override
    protected void end() {
        liftInstance.stopLift();
    }

    @Override
    protected void interrupted() {

    }

	@Override
	double getLiftTime() {
		return homeTime;
	}

	@Override
	double getLiftSpeed() {
		return homeLiftSpeed;
	}

	@Override
	boolean isLimitHit() {
		return oi.isBottomLimitHit();
	}
	
	@Override
	void commandToRun() {
		liftInstance.lowerLift(homeLiftSpeed);
	}

	@Override
	boolean isEncLimitReached() {
		return liftInstance.getEncoderCount() <= ENCODER_LIMIT;
	}
}
