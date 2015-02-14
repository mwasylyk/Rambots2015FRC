package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.Robot;
import org.usfirst.frc.team1350.robot.subsystems.Lift;

/**
 * Created by mwasylyk on 2/14/15.
 */
public abstract class AbstractLiftObject extends Command {

    private Lift liftInstance;
    private static OI oi;

    @Override
    protected void initialize() {
        liftInstance =  Robot.lift;
        oi = OI.getInstance();
        requires(liftInstance);
        setTimeout(getLiftTime());
    }

    @Override
    protected void execute() {
        if(!oi.isTopLimitHit()) {
            liftInstance.moveLiftUp(getLiftSpeed());
        } else {
            liftInstance.stopLift();
            cancel();
            setTimeout(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return Robot.oi.isTopLimitHit() || isTimedOut();
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

    abstract double getLiftTime();
    abstract double getLiftSpeed();
}
