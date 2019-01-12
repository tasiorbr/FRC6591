/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// The VM is configured to automatically run this class, and to call the
// functions corresponding to each mode, as described in the IterativeRobot
// documentation. If you change the name of this class or the package after
// creating this project, you must also update the build.properties file in the
// project.
public class Robot extends IterativeRobot {
	public static SpeedController driveTrainLeftFrontMotor;
	public static SpeedController driveTrainLeftRearMotor;
	public static SpeedController driveTrainRightFrontMotor;
	public static SpeedController driveTrainRightRearMotor;

	// Defining Timers
	public static Timer	switchTimer = new Timer();
	public static Timer scaleTimer = new Timer();
	public static Timer timer = new Timer();
	
	SpeedControllerGroup leftMotors;
	SpeedControllerGroup rightMotors;
	DifferentialDrive myRobot; 
	
	Joystick driveStick = new Joystick(0); 
	
	// This function is run when the robot is first started up and should be
	// used for any initialization code.
	@Override
	public void robotInit() {
		
		driveTrainLeftFrontMotor = new VictorSP(0);
		driveTrainLeftFrontMotor.setInverted(true);
		driveTrainLeftFrontMotor.set(0);
		
		driveTrainLeftRearMotor = new VictorSP(1);
		driveTrainLeftRearMotor.setInverted(true);
		driveTrainLeftRearMotor.set(0);
		
		driveTrainRightFrontMotor = new VictorSP(2);
		driveTrainRightFrontMotor.setInverted(true);
		driveTrainRightFrontMotor.set(0);
		
		driveTrainRightRearMotor = new VictorSP(3);
		driveTrainRightRearMotor.setInverted(true);
		driveTrainRightRearMotor.set(0);
		
		leftMotors = new SpeedControllerGroup(driveTrainLeftFrontMotor, driveTrainLeftRearMotor);
		rightMotors = new SpeedControllerGroup(driveTrainRightFrontMotor, driveTrainRightRearMotor);
		myRobot = new DifferentialDrive(leftMotors,rightMotors);
	}

	// This autonomous (along with the chooser code above) shows how to select
	// between different autonomous modes using the dashboard. The sendable
	// chooser code works with the Java SmartDashboard. If you prefer the
	// LabVIEW Dashboard, remove all of the chooser code and uncomment the
	// getString line to get the auto name from the text box below the Gyro
	
	// <p>You can add additional auto modes by adding additional comparisons to
	// the switch structure below with additional strings. If using the
	// SendableChooser make sure to add them to the chooser code above as well.
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
	}

	// This function is called periodically during autonomous.
	@Override
	public void autonomousPeriodic() {
		
	}

	@Override
	public void teleopInit() {
		myRobot.arcadeDrive(0,0); 
	}
	
	// This function is called periodically during operator control.
	@Override
	public void teleopPeriodic() {
		double leftStickVal = -0.5 * driveStick.getRawAxis(1);
		double rightStickVal = -0.5 * driveStick.getRawAxis(2);
		
		myRobot.arcadeDrive(leftStickVal, rightStickVal); 
		
	}

	// This function is called periodically during test mode.
	@Override
	public void testPeriodic() {	
	}
}