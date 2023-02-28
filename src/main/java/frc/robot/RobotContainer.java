// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.InvertCommand;
import frc.robot.commands.MotorCommand;
import frc.robot.commands.PathwayCommand;
import frc.robot.commands.UninvertCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final MotorSubsystem m_MotorSubsystem = new MotorSubsystem();
  private final MotorCommand m_MotorCommand = new MotorCommand(m_MotorSubsystem, 0.5);
  private final ArmCommand m_ArmCommand = new ArmCommand(m_MotorSubsystem, 5);
  private final XboxController controller = new XboxController(0);
  private final ExampleCommand ExampleCommand = new ExampleCommand(m_exampleSubsystem, controller::getLeftY, controller::getLeftX, controller::getRightX);
  private final SendableChooser autoSelector = new SendableChooser<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_exampleSubsystem.setDefaultCommand(ExampleCommand);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new Button(controller::getXButton).whenPressed(new InvertCommand(m_exampleSubsystem));
    new Button(controller::getYButton).whenPressed(new UninvertCommand(m_exampleSubsystem));
    new Button (controller::getAButton).whenPressed (new MotorCommand(m_MotorSubsystem, 0.5));
    new Button (controller::getBButton).whenPressed (new ArmCommand(m_MotorSubsystem, 5));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
