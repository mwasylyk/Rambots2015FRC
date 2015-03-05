package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	
	private static final double speed = -1;
	private static final double driveTime = 2;
	
	private static AutoDrive instance;
	public static AutoDrive getInstance(){
		if(instance==null){
			instance= new AutoDrive();
		}
		return instance;
	}
	
    public AutoDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	setTimeout(1);
    }

    protected void execute() {
    	Robot.drivetrain.autoDrive(speed);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
