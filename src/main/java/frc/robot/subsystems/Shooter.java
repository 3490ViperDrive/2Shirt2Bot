package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    //TODO declare the ARM MOTOR
    //Todo declare the SHOOTER SOLENOID
    final TalonSRX leftShooterSolenoidSRX;
    final TalonSRX rightShooterSolenoidSRX;
    final TalonSRX leftPrimerSolenoidSRX;
    final TalonSRX rightPrimerSolenoidSRX;
    

    public Shooter(){
        //TODO initialize the ARM MOTOR
        //TODO initialize the SHOOTER SOLENOID
        leftPrimerSolenoidSRX = new TalonSRX(0);
        rightPrimerSolenoidSRX = new TalonSRX(0);
        leftShooterSolenoidSRX = new TalonSRX(0);
        rightShooterSolenoidSRX = new TalonSRX(0);
        
        
        
    }
    
    public Command adjustArm(){
        //TODO write COMMAND that raises/lowers ARM MOTOR

        return null;
    }

    public Command shoot(){
        //TODO write COMMAND that shoots SHOOTER SOLENOID
        return null;
    }
}
