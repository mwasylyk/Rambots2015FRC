package org.usfirst.frc.team1350.robot.commands;

/**
 * Created by mwasylyk on 2/14/15.
 */
public class LiftBin extends AbstractLiftObject {

    private static final double liftTime = 3;
    private static final double liftSpeed = .65;

    @Override
    double getLiftTime() {
        return liftTime;
    }

    @Override
    double getLiftSpeed() {
        return liftSpeed;
    }
}
