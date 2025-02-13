package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.subsystems.Shooter;

public class FireCommand extends Command{
    Shooter shooter;
    int barrelChoose;
    public FireCommand (Shooter _shooter, int _barrelChoose){
        shooter = _shooter;
        barrelChoose = _barrelChoose;
        addRequirements(shooter);
    }

    public void execute(){
        shooter.fireBarrel(null);
    }
}