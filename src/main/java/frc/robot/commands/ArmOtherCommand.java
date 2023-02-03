// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ArmOtherCommand extends CommandBase {
  /** Creates a new ArmOtherCommand. */
  private final ArmSubsystem m_armSubsystem;
  private double power;
  private double startTime;
  
  public ArmOtherCommand(ArmSubsystem subsystem, double power) {
  this.m_armSubsystem = subsystem;
  this.power = power;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_armSubsystem.move(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Timer.getFPGATimestamp() > startTime + 5)
  {
    return true;
  }
    else {
      return false;
  }
  }
}
