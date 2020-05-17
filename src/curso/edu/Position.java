package curso.edu;

import javafx.geometry.Point2D;

public 	class Position {
	private double x;
	private double y;
	private double r;
	private double angle;
	private double scaleX;
	private double scaleY;
	
	public Position() {
		this.x = 0;
		this.y = 0;
		this.r = 0;
		this.angle = 0;
		this.scaleX = 1;
		this.scaleY = 1;
	}
	
	public void setPolarPositionInDegrees(double r, double angle) {
		this.r = r;
		double radAngle = Math.toRadians(angle);
		this.angle = radAngle;
		this.x = r * Math.cos(radAngle);
		this.y = r * Math.sin(radAngle);
	}
	
	public void setPolarPositionInRadians(double r, double angle) {
		this.r = r;
		long turns = Math.round(angle / (2*Math.PI));
		this.angle = angle - turns * (2*Math.PI);
		this.x = r * Math.cos(angle);
		this.y = r * Math.sin(angle);
	}
	
	public void setCoordinatePosition(double x, double y) {
		this.x = x;
		this.y = y;
		this.r = Math.sqrt(x * x + y * y);
		this.angle = Math.asin(y / r) * Math.signum(y);
	}
	
	public void addPolarPositionInDegrees(double r, double angle) {
		double nangle = Math.toRadians(angle);
		this.setPolarPositionInRadians(r + this.r, this.angle + nangle);
	}
	
	public void addCoordinatePosition(double x, double y) {
		this.setCoordinatePosition(x + this.x, y + this.y);
	}
	
	public double getX() {
		return(this.x);
	}
	
	public double getY() {
		return(this.y);
	}
	
	public double getR() {
		return(this.r);
	}
	
	public double getAngle () {
		return(this.angle);
	}
	
	public Point2D getPolarPosition() {
		return(new Point2D(this.r, this.angle));
	}
	
	public Point2D getCoordinatePosition() {
		return(new Point2D(this.x, this.y));
	}
	
	public void setCoordinateScale(double sx, double sy) {
		this.scaleX = sx;
		this.scaleY = sy;
	}
	
	public Point2D getScalableCoordinatePosition() {
		return(new Point2D(this.getX() * this.scaleX, this.getY() * this.scaleY));
	}
	
	public double getScaleX() {
		return(this.scaleX);
	}
	
	public double getScaleY() {
		return(this.scaleY);
	}
}


