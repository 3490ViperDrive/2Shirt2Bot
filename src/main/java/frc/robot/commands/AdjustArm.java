package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class AdjustArm extends Command{
Shooter theShooter;
double speedShooter;
    
    public AdjustArm(Shooter thisShooter, double shooterSpeed){
        theShooter = thisShooter;
        speedShooter = shooterSpeed;
    }
    
    public void execute(){
        theShooter.armMotor.set(TalonSRXControlMode.PercentOutput, speedShooter);
    }
    
}
