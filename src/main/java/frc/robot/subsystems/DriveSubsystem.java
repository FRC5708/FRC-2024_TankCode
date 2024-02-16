package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkLowLevel;

import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase{

    private CANSparkMax m_frontLeftMotor = new CANSparkMax(DriveConstants.frontLeftMotorID, CANSparkLowLevel.MotorType.kBrushless);
    private CANSparkMax m_frontRightMotor = new CANSparkMax(DriveConstants.frontRightMotorID, CANSparkLowLevel.MotorType.kBrushless);
    private CANSparkMax m_backLeftMotor = new CANSparkMax(DriveConstants.backLeftMotorID, CANSparkLowLevel.MotorType.kBrushless);
    private CANSparkMax m_backRightMotor = new CANSparkMax(DriveConstants.backRightMotorID, CANSparkLowLevel.MotorType.kBrushless);

    private DifferentialDrive m_drive;

    public DriveSubsystem() {
        m_backLeftMotor.follow(m_frontLeftMotor);
        m_backRightMotor.follow(m_frontRightMotor);

        m_drive = new DifferentialDrive(m_frontLeftMotor, m_frontRightMotor);
    }

    public void drive(double speed, double turn) {
        m_drive.arcadeDrive(speed,turn);
    }
}