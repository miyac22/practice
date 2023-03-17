// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//A method is the set of instructions that can be used to perform a certain task. 
//They allow you to organize and reuse your code.

public class ExampleSubsystem extends SubsystemBase {
  private WPI_TalonSRX m_frontLeft;
  private WPI_TalonSRX m_frontRight;
  private WPI_TalonSRX m_backLeft;
  private WPI_TalonSRX m_backRight;
  private MecanumDrive drivebase;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    m_frontLeft = new WPI_TalonSRX(3);
    m_frontRight = new WPI_TalonSRX(1);
    m_backLeft = new WPI_TalonSRX(6);
    m_backRight = new WPI_TalonSRX(7);
    drivebase = new MecanumDrive(m_frontLeft, m_backLeft, m_frontRight, m_backRight);
  }
  public void setFrontSpeed(double speed){
    m_frontLeft.set(ControlMode.PercentOutput, speed);
    m_frontRight.set(ControlMode.PercentOutput, speed);
    m_backLeft.set(ControlMode.PercentOutput, speed);
    m_backRight.set(ControlMode.PercentOutput, speed);
  }
  public void stopAll(){
    m_frontLeft.set(ControlMode.PercentOutput, 0);
    m_frontRight.set(ControlMode.PercentOutput, 0);
    m_backLeft.set(ControlMode.PercentOutput, 0);
    m_backRight.set(ControlMode.PercentOutput, 0);
  }

  public void InvertMotors() {
    m_backLeft.setInverted(m_backLeft.getInverted());
    m_backRight.setInverted(m_backRight.getInverted());
    m_frontLeft.setInverted(m_frontLeft.getInverted());
    m_frontRight.setInverted(m_frontRight.getInverted());

  }

/*private void PIDController(Controller controller){
  // inside constructor 
  pidController = new PIDController(0.005, 0, 0.00017);
  }
*/

//FL = 3
// FR = 1
// BL = 6
// BR = 7

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

  }
}








