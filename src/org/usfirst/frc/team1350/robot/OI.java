package org.usfirst.frc.team1350.robot;

import org.usfirst.frc.team1350.robot.commands.HomeLift;
import org.usfirst.frc.team1350.robot.commands.LiftBin;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import static org.usfirst.frc.team1350.robot.RobotMap.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
     public Joystick leftStick;
     public Joystick rightStick;
     public Joystick liftController;
     public Button upCrateButton;
//     public Button upBinButton;
     public Button downButton;
     public DigitalInput topLimitSwitch;
     public DigitalInput bottomLimitSwitch;

     private static OI instance;
     public static OI getInstance(){
    	 if(instance == null) {
    		 instance = new OI();
    	 }
    	 return instance;
     }

     private OI(){
    	 System.out.println("Creating OI instance");
     }
     
     public void init(){
    	 leftStick = new Joystick(JOYSTICK_LEFT_PORT);
    	 rightStick = new Joystick(JOYSTICK_RIGHT_PORT);
    	 liftController = new Joystick(LIFT_CONTROLLER);
         upCrateButton = new JoystickButton(liftController, LIFT_CRATE_UP_BUTTON);
//         upBinButton = new JoystickButton(rightStick, LIFT_BIN_UP_BUTTON);
         downButton = new JoystickButton(liftController, LIFT_DOWN_BUTTON);
         topLimitSwitch = new DigitalInput(TOP_LIMIT_SWITCH);
         bottomLimitSwitch = new DigitalInput(BOTTOM_LIMIT_SWITCH);

         
         upCrateButton.whenPressed(new LiftBin());
         downButton.whenPressed(new HomeLift());
     }

    public boolean isTopLimitHit(){
        return (topLimitSwitch.get());
    }

    public boolean isBottomLimitHit(){
        return (bottomLimitSwitch.get());
    }
}

