package com.constants;

public enum ProductNames {
	LAMAR (1000),
	MARAAY (1001),
	ORANGE (2000),
	APPLE (2001),
	PERSIL (5000),
	ARIEL (5001),
	TOMATO (4000),
	ATYAB (3000),
	KOKI (3001),
	HALAWANY (3002);
	
	private ProductNames (int value) {
		this.value = value;
	}
	private int value;
	public int getValue() {
		return value;
	}
}
