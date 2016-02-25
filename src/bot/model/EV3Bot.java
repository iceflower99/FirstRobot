package bot.model;
 
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

/**
 * 
 * @author madeleine hales
 *@
 */
public class EV3Bot
{

private MovePilot botPilot;
	
 private EV3UltrasonicSensor distanceSensor; 
 private EV3TouchSensor backTouch;
 private float [] ultrasonicSamples;
 private float [] touchSamples;
	
 public EV3Bot()
 {
	 this.botMessage = "mady codes madyBot";
	 this.xPosition = 50;
	 this.yPosition = 50;
	 this.waitTime= 4000;
	 distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
	 backTouch = new EV3TouchSensor(LocalEV3.get().getPort("S2"));
	 
	 
	 
	 setupPilot();
	 
	 displayMessage();
	 
 }
 
 
public void driveRoom()
{
	ultrasonicSamples = new float [distanceSensor.sampleSize()];
	distanceSensor.fetchSample(ultrasonicSamples,0);
	if(ultrasonicSamples[0]<5)
	{
		botPilot.travel(20.00);
	}
	else
	{
		botPilot.travel(254.00);
	}
}
}
