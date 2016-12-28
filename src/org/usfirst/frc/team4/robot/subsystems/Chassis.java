package org.usfirst.frc.team4.robot.subsystems;

import org.usfirst.frc.team4.robot.RobotMap;
import org.usfirst.frc.team4.robot.commands.Drive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Chassis extends Subsystem {
	
	// physical robot parts
	
    private VictorSP leftFront;
	private VictorSP leftRear;
	private VictorSP rightFront;
    private VictorSP rightRear;
	
	private RobotDrive robotDrive;
	
	// sensors for Chassis
	
	private AnalogGyro gyro;
	
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	
	// toggle booleans
	
	public boolean driveType;
	public boolean speedType;	
	
	public Chassis() {			
			
		leftFront  = new VictorSP(RobotMap.kChassisMotorLeftFront);
		leftRear   = new VictorSP(RobotMap.kChassisMotorLeftRear);
		rightFront = new VictorSP(RobotMap.kChassisMotorRightFront);
		rightRear  = new VictorSP(RobotMap.kChassisMotorRightRear);
			
		gyro       = new AnalogGyro(RobotMap.kGyro);
		
		robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
		
		driveType = false; // TANK = false ARCADE = true
		speedType = false; // REGULAR = false SLOWER = true
		
		leftFront.setInverted(true);
		leftRear.setInverted(true);
		rightFront.setInverted(true);
		rightRear.setInverted(true);
			
		leftEncoder = new Encoder(RobotMap.kChassisLeftEncoderForward, RobotMap.kChassisLeftEncoderReverse);
		rightEncoder = new Encoder(RobotMap.kChassisMotorRightFront, RobotMap.kChassisMotorRightRear);
			
	}
	
	// manual no sensor stuff
		
    public void initDefaultCommand() {
       setDefaultCommand(new Drive());
    }
    
    public void drive(double left, double right){
    	if(driveType == false){
    		robotDrive.tankDrive(left, right);
    	}else {
    		double move = left, rotate = right;
    		robotDrive.arcadeDrive(move, rotate);
    	}
    	
    }
    
    public void arcadeDrive(double move, double rotate){
    	robotDrive.tankDrive(move, rotate);
    }
    
    //No idea if this way will work but it don't hurt to test
      
    public void slowerDriving(double left, double right){
    	double speedReduction = 0.75;
    	
    	if(speedType = false){
    		drive(left, right);
    	}else {
    		drive(speedReduction * left, speedReduction * right);
    	}
 
    }
    public void stopDrive(){
    	robotDrive.stopMotor();
    }
 
    // things used for sensors
    
    public void resetGyro(){
    	gyro.reset();
    }
    
    public double getGyroAngle(){
    	return gyro.getAngle();
    }
    
    public double getEncoderValue(){
    	return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
    }//cellino and barnes. injury attorneys. call 800-888-8888 
}

