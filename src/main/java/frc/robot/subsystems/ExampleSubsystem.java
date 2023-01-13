// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private final PWMVictorSPX frontLeft;
    private final PWMVictorSPX frontRight;
    private final PWMVictorSPX backLeft;
    private final PWMVictorSPX backRight;
    private final MecanumDrive drive;

  public ExampleSubsystem(){
   frontLeft = new PWMVictorSPX(3);
   frontRight = new PWMVictorSPX(1);
   backLeft = new PWMVictorSPX(6);
   backRight = new PWMVictorSPX(7);
   drive = new MecanumDrive (frontLeft, backLeft, frontRight, backRight);
  }
  public void driveMecanum(double ySpeed, double xSpeed, double zRotation){
    drive.driveCartesian(ySpeed, xSpeed, zRotation);
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
