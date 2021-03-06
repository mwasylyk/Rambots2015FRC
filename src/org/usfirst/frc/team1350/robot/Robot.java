
package org.usfirst.frc.team1350.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1350.robot.commands.autonomous.AutonomousPickup;
import org.usfirst.frc.team1350.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1350.robot.subsystems.Lift;

/**
 *
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
    public static Lift lift;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = OI.getInstance();
		oi.init();
        drivetrain = Drivetrain.getInstance();
		drivetrain.init();
        lift = Lift.getInstance();
		lift.init();
        
		autonomousCommand = new AutonomousPickup();
    }
	
	public void disabledPeriodic() {
		
	}

    public void autonomousInit() {
    	if(autonomousCommand !=null){
    		autonomousCommand.start();
    	}
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null){
        	autonomousCommand.cancel();
        }
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
