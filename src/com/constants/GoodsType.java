package com.constants;

public enum GoodsType {
	DAIRY (0),
	MEAT (1),
	FRUIT (2),
	VEGTABLE (3),
	CLEANING (4);
	private GoodsType(int value) {
		this.value = value;
	}
	private int value;
	public int getValue() {
		return value;
	}
	
}
