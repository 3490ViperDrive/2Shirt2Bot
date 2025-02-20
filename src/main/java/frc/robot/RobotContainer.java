// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.AdjustArm;
import frc.robot.commands.FireCommand;
import frc.robot.commands.PrimeBarrel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  CommandXboxController player1;
  DriveTrain theDriveTrain;
  Shooter theShooter;
  double liftSpeed;

  
  public RobotContainer() {
    theDriveTrain = new DriveTrain();
    theShooter = new Shooter();
    player1 = new CommandXboxController(0);
    liftSpeed = 0.2;
    theDriveTrain.setDefaultCommand(theDriveTrain.defaultCommand(player1.getLeftX(), player1.getLeftY(), player1.getRightX()));
    configureBindings();
  }

  private void configureBindings() {
    //TODO redo the bindings.
    player1.povLeft().and(player1.x()).onTrue(new PrimeBarrel(theShooter, Barrels.LEFT));
    player1.povRight().and(player1.x()).onTrue(new PrimeBarrel(theShooter, Barrels.RIGHT));
    player1.povLeft().and(player1.y()).onTrue(new FireCommand(theShooter, Barrels.LEFT));
    player1.povRight().and(player1.y()).onTrue(new FireCommand(theShooter, Barrels.RIGHT));
    player1.povUp().onTrue(new AdjustArm(theShooter, liftSpeed));
    player1.povDown().onTrue(new AdjustArm(theShooter, -liftSpeed));
    player1.a().onTrue(null);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
