
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Turret;

//TankDrive is a command. It can package multiple elements of the robot together to make it move and work.
public class TankDrive extends Command {
  public DriveTrain dt;
  public Turret ls;
  //Creates an empty instance of the DriveTrain class
  public Joystick joy;
  public double mult = 0.7f;

  /** Creates a new TankDrive. */
  public TankDrive(DriveTrain dt, Turret ls, Joystick j) {
    this.dt = dt;
    this.joy = j;
    this.ls = ls;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dt, ls);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.tankDrive(0.0, 0.0);
  }
  //Keeps the robot stationary on initilization

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPowerRaw = joy.getRawAxis(1);

    double rightPowerRaw = joy.getRawAxis(5);

    dt.tankDrive(leftPowerRaw*mult, rightPowerRaw*mult);
  }//Runs the code to drive the robot. It makes the joystick power/position proportional to the talon power.

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0.0, 0.0);
  }
  //Ends the program by stopping the talons

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  //Detects if the program is finished
}
