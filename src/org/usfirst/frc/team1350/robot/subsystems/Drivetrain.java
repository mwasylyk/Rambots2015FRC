package org.usfirst.frc.team1350.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.TeleOPTankDrive;


/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private static Drivetrain instance;
	
	public static Drivetrain getInstance(){
		if(instance == null) {
			instance = new Drivetrain();
		}
		return instance;
	}
	
	private Drivetrain() {
		System.out.println("Initializing singleton of: " + this.getClass().getCanonicalName());
	}
	
	private TeleOPTankDrive tankDrive;
	private Talon leftMotorController;
	private Talon rightMotorController;
	private RobotDrive robotDrive ;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void init() {
		tankDrive = TeleOPTankDrive.getInstance();
		leftMotorController = new Talon(RobotMap.DRIVE_TRAIN_LEFT_MOTOR_CONTROLLER);
		rightMotorController = new Talon(RobotMap.DRIVE_TRAIN_RIGHT_MOTOR_CONTROLLER);
		robotDrive = new RobotDrive(leftMotorController, rightMotorController);
	}
	
	@Override
    public void initDefaultCommand() {
        setDefaultCommand(tankDrive);
    }
    
    public void tankDrive(double left, double right, boolean squaredInput) {
    	robotDrive.tankDrive(left, right, squaredInput);
    }
    
    public void autoDrive(double speed){
    	robotDrive.drive(speed, 0.0);
    }

}

