package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.MoveArms;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
    
	private VictorSP bottomArm;
    private VictorSP topArm;
        
    private RobotDrive arms;
    
    public Arms(){
    	bottomArm = new VictorSP(RobotMap.kClimbArmMotorBot);
    	topArm = new VictorSP(RobotMap.kClimbArmMotorTop);
    	
    	arms = new RobotDrive(bottomArm, topArm);
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new MoveArms());
    }
    
    public void armsMove(double bottom, double top){
    	arms.tankDrive(bottom, top);
    }
    
    public void armsStop(){
    	armsMove(0,0);
    }
    
}

