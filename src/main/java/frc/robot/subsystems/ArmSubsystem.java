// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private final TalonFX arm;
    private final ShuffleboardTab ArmTab = Shuffleboard.getTab("ArmTab");
    private PIDController pidController;
    private double desiredAngle;
   
  
  public ArmSubsystem(){
   arm = new TalonFX(13);
   pidController = new PIDController(0.003, 0, 0.001);
   ArmTab.add("pid", pidController);
   ArmTab.addNumber("Desired Angle", this::getTargetAngle);
   ArmTab.addNumber("Current Angle", this::getAngle);

   arm.setNeutralMode(NeutralMode.Brake);
  }

  public double getAngle(){
    return arm.getSelectedSensorPosition();
  }

  public double getTargetAngle() {
    return desiredAngle;
  }

  public void setAngle(double desiredAngle){
    this.desiredAngle = desiredAngle;
  }
  
  @Override
  public void periodic() {
    final double pidOutput = pidController.calculate(getAngle(), desiredAngle);
    arm.set(TalonFXControlMode.PercentOutput, MathUtil.clamp(pidOutput, -0.1, 0.1));
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}