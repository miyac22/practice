// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Autonomous.AutoCommand;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.ArmOtherCommand;
import frc.robot.commands.DrivebaseCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivebaseSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController controller = new XboxController(0);
  
  private final DrivebaseSubsystem m_exampleSubsystem = new DrivebaseSubsystem();
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final SendableChooser<Command> autoSelector = new SendableChooser<>();
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
      m_exampleSubsystem.setDefaultCommand(new DrivebaseCommand(m_exampleSubsystem, controller::getLeftY));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // new Button(controller::getAButton).whileHeld(new ExampleCommand(m_exampleSubsystem, 24));
    new Button(controller::getYButton).whenPressed(new ArmCommand(m_armSubsystem, 1024));
    new Button(controller::getBButton).whenPressed(new ArmOtherCommand(m_armSubsystem, .5));
    new Button(controller::getXButton).whenPressed(new ArmOtherCommand(m_armSubsystem, -.5));
  }

  private void setupAutonomousCommands(){
    Shuffleboard.getTab("DriverView")
        .addString("NOTES", () -> "...win?")
        .withSize(3,1)
        .withPosition(0,0);
  
  autoSelector.setDefaultOption(
    "[NEW] AutoTest",
    new AutoCommand(
      m_armSubsystem, m_exampleSubsystem, 2,1
    ));

    Shuffleboard.getTab ("DriverView")
      .add("auto selector", autoSelector)
      .withSize (4,1)
      .withPosition (7,0);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoSelector.getSelected();
  }
}
