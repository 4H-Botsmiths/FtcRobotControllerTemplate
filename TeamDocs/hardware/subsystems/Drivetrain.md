# Drivetrain Subsystem

Controls a four-wheel mecanum drivetrain using motor RPM commands.

The drivetrain supports both robot-centric and field-centric driving.
Field-centric driving uses the robot heading to transform field-relative
inputs into robot-relative commands.

## Constructor

Either 4 wrapped Motor's or 4 unwrapped DcMotorEx's and a pulses per revolution (PPR) value for the encoders.

## Functions

### Drive

Drives the robot in a robot-centric manner. If a gyro value is provided, it can be used to adjust the drive commands based on the robot's heading.
