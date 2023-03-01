// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final WPI_TalonSRX frontLeft;
  private final WPI_TalonSRX frontRight;
  private final WPI_TalonSRX backLeft;
  private final WPI_TalonSRX backRight;
  private MecanumDrive driveMecanum; 
  public enum Modes {
    Intake,Outtake,Off,Eject,Retract,Deploy;
  }
  
  

  public ExampleSubsystem() {
  frontLeft = new WPI_TalonSRX(Constants.DriveBase.FRONT_LEFT);
  frontRight = new WPI_TalonSRX(Constants.DriveBase.FRONT_RIGHT);
  backLeft = new WPI_TalonSRX(Constants.DriveBase.BACK_LEFT);
  backRight = new WPI_TalonSRX(Constants.DriveBase.BACK_RIGHT);
   
  driveMecanum = new MecanumDrive(frontLeft,backLeft,frontRight,backRight);
  }

  public void driveMecanum(double ySpeed, double xSpeed, double zRotation){
  driveMecanum.driveCartesian(ySpeed, xSpeed, zRotation);

  //ControlMode sets the way the motor runs,PercentOutput it tells it to take a double and gives it a percentage to run at.

  }
  
  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
