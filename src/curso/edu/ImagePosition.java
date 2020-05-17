package curso.edu;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class ImagePosition extends Position{
	
	private Image img;
	private double dx;
	private double dy;
	private double centerX;
	private double centerY;
	
	public ImagePosition(Image img) {
		super();
		this.img = img;
		this.dx = - img.getWidth() / 2;
		this.dy = - img.getHeight() / 2;
		this.centerX = 0;
		this.centerY = 0;
	}
	
	public ImagePosition(Image img, double cx, double cy) {
		super();
		this.img = img;
		this.dx = - img.getWidth() / 2;
		this.dy = - img.getHeight() / 2;
		this.centerX = cx;
		this.centerY = cy;
	}
	
	public ImagePosition(Image img, Point2D p) {
		super();
		this.img = img;
		this.dx = - img.getWidth() / 2;
		this.dy = - img.getHeight() / 2;
		this.centerX = p.getX();
		this.centerY = p.getY();
	}
	
	public double getDX() {
		return(super.getX() + this.dx);
	}
	
	public double getDY() {
		return(super.getY() + this.dy);
	}
	
	public double getX() {
		return(this.centerX + this.getDX());
	}
	
	public double getY() {
		return(this.centerY + this.getDY());
	}
	
	public double getScalableX() {
		return(this.centerX + this.dx + super.getX() * super.getScaleX());
	}
	
	public double getScalableY() {
		return(this.centerY + this.dy + super.getY() * super.getScaleY());
	}
	
	public Image getImage() {
		return(this.img);
	}
	
	public String relatory() {
		String st = "  Coordinate Position: " + super.getX() + ", " + super.getY() + "\n"
				  + "  Polar Position: " + super.getR() + ", " + super.getAngle() + "\n"
				  + "  Center in: " + this.centerX + ", " + this.centerY + "\n"
				  + "  Image in: " + this.getX() + ", " + this.getY() + "\n";
		return(st);
	}
}
