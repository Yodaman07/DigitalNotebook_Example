// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Objects;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimitSwitch extends SubsystemBase {
  private final WPI_TalonSRX limitSwitchTalon;
  /** Creates a new forward LimitSwitch. */
  public LimitSwitch() {
    limitSwitchTalon = new WPI_TalonSRX(0); //Update with port num
    limitSwitchTalon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);

    limitSwitchTalon.configForwardSoftLimitEnable(false);
  }

    public boolean getLimitValue(){
      return limitSwitchTalon.isFwdLimitSwitchClosed() == 1; // returns true if fwd limit switch is closed
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("Left_Limit", getLimitValue());
        
  }
}
