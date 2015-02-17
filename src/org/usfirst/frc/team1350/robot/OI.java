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
     public Button upCrateButton;
     public Button upBinButton;
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
         upCrateButton = new JoystickButton(rightStick, LIFT_CRATE_UP_BUTTON);
         upBinButton = new JoystickButton(rightStick, LIFT_BIN_UP_BUTTON);
         downButton = new JoystickButton(rightStick, LIFT_DOWN_BUTTON);
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
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

