package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.subsystems.Lift;

/**
 * Created by mwasylyk on 2/14/15.
 */
public class HomeLift extends Command {

    private static Lift liftInstance;
    private static OI oi;

    private static final double homeLiftSpeed = 0.35;

    @Override
    protected void initialize() {
        liftInstance = Lift.getInstance();
        oi = OI.getInstance();
        requires(liftInstance);
        setTimeout(10); // backop timeout
    }

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
}
