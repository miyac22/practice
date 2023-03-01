// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class SequentialCommand extends SequentialCommandGroup {
  private ExampleSubsystem mExampleSubsystem;
  private MotorSubsystem motorSubsystem;
  //the time tracks how long the command is running 
  

  /** Creates a new MotorCommand. */
  public SequentialCommand(ExampleSubsystem subsystem, MotorSubsystem motorSubsystem, double getTargetedAngle) {
    this.motorSubsystem = motorSubsystem;
    mExampleSubsystem = subsystem;
    

    addCommands(new ArmCommand(motorSubsystem, 5), new MotorCommand(motorSubsystem,0.5)
    ,new PathwayCommand(mExampleSubsystem));

    

    
  }
}