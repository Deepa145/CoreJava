package edu.lessons.day60.oops.interfaces;
public abstract class VehicleAbstract implements IVehicle{
	@Override
	public void start() {
		System.out.println("Vehicle.Start");
	}
}