package com.alza.quiz.qfactory.geom.model;

public class Stroke {
	public int type;//refer to Geom ColorSecondary
	public int color;//refer to Geom ColorPrimary
	/**
	 * Create a default stroke i,e : line stroke type with primary color
	 */
	public Stroke() {
		this.type = Geom.STROKE_LINE;
		this.color = Geom.COLOR_PRIMARY;
	}
	/**
	 * 
	 * @param type, line, dash ...refer to Geom stroke constants
	 * @param color, primary, secondary, ... refer to Geom color constants
	 */
	public Stroke(int type, int color) {
		super();
		this.type = type;
		this.color = color;
	}
	
}
