package general;
import java.awt.Point;
import java.awt.image.BufferedImage;

//Base class for all objects in the game, including Cameras, Guards, Lights, Beacons, Players, etc
public abstract class Entity {
	protected World world;
	protected Point pos;
	public Entity(World world) {
		this.world = world;
	}
	public abstract void update();
	public Point getPos() {
		return pos;
	}
	public void setPos(Point pos) {
		this.pos = pos;
	}
	public abstract double getOpacity();
	public abstract BufferedImage getTile();
	public abstract void alertCamera();
	public abstract void markVisibility();
	
	//TO DO: Add sound calculations and alerts to update()
}
