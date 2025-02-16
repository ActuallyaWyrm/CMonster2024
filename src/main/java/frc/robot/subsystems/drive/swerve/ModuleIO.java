package frc.robot.subsystems.drive.swerve;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

/**
 * Common input-output interface for a single swerve module. This is responsible for assigning
 * higher-level inputs (eg a target module angle or wheel velocity).
 */
public interface ModuleIO extends AutoCloseable {
  /** Gets the current tangential linear speed of the wheel, in meters per second. */
  double getWheelVelocity();

  /**
   * Gets the total distance driven by the wheel since the beginning of the simulation. This
   * distance can be reset to zero by calling {@link #resetEncoders()} at any time.
   *
   * <p>Wheel distances are measured in meters.
   */
  double getWheelDistance();

  /**
   * Gets the rotation of the module with respect to the internal zero point. This should <i>not</i>
   * include any chassis angular offsets.
   */
  Rotation2d getModuleRotation();

  /** Sets the desired state (speed and angle) of the module. */
  void setDesiredState(SwerveModuleState state);

  /** Immediately stops all motors. */
  void stop();

  /**
   * Resets the internal distance tracking to zero.
   *
   * @see #getWheelDistance() getWheelDistance()
   */
  void resetEncoders();

  /** Closes the IO object and frees or destroys any held resources. */
  @Override
  void close();
}
