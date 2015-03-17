package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousPickup extends CommandGroup {
    
    public  AutonomousPickup() {
        //addSequential(new LiftBin());
        addSequential(new AutoDrive());
    }
}
