// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class InvertCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private  ExampleSubsystem subsystem;
  


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public InvertCommand(ExampleSubsystem subsystem) {
    this.subsystem = subsystem;
    
    // Used Requirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subsystem.invertedmotor();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}