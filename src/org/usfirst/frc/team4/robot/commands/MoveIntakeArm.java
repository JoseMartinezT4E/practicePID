package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.ControllerMap;
import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveIntakeArm extends Command {

    public MoveIntakeArm() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.moveArmForward(ControllerMap.TRIGGER_LEFT_2);
    	Robot.intake.moveArmReverse(ControllerMap.TRIGGER_RIGHT_2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
