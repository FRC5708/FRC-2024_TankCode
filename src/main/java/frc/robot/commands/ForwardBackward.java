// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class ForwardBackward extends Command {
  /** Creates a new ForwardBackward. */

  private DriveSubsystem m_drive;

  private DoubleSupplier m_driveFunc;

  public ForwardBackward(DriveSubsystem drive, DoubleSupplier driveFunc) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_driveFunc = driveFunc;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = m_driveFunc.getAsDouble();
    m_drive.drive(speed,0);
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
