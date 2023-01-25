// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import java.lang.ModuleLayer.Controller;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//A method is the set of instructions that can be used to perform a certain task. 
//They allow you to organize and reuse your code.

public class ExampleSubsystem extends SubsystemBase {
  private TalonSRX m_frontLeft;
  private TalonSRX m_frontRight;
  private TalonSRX m_backLeft;
  private TalonSRX m_backRight;
  private double m_speed;
  private PIDController pidController;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {

m_frontLeft = new TalonSRX(3);
m_frontRight = new TalonSRX(1);
m_backLeft = new TalonSRX(6);
m_backRight = new TalonSRX(7);
pidController = new PIDController(m_speed, m_speed, m_speed);
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

private void PIDController(Controller controller){
  /* inside constructor */
  pidController = new PIDController(0.005, 0, 0.00017);
  }
  
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








