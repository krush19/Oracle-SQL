package com.mastek.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		
	}
	
	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color : Red");
	}

}
