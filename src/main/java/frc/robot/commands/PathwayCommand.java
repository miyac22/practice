// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem;

public class PathwayCommand extends CommandBase {
  private ExampleSubsystem motorSubsystem;
  private PathPlannerTrajectory path;

  /** Creates a new MotorCommand. */
  public PathwayCommand(ExampleSubsystem subsystem) {
    path = PathPlanner.loadPath("auto test", 1, 1);
    this.motorSubsystem = subsystem;
    addRequirements(motorSubsystem);

    

    // Use addRequirements() here to declare subsystem dependencies.
  }

  

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
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
