package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.TeleOPTankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private static Talon leftMotorController = new Talon(RobotMap.DRIVE_TRAIN_LEFT_MOTOR_CONTROLLER);
	private static Talon rightMotorController = new Talon(RobotMap.DRIVE_TRAIN_RIGHT_MOTOR_CONTROLLER);
	private static RobotDrive robotDrive = new RobotDrive(leftMotorController, rightMotorController);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleOPTankDrive());
    }
    
    public void tankDrive(double left, double right) {
    	robotDrive.tankDrive(left, right);
    }
}

