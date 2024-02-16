// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDrive extends Command {
  /** Creates a new DefaultDrive. */
  private DriveSubsystem m_drive;

  private DoubleSupplier m_turnFunc;

  public DefaultDrive(DriveSubsystem drive, DoubleSupplier turnFunc) {
    m_drive = drive;
    m_turnFunc = turnFunc;

    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double turn = m_turnFunc.getAsDouble();

    m_drive.drive(0,turn);
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
