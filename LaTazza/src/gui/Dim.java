package gui;

public class Dim {//per la dimensione delle finestre
	private int w_frame=820;
	private int h_frame=700;
	private int width_comp;
	private int height_comp;
	private int distance;
	private int dist_x_frame;
	private int dist_y_frame;
	private int w_panel;
	private int h_panel;
	private int dist_x_panel;
	private int dist_y_panel;
	private int x_panel;
	private int y_panel;
	private int x_first_component;
	private int x_second_component;
	private int y_pos_button;
	private int x_only_component;
	private int y_only_component;
	
	public Dim() {
		width_comp=160;
		height_comp=30;
		distance=20;
		dist_x_frame=(w_frame-distance)/4;
		dist_y_frame=(h_frame-distance)/4;
		w_panel=w_frame-distance;
		h_panel=h_frame-distance;
		dist_x_panel=w_panel/4;
		dist_y_panel=h_panel/4;
		x_panel=w_panel/2-width_comp;
		y_panel=h_panel/2-height_comp;	
		x_first_component=dist_x_frame+distance;
		x_second_component=x_first_component+distance+x_panel;
		y_pos_button=dist_y_frame+h_panel-distance;
		x_only_component=dist_x_panel+width_comp;
		y_only_component=dist_y_panel+height_comp;
	}
	public Dim(int width,int height,int dis) {
		if(width>=w_frame && height>=h_frame && (dis>=distance && dis<=2*distance))
		{
			w_frame=width;
			h_frame=height;
			width_comp=w_frame/5;
			height_comp=h_frame/5;
			distance=dis;
			dist_x_frame=(w_frame-distance)/4;
			dist_y_frame=(h_frame-distance)/4;
			w_panel=w_frame-distance;
			h_panel=h_frame-distance;
			dist_x_panel=w_panel/4;
			dist_y_panel=h_panel/4;
			x_panel=w_panel/2-width_comp;
			y_panel=h_panel/2-height_comp;	
			x_first_component=dist_x_frame+distance;
			x_second_component=x_first_component+distance+x_panel;
			y_pos_button=dist_y_frame+h_panel-distance;
			x_only_component=dist_x_panel+width_comp;
			y_only_component=dist_y_panel;
		}
		else
			new Dim();
		
	}
	public int getW_frame() {
		return w_frame;
	}

	public void setW_frame(int w_frame) {
		this.w_frame = w_frame;
	}

	public int getH_frame() {
		return h_frame;
	}

	public void setH_frame(int h_frame) {
		this.h_frame = h_frame;
	}

	public int getWidth_comp() {
		return width_comp;
	}

	public void setWidth_comp(int width_comp) {
		this.width_comp = width_comp;
	}

	public int getHeight_comp() {
		return height_comp;
	}

	public void setHeight_comp(int height_comp) {
		this.height_comp = height_comp;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDist_x_frame() {
		return dist_x_frame;
	}

	public void setDist_x_frame(int dist_x_frame) {
		this.dist_x_frame = dist_x_frame;
	}

	public int getDist_y_frame() {
		return dist_y_frame;
	}

	public void setDist_y_frame(int dist_y_frame) {
		this.dist_y_frame = dist_y_frame;
	}

	public int getW_panel() {
		return w_panel;
	}

	public void setW_panel(int w_panel) {
		this.w_panel = w_panel;
	}

	public int getH_panel() {
		return h_panel;
	}

	public void setH_panel(int h_panel) {
		this.h_panel = h_panel;
	}

	public int getDist_x_panel() {
		return dist_x_panel;
	}

	public void setDist_x_panel(int dist_x_panel) {
		this.dist_x_panel = dist_x_panel;
	}

	public int getDist_y_panel() {
		return dist_y_panel;
	}

	public void setDist_y_panel(int dist_y_panel) {
		this.dist_y_panel = dist_y_panel;
	}

	public int getX_panel() {
		return x_panel;
	}

	public void setX_panel(int x_panel) {
		this.x_panel = x_panel;
	}

	public int getY_panel() {
		return y_panel;
	}

	public void setY_panel(int y_panel) {
		this.y_panel = y_panel;
	}

	public int getX_first_component() {
		return x_first_component;
	}

	public void setX_first_component(int x_first_component) {
		this.x_first_component = x_first_component;
	}

	public int getX_second_component() {
		return x_second_component;
	}

	public void setX_second_component(int x_second_component) {
		this.x_second_component = x_second_component;
	}

	public int getY_pos_button() {
		return y_pos_button;
	}

	public void setY_pos_button(int y_pos_button) {
		this.y_pos_button = y_pos_button;
	}

	public int getX_only_component() {
		return x_only_component;
	}

	public void setX_only_component(int x_only_component) {
		this.x_only_component = x_only_component;
	}

	public int getY_only_component() {
		return y_only_component;
	}

	public void setY_only_component(int y_only_component) {
		this.y_only_component = y_only_component;
	}
	

	
}
