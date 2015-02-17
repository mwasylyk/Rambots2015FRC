package org.usfirst.frc.team1350.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1350.robot.RobotMap;

/**
 * Created by mwasylyk on 2/13/15.
 */
public class Lift extends Subsystem{

    private static Lift instance;

    public static Lift getInstance(){
        if(instance == null) {
            instance = new Lift();
        }
        return instance;
    }

    private Victor liftMotor;

    public void init(){
        liftMotor = new Victor(RobotMap.LIFT_MOTOR);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void moveLiftUp(double liftSpeed){
        liftMotor.set(liftSpeed);
    }

    public void lowerLift(double liftSpeed){
        liftMotor.set(-liftSpeed);
    }

    public void stopLift(){
        liftMotor.set(0);
        liftMotor.stopMotor();

    }

}
