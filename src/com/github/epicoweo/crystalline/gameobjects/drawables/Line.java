package com.github.epicoweo.crystalline.gameobjects.drawables;

import com.epicoweo.math.linearalgebra.Vector;
import com.epicoweo.math.linearalgebra.Vector2;
import com.epicoweo.math.linearalgebra.Vector3;

public class Line extends Shape2D {

	public float slope = 0;
	public boolean vertical = false;
	
	public Vector3 p1;
	public Vector3 p2;
	
	public Line(Vector p1, Vector p2) {
		this(p1.toVector3(), p2.toVector3());
	}
	
	public Line(float x1, float y1, float x2, float y2) {
		this(new Vector3(x1, y1, 0), new Vector3(x2, y2, 0));
	}
	
	//fix this up for vector3
	public Line(Vector3 p1, Vector3 p2) {
		super(2);
		//put the earlier vector first
		//vector 1's x > vector 2's x
		if(p1.x < p2.x) {
			this.p1 = p1;
			this.p2 = p2;
		} else {
			if(p1.x == p2.x) {
				if(p1.y < p2.y) {
					this.p1 = p1;
					this.p2 = p2;
				} else {
					this.p2 = p1;
					this.p1 = p2;
				}
			} else {
				this.p2 = p1;
				this.p1 = p2;
			}
		}
		
		if((p2.x-p1.x) != 0) {
			this.slope = (p2.y-p1.y)/(p2.x-p1.x);
		} else {
			this.vertical = true;
		}
		
		
	}

}
