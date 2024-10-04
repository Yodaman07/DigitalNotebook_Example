// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private final WPI_TalonSRX limitSwitchTalon;
  /** Creates a new forward LimitSwitch. */
  public Turret() {
    limitSwitchTalon = new WPI_TalonSRX(4); //Update with port num
    limitSwitchTalon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);

    limitSwitchTalon.configForwardSoftLimitEnable(false);
    limitSwitchTalon.configReverseSoftLimitEnable(false);

  }


    public void move(int direction){
      limitSwitchTalon.set(0.4 * direction);
    }

    public boolean getLeftLimitValue(){
      return limitSwitchTalon.isFwdLimitSwitchClosed() == 0; // returns true if fwd limit switch is closed
    }

     public boolean getRightLimitValue(){
      return limitSwitchTalon.isRevLimitSwitchClosed() == 0; // returns true if fwd limit switch is closed
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Left_Limit", getLeftLimitValue());
    SmartDashboard.putBoolean("Right_Limit", getRightLimitValue());

        
  }
}
