// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Autonomous;

import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ArmTimedCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivebaseSubsystem;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCommand extends SequentialCommandGroup {
  /** Creates a new AutoCommand. */
  
  public AutoCommand(ArmSubsystem armSubsystem, DrivebaseSubsystem driveSubsystem, double maxVelocityMetersPerSecond,
  double maxAccelerationMetersPerSecond) {
    PathPlannerTrajectory triangle = 
        PathPlanner.loadPath(
          "Triangle", maxVelocityMetersPerSecond, maxAccelerationMetersPerSecond
        );
    PathPlannerTrajectory star =
        PathPlanner.loadPath(
          "Star", maxVelocityMetersPerSecond, maxAccelerationMetersPerSecond
          );
    PathPlannerTrajectory square =
        PathPlanner.loadPath(
          "Square", maxVelocityMetersPerSecond, maxAccelerationMetersPerSecond
          );
    PathPlannerTrajectory heart =
        PathPlanner.loadPath(
          "Heart", maxVelocityMetersPerSecond, maxAccelerationMetersPerSecond
        );
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new FollowTrajectoryCommand(triangle, driveSubsystem),
      new ParallelCommandGroup(
        new ArmTimedCommand(armSubsystem,.5, 2),
        new FollowerTrajectorycommand(star, driveSubsystem) 
      ),
      new WaitCommand (2),
      new FollowTrajectoryCommand(square, driveSubsystem),
      new FollowTrajectoryCommand(heart, driveSubsystem)
      );
  }
}
