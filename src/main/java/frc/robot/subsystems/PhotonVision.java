// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.net.PortForwarder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotonVision extends SubsystemBase {
  /** Creates a new PhotonVision. */
  PhotonTrackedTarget target;
  PhotonPipelineResult result;
  PhotonCamera cam;
  boolean hasTargets = false;

  public PhotonVision() {
    cam = new PhotonCamera("Microsoft_LifeCam)HD-3000");
    PortForwarder.add(5800, "photonvision", 5800);
    cam.setPipelineIndex(0);
  }


  @Override
  public void periodic() {
    result = cam.getLatestResult();
    hasTargets = result.hasTargets();
    if (result.hasTargets()){
      target = result.getBestTarget();
    }
    SmartDashboard.putBoolean("HasTargets", hasTargets);
    // This method will be called once per scheduler run
  }
}
