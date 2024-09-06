// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.CV;
import frc.robot.subsystems.PhotonVision;
import edu.wpi.first.wpilibj2.command.Command;



public class RobotContainer {
  
  
  public final PhotonVision photonVision = new PhotonVision();
  public final CV cv = new CV(photonVision);

  public RobotContainer() {
    // Configure the trigger bindings
    photonVision.setDefaultCommand(cv);
    configureBindings();
  }

  
  private void configureBindings() {
    
  }


  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
