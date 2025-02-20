package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Barrels;
import frc.robot.subsystems.Shooter;

public class FireCommand extends SequentialCommandGroup{
    Shooter theShooter;
    Barrels thisBarrel;

public FireCommand (Shooter whichSubsystem, Barrels whichBarrel){
    theShooter = whichSubsystem;
    thisBarrel = whichBarrel;
    addRequirements(theShooter);

        this.addCommands(
           new InstantCommand(()-> theShooter.fireBarrel(whichBarrel), theShooter),
           new WaitCommand(.5),
           new InstantCommand(()-> theShooter.ceaseFire(whichBarrel),theShooter)

        );
    }
    
}