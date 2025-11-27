## As of 11/22 
Right now the code runs the basic tankdrive code. It is a modified copy from the 2022-2023 preseason. In `RobotContainer` the drive train object is initialized and the default command for it is set to be the drive train. In the `DriveTrain.java` subsystem, both of the talons we use are configured (one is inverted, both are reset to factory default), there is a tankdrive method moving both motors by the same factor and shuffleboard outputs are listed. In the `TankDrive.java` command, input from the joystick is taken and translated to the tankdrive method of `DriveTrain.java`. Note, the code is not up to standard with everything as I have not yet put the constants in the appropriate file.

## Update from 11/27
Removed unescessary lines of code in `DriveTrain.java`