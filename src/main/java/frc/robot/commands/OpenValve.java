package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Barrels;
import frc.robot.subsystems.Shooter;

public class OpenValve extends Command{
    Shooter _shooter;
    Barrels thisBarrel;

    public OpenValve(Shooter aShooter, Barrels whichBarrel){
        _shooter = aShooter;
        thisBarrel = whichBarrel;
        addRequirements(_shooter);
    }

    public void execute(){
        _shooter.setSolenoid(thisBarrel, 1);
    }
}
