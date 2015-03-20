package org.usfirst.frc.team1350.robot.commands.autonomous;

import org.usfirst.frc.team1350.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	
	private static final double speed = 2;
	private static final double driveTime = 1.55;
	
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
    	setTimeout(driveTime);
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
