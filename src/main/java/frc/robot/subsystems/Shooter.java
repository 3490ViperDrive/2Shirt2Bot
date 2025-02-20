package frc.robot.subsystems;

import java.lang.reflect.Array;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Barrels;

public class Shooter extends SubsystemBase {

    //TODO to operate solenoid, use <motorControllerName>.set(TalonSRXControlMode.PercentOutput, 1);


    


    public final TalonSRX armMotor;

    final TalonSRX leftShooterSolenoidSRX;
    final TalonSRX rightShooterSolenoidSRX;
    final TalonSRX leftPrimerSolenoidSRX;
    final TalonSRX rightPrimerSolenoidSRX;



    

    public Shooter(){
        //TODO add correct IDs
        leftPrimerSolenoidSRX = new TalonSRX(0);
        rightPrimerSolenoidSRX = new TalonSRX(0);
        leftShooterSolenoidSRX = new TalonSRX(0);
        rightShooterSolenoidSRX = new TalonSRX(0);

        armMotor = new TalonSRX(0);

    }


    // public Command adjustArm(double speed){
       
    //         return null;
    //     //TODO write COMMAND that raises/lowers ARM MOTOR
    
    // }

    public void primeBarrel(Barrels whichBarrel){
        switch (whichBarrel) {
            case LEFT:
                leftPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 1);
                //leftPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                break;
            case RIGHT:
                rightPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 1);
                //rightPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                break;
            default:
                break;
        }
    }

    public void closeBarrel(Barrels whichBarrel){
        switch (whichBarrel) {
            case LEFT:
                leftPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                //leftPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                break;
            case RIGHT:
                rightPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                //rightPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                break;
            default:
                break;
        }
    }

    public void setSolenoid(Barrels whichBarrel, int value){
        switch(whichBarrel){
            case LEFT:
                leftPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, value);
                break;
            case RIGHT:
                rightPrimerSolenoidSRX.set(TalonSRXControlMode.PercentOutput, value);
            default:
                break;
        }
    }



    public void fireBarrel(Barrels whichBarrel){
        switch (whichBarrel) {
            case LEFT:
                leftShooterSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 1);
                break;
            case RIGHT:
                rightShooterSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 1);
                break;
            default:
                break;
        }
    }


//this stops the shooter solenoids
    public void ceaseFire(Barrels whichBarrel){
        switch (whichBarrel) {
            case LEFT:
                leftShooterSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                break;
            case RIGHT:
                rightShooterSolenoidSRX.set(TalonSRXControlMode.PercentOutput, 0);
                break;
            default:
                break;

        }
    }
}