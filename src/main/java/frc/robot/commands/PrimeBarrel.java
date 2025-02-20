package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Barrels;
import frc.robot.subsystems.Shooter;

public class PrimeBarrel extends SequentialCommandGroup{
    
    Shooter theShooter;
    Barrels thisBarrel;
    
    public PrimeBarrel(Shooter whichSubsystem, Barrels whichBarrel){
        theShooter = whichSubsystem;
        thisBarrel = whichBarrel;

        
        // this.addCommands(   new OpenValve(theShooter, thisBarrel), 
        //                     new WaitCommand(0.5), 
        //                     new CloseValve(theShooter, thisBarrel));

        this.addCommands(
            new InstantCommand(()-> theShooter.primeBarrel(thisBarrel),theShooter),
            new WaitCommand(.5),
            new InstantCommand(()-> theShooter.closeBarrel(thisBarrel), theShooter));
    }
}
