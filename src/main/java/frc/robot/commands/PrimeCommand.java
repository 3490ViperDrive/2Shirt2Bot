package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.Barrels;
import frc.robot.subsystems.Shooter;

public class PrimeCommand extends Command{
    Shooter shooter;
    int barrelNo;
    Barrels barrelChoose;
    public PrimeCommand (Shooter _shooter, Barrels _barrelChoose){
        shooter = _shooter;
        barrelChoose = _barrelChoose;
        addRequirements(shooter);
    }
     public void execute(){
        //TODO call some method of the shooter object 
        shooter.primeBarrel(barrelChoose);
    }
}