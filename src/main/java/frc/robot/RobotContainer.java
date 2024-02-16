// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.ForwardBackward;
import frc.robot.commands.PickUp;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

import java.util.function.DoubleSupplier;

public class RobotContainer {

  private DriveSubsystem m_drive = new DriveSubsystem();
  private IntakeSubsystem m_intake = new IntakeSubsystem();

  private CommandXboxController m_controller = new CommandXboxController(0);
  public RobotContainer() {
    configureBindings();
    m_drive.setDefaultCommand(
      new DefaultDrive(m_drive,
        () -> m_controller.getLeftX()));
  }

  private void configureBindings() {
    m_controller.a().toggleOnTrue(new PickUp(m_intake, () -> true));
    m_controller.leftTrigger().whileTrue(new ForwardBackward(m_drive,() -> m_controller.getLeftTriggerAxis()));
    m_controller.rightTrigger().whileTrue(new ForwardBackward(m_drive,() -> -m_controller.getRightTriggerAxis()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
