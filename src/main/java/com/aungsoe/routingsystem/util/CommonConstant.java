package com.aungsoe.routingsystem.util;

public class CommonConstant {

	public enum VehicleType
	{
		VAN("van"), BIKE("bike");
		
		String type;
		
		private VehicleType(String type)
		{
			this.type = type;
		}
		
		public String getType()
		{
			return type;
		}
	}
}
