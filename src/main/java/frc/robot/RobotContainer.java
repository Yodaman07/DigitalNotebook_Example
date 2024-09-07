// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final LimitSwitch ls = new LimitSwitch();
  private final LimitSwitchTest lst = new LimitSwitchTest(ls);

  // private final TankDrive tankDrive = new TankDrive(dt, ls, joy1);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    ls.setDefaultCommand(lst);
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}