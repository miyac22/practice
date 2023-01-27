// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;


public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private final TalonSRX frontLeft;
    private final TalonSRX frontRight;
    private final TalonSRX backLeft;
    private final TalonSRX backRight;

  public DrivebaseSubsystem(){
   frontLeft = new TalonSRX(Constants.DriveBase.FRONT_LEFT);
   frontRight = new TalonSRX(Constants.DriveBase.FRONT_RIGHT);
   backLeft = new TalonSRX(Constants.DriveBase.BACK_LEFT);
   backRight = new TalonSRX(Constants.DriveBase.BACK_RIGHT);
   frontRight.setInverted(true);
   backRight.setInverted(true);

  }
  public void drive(double ySpeed){
    frontLeft.set(ControlMode.PercentOutput, ySpeed);
    backLeft.set(ControlMode.PercentOutput, ySpeed);
    frontRight.set(ControlMode.PercentOutput, ySpeed);
    backRight.set(ControlMode.PercentOutput, ySpeed);
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
