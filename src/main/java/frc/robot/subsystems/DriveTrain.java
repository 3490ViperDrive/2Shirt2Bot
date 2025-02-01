package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{
    MecanumDrive theMecanumDrive;
    WPI_TalonSRX FrontLeftMotor;   
    WPI_TalonSRX BackLeftMotor;
    WPI_TalonSRX FrontRightMotor;
    WPI_TalonSRX BackRightMotor;

    public DriveTrain(){
        FrontLeftMotor = new WPI_TalonSRX(0);
        BackLeftMotor = new WPI_TalonSRX(1);
        FrontRightMotor = new WPI_TalonSRX(2);
        BackRightMotor = new WPI_TalonSRX(3);
        theMecanumDrive = new MecanumDrive(FrontLeftMotor, BackLeftMotor, FrontRightMotor, BackRightMotor);
    }

    public Command defaultCommand(double xCoord, double yCoord, double zRotation) {
        return this.runOnce(()->{
            theMecanumDrive.driveCartesian(xCoord, yCoord, zRotation);
        });
    }
}
