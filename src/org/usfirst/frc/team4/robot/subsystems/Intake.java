package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.MoveIntakeArm;
import org.usfirst.frc.team4.robot.commands.MoveIntakeRoller;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
	private VictorSP intakeRoller;
	private VictorSP intakeArm;
	;
	/*
	public boolean isReversed_arm;
	public boolean isReversed_roller;
	*/
	
	public Intake (){
		intakeRoller = new VictorSP(RobotMap.kIntakeMotorRoller);
		intakeArm = new VictorSP(RobotMap.kIntakeMotorArm);
		
		/*
		isReversed_arm = false;
		isReversed_roller = false;
		*/
	}
	
	public void initDefaultCommand() {
        setDefaultCommand(new MoveIntakeArm());
        setDefaultCommand(new MoveIntakeRoller());
    }
	
	public void moveArmForward(double move){
		intakeRoller.set(move);
	}
	
	public void moveArmReverse(double move){
		intakeRoller.set(-move);
	}
	
	public void moveRollerForward(double move){
		intakeArm.set(move);
	}
	
	public void moveRollerReverse(double move){
		intakeArm.set(move);
	}
	
	public void armStop(){
		moveArmForward(0);
		moveArmReverse(0);
	}
	
	public void rollerStop(){
		moveRollerForward(0);
		moveRollerReverse(0);
	}
    
    
}

