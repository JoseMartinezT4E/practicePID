package org.usfirst.frc.team4.robot;

import org.usfirst.frc.team4.robot.commands.MoveIntakeArm;
import org.usfirst.frc.team4.robot.commands.ToggleDrive;
import org.usfirst.frc.team4.robot.commands.ToggleSpeed;
import org.usfirst.frc.team4.robot.commands.WinchBackward;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public OI(){
		
		// intake buttons
		ControllerMap.operatorLeftTrigger2.whenPressed(new MoveIntakeArm());
		ControllerMap.operatorRightTrigger2.whenPressed(new MoveIntakeArm());
		
		// toggles
		ControllerMap.driveB.whenPressed(new ToggleDrive());	
		ControllerMap.driveA.whenPressed(new ToggleSpeed());
		
		// winch
		ControllerMap.operatorStart.whenPressed(new WinchBackward());
		ControllerMap.operatorSelect.whenPressed(new WinchBackward());
	}
	
	//Joystick Controllerss
	
	public double leftY(Joystick controller){
		return controller.getRawAxis(ControllerMap.AXIS_LEFT_Y);
	}
	
	public double rightY(Joystick controller){
		return controller.getRawAxis(ControllerMap.AXIS_RIGHT_Y);
	}
	
}

