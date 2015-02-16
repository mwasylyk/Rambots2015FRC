package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.subsystems.Lift;

/**
 * Created by mwasylyk on 2/14/15.
 */
public class HomeLift extends AbstractLiftObject {

    private static Lift liftInstance;
    private static OI oi;

    private static final double homeLiftSpeed = 0.35;
    private static final double homeTime = 5;


    @Override
    protected void execute() {
        liftInstance.lowerLift(homeLiftSpeed);
    }

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
