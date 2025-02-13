// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  CommandXboxController player1;
  DriveTrain theDriveTrain;
  Shooter theShooter;


  
  public RobotContainer() {
    theDriveTrain = new DriveTrain();
    player1 = new CommandXboxController(0);
    theDriveTrain.setDefaultCommand(theDriveTrain.defaultCommand(player1.getLeftX(), player1.getLeftY(), player1.getRightX()));
    configureBindings();
  }

  private void configureBindings() {
    player1.povLeft().and(player1.x()).onTrue(null);
    player1.povRight().and(player1.x()).onTrue(null);
    player1.povLeft().and(player1.y()).onTrue(null);
    player1.povRight().and(player1.y()).onTrue(null);
    player1.povUp().onTrue(null);
    player1.povDown().onTrue(null);
    player1.a().onTrue(theShooter.adjustArm(0));

  }


  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
