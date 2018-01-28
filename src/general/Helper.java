package general;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Helper {
	public static boolean lineOfSight(World w, Point start, Point end) {
		double distance = start.distance(end);
		List<Point> points = new ArrayList<>();
		Point displacement = new Point(end.x - start.x, end.y - start.y);
		double magnitude = Math.sqrt(displacement.x * displacement.x + displacement.y * displacement.y);
		Point2D.Double normal = new Point.Double(displacement.x / magnitude, displacement.y / magnitude);
		points.add(start);
		
		int visibility = 255;
		Point previous = null;
		Point2D.Double inc = new Point2D.Double(normal.x / 5, normal.y / 5);
		for(Point2D.Double pDouble = new Point.Double(start.x, start.y); pDouble.distance(start) < distance-1; pDouble = new Point.Double(pDouble.x + inc.x, pDouble.y + inc.y)) {
			Point p = new Point((int) Math.round(pDouble.getX()), (int) Math.round(pDouble.getY()));
			
			if(p.equals(previous)) {
				continue;
			} else if(p.equals(start)) {
				continue;
			} else if(p.equals(end)) {
				return true;
			}
			
			if(!w.isOpen(p)) {
				visibility -= w.getAt(p).getOpacity();
				
				if(visibility <= 0) {
					return false;
				}
			}
			
			previous = p;
		}
		return true;
	}
}
