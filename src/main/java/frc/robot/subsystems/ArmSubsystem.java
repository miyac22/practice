// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private final TalonFX arm;
    private final ShuffleboardTab ArmTab = Shuffleboard.getTab("ArmTab");
    private PIDController pidController;
    private double desiredAngle;
    private ArmModes mode;
    private double power;
    private double startTime;
    private double timeDuration;

  public enum ArmModes{
    TIMED,
    ANGLE
  }
  public ArmSubsystem(){
   arm = new TalonFX(Constants.Arm.ARM);
   pidController = new PIDController(0.003, 0, 0.001);
   ArmTab.add("pid", pidController);
   ArmTab.addNumber("Desired Angle", () -> desiredAngle);
   ArmTab.addNumber("Current Angle", this::getAngle);
   // these are lambdas kind like use () -> bc its a variable and this:: bc its a method
   // () -> means define a double supplier that uses this or something (parameters) -> {expression};?
   // :: means using a method to get the number? idk something weirder maybe

   arm.setNeutralMode(NeutralMode.Brake);
  }

  public void timedPeriodic(){
    arm.set(ControlMode.PercentOutput, power);
    if (Timer.getFPGATimestamp() > startTime + timeDuration){
      arm.set(ControlMode.PercentOutput, 0);
      mode = ArmModes.ANGLE;
    }
  }
  
  public void anglePeriodic(){
    final double pidOutput = pidController.calculate(getAngle(), desiredAngle);
    arm.set(TalonFXControlMode.PercentOutput, MathUtil.clamp(pidOutput, -0.1, 0.1));
  }

  public double getAngle(){
    return arm.getSelectedSensorPosition();
  }

  public void setAngle(double desiredAngle){
    mode = ArmModes.ANGLE;
    this.desiredAngle = desiredAngle;
  }

  public void setTimed(double power, double timeDuration){
    mode = ArmModes.TIMED;
    this.power = power;
    this.timeDuration = timeDuration;
  }
  
  public ArmModes getMode(){
    return mode;
  }

  public void setMode(ArmModes mode){
    startTime = Timer.getFPGATimestamp();
    this.mode = mode;
  }


  @Override
  public void periodic() {
    switch(mode){
      case TIMED:
        timedPeriodic();
        break;
      case ANGLE:
        anglePeriodic();
        break;
    }
    // This pbmethod will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
