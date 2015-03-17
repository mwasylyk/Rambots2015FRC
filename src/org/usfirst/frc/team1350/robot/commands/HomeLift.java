package org.usfirst.frc.team1350.robot.commands;

/**
 * Created by mwasylyk on 2/14/15.
 */
public class HomeLift extends AbstractLiftObject {

    private static final double homeLiftSpeed = 0.75;
    private static final double homeTime = 2;

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
		// TODO Auto-generated method stub
		return homeTime;
	}

	@Override
	double getLiftSpeed() {
		// TODO Auto-generated method stub
		return homeLiftSpeed;
	}

	@Override
	boolean isLimitHit() {
		// TODO Auto-generated method stub
		return oi.isBottomLimitHit();
	}
	
	@Override
	void commandToRun() {
		// TODO Auto-generated method stub
		liftInstance.lowerLift(homeLiftSpeed);
	}
}
