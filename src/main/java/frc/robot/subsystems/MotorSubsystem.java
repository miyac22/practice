// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants;


public class MotorSubsystem extends SubsystemBase {

  private PIDController controller;
  private double desiredAnlge;
  private final TalonFX frontLeft;
  private final ShuffleboardTab MotorTab;

  
  /** Creates a new MotorSubsystem. */
  public MotorSubsystem() {controller = new PIDController(0.005,0,0.00017);
    frontLeft = new TalonFX(Constants.Motor.MOTOR_ID);
    MotorTab = Shuffleboard.getTab("MotorTab");
    MotorTab.addNumber("left motor sensor value ", frontLeft::getSelectedSensorPosition);
    MotorTab.add("PID Controller", controller);

  }
  public double getTargetedAngle(){
    return desiredAnlge;
  }
  
  public double getAngle(){
    return frontLeft.getSelectedSensorPosition();
  }
  public void setAngle (double desiredAnlge) {
    this.desiredAnlge = desiredAnlge; 
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    frontLeft.set(TalonFXControlMode.PercentOutput, controller.calculate(getAngle(),getTargetedAngle()));
    //tells the motor the percentge it runs
  }
}
