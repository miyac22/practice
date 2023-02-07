// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorSubsystem;

public class MotorCommand extends CommandBase {
  private MotorSubsystem motorSubsystem;
  private double getTargetedAngle;
  

  /** Creates a new MotorCommand. */
  public MotorCommand(MotorSubsystem subsystem, double getTargetedAngle) {
    this.motorSubsystem = subsystem;
    this.getTargetedAngle =getTargetedAngle;
    addRequirements(motorSubsystem);
    

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motorSubsystem.setAngle(getTargetedAngle);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
