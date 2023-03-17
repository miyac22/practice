// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */

public class ExampleCommand extends CommandBase {
  private final ExampleSubsystem m_subsystem;
  private final double m_speed;
  private ShuffleboardTab shuffleboardTab;
  public ExampleCommand(ExampleSubsystem subsystem, DoubleSupplier speed) {
    m_subsystem = subsystem;
    m_speed = speed.getAsDouble();
    addRequirements(subsystem);
    shuffleboardTab = Shuffleboard.getTab("iuehvnrwngregnergnerugneriugnergnerigunbergiuerngerui");
    shuffleboardTab.addNumber("Speed", speed);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_subsystem.setFrontSpeed(m_speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.setFrontSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
