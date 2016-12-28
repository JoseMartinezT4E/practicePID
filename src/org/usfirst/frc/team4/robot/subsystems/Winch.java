package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
    
	// winch
    private VictorSP frontWinch;
    private VictorSP backWinch;
    
    private RobotDrive winch;
    
    /*maybe sensors
    private Potentiometer bottomPot;
    private Potentiometer topPot;
    */
    
    public Winch(){
    	
    	frontWinch = new VictorSP(RobotMap.kClimbWinchMotorFront);
    	backWinch  = new VictorSP(RobotMap.kClimbWinchMotorBack);
    	
    	winch = new RobotDrive(frontWinch, backWinch);
    	
    	/*
    	 * bottomPot = new Potentiometer(1)
    	 * topPot = new Potentiometer(2) 
    	 */
    	
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void winchMove(double leftForward, double rightForward){
    	winch.tankDrive(leftForward, rightForward);
    }
    
    public void winchStop(){
    	winchMove(0, 0);
    }
    
 //   public double getPotValue(){}
    
}

