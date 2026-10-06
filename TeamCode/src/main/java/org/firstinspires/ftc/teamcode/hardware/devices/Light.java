package org.firstinspires.ftc.teamcode.hardware.devices;

import com.qualcomm.robotcore.hardware.LED;

/**
 * Represents a dual-color LED light (green and red) on the robot.
 * Provides methods to control and query the state of each LED.
 */
public class Light {
  private final LED ledGreen;
  private final LED ledRed;

  /**
   * Constructs a new Light instance with the specified green and red LEDs.
   *
   * @param ledRed   The red LED component.
   * @param ledGreen The green LED component.
   */
  public Light(LED ledRed, LED ledGreen) {
    this.ledGreen = ledGreen;
    this.ledRed = ledRed;
  }

  public void setGreen(boolean state) {
    ledGreen.enable(state);
  }

  public void setRed(boolean state) {
    ledRed.enable(state);
  }

  public void on() {
    ledGreen.enable(true);
    ledRed.enable(true);
  }

  public void off() {
    ledGreen.enable(false);
    ledRed.enable(false);
  }

  public boolean getGreen() {
    return ledGreen.isLightOn();
  }

  public boolean getRed() {
    return ledRed.isLightOn();
  }
}
