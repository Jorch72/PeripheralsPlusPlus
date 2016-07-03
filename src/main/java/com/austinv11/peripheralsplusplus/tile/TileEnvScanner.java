package com.austinv11.peripheralsplusplus.tile;

import com.austinv11.peripheralsplusplus.util.CCMethod;

public class TileEnvScanner extends TilePeripheral {
	public static final String name = "tileEnvScanner";

	@CCMethod
	public boolean isRaining() {
		return worldObj.isRaining();
	}

	@CCMethod
	public String getBiome() {
		return worldObj.getBiomeForCoordsBody(getPos()).getBiomeName();
	}

	@CCMethod
	public String getTemperature() {
		return worldObj.getBiomeForCoordsBody(getPos()).getTempCategory().name();
	}

	@CCMethod
	public boolean getSnow() {
		return worldObj.getBiomeForCoordsBody(getPos()).getEnableSnow();
	}

	@Override
	public String getType() {
		return "envScanner";
	}
}
