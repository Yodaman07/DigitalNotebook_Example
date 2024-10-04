// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Turret;

public class LimitSwitchTest extends Command {
  Turret t;
  int direction;
  /** Creates a new LimitSwitchTest. */
  public LimitSwitchTest(Turret ls) {
    t = ls;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ls);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    direction = 1;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (t.getLeftLimitValue() == true){
      direction = -1;
    }else if(t.getRightLimitValue() == true){
      direction = 1;
    }

    t.move(direction);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    t.move(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
