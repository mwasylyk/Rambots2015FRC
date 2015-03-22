package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.subsystems.Lift;

/**
 * Created by mwasylyk on 2/14/15.
 */
public abstract class AbstractLiftObject extends Command {
	
    protected Lift liftInstance;
    protected static OI oi;
    
    public AbstractLiftObject(){
        liftInstance = Lift.getInstance();     
        oi = OI.getInstance();
        requires(liftInstance);
    }

    @Override
    protected void initialize() {
        setTimeout(getLiftTime());
    }

    @Override
    protected void execute() {
        if(isLimitHit()) {
        	liftInstance.stopLift();
            cancel();
            setTimeout(0);
        } else {
        	commandToRun();
        }
    }
    
    @Override
    protected boolean isFinished() {
        return isLimitHit() || isTimedOut();
    }

    @Override
    protected void end() {
        liftInstance.stopLift();
    }

    @Override
    public synchronized boolean isInterruptible () {
        return false;
    }

    @Override
    protected void interrupted() {

    }

    abstract void commandToRun();
    abstract double getLiftTime();
    abstract double getLiftSpeed();
    abstract boolean isLimitHit();
}
