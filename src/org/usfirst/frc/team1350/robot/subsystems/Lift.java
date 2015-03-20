package org.usfirst.frc.team1350.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
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
    private Encoder encoder;

    public void init(){
        liftMotor = new Victor(RobotMap.LIFT_MOTOR);
        encoder = new Encoder(RobotMap.LIFT_ENCODER1, RobotMap.LIFT_ENCODER2, true, CounterBase.EncodingType.k4X);
        encoder.setMaxPeriod(.1);
        encoder.setMinRate(10);
        encoder.setDistancePerPulse(5);
        encoder.setReverseDirection(false);
        encoder.setSamplesToAverage(7);
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
    
    public int getEncoderCount(){
    	return encoder.get();
    }
    
    public void resetEncoder(){
    	encoder.reset();
    }

}
