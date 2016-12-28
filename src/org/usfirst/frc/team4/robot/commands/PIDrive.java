package org.usfirst.frc.team4.robot.commands;

import org.usfirst.frc.team4.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDrive extends Command {
	
	private double kP = 0.123, kI = 0.456, kD = 7;
	private PIDController drivePid;
	
    public PIDrive() {
    	requires(Robot.chassis);
    	
    	// The pid source + output part of the pid controller is basically creating a 
    	// class within a class so you do -> new [random garbage]
    	
    	drivePid = new PIDController(kP, kI, kD, new PIDSource() {
			
    		private PIDSourceType srcType;
    		
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				// TODO Auto-generated method stub
				srcType = pidSource;
				
			}
			
			@Override
			public double pidGet() {
				// TODO Auto-generated method stub
				// PiDSOURCETYPE IS THE SENSOR GET FUNCTION STUFF
				return Robot.chassis.getGyroAngle();
			}
			
			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return srcType.kDisplacement;
			}
		}, new PIDOutput() {
			
			@Override
			public void pidWrite(double output) {
				// TODO Auto-generated method stub
				Robot.chassis.arcadeDrive(output, 0);
			}
		}
    		
    	);
    	
    	double driveSetpoint = 180;
    	double absoluteTolerance = 1;
    	
    	drivePid.setAbsoluteTolerance(absoluteTolerance);
    	drivePid.setSetpoint(driveSetpoint);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivePid.reset();
    	drivePid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivePid.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
