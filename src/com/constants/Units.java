package com.constants;

public enum Units {
	KG (0),
	LITER (1),
	BOTTLE (2);
	
	private Units(int value) {
		this.value = value;
	}
	private int value;
	public int getValue() {
		return value;
	}
}