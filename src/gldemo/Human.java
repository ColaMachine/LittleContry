package gldemo;

import glmodel.GL_Vector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Human {
	static final float PIdiv180 = 0.0174532925f;
	public GL_Vector ViewDir;
	public GL_Vector RightVector;
	public GL_Vector UpVector;
	public GL_Vector Position;
	public float RotatedX, RotatedY, RotatedZ;
	public float camSpeedR = 90;         // degrees per second
	public float camSpeedXZ = 10;        // units per second 
	public float camSpeedY  = 10;        // units per second
	
	int height=2;
	public HumanHead head=new HumanHead();
	public HumanHand LHand=new HumanHand();
	public HumanHand RHand=new HumanHand();
	public HumanLeg LLeg=new HumanLeg();
	public HumanLeg RLeg=new HumanLeg();
	public HumanBody body=new HumanBody();
	
	boolean stable = true;
	public void setStable(boolean flag){
		this.stable=flag;
	}
	
	float nextZ=0;
	int limit=0;
	int mark=0;
	public void flip(int y){
		mark=y;
		limit=0;
	}
	public void reset(){
		mark=limit=0;
	}
	public void nextMotion(){
		if(!this.stable){
			this.Position.y-=0.1;
		}
	}
	public void setHuman(float posx, float posy, float posz,
			float dirx, float diry, float dirz,
			float upx, float upy, float upz)
	{
		if (upx == 0 && upy == 0 && upz == 0) {
			System.out.println("GLCamera.setCamera(): Up vector needs to be defined");
			upx=0; upy=1; upz=0;
		}
		if (dirx == 0 && diry == 0 && dirz == 0) {
			System.out.println("GLCamera.setCamera(): ViewDirection vector needs to be defined");
			dirx=0; diry=0; dirz=-1;
		}
		Position 	= new GL_Vector(posx, posy, posz);
		ViewDir 	= new GL_Vector(dirx, diry, dirz);
		UpVector 	= new GL_Vector(upx, upy, upz);
		RightVector	= GL_Vector.crossProduct(ViewDir, UpVector);
		RotatedX = RotatedY = RotatedZ = 0.0f;  // TO DO: should set these to correct values
		
		head.setHead(posx, posy+2, posz, dirx, diry, dirz, upx, upy, upz);
		LLeg.setHead(posx-0.5f, posy+3f, posz, dirx, diry, dirz, upx, upy, upz);
		RLeg.setHead(posx+0.5f, posy+3f, posz, dirx, diry, dirz, upx, upy, upz);
		LHand.setHead(posx-1.5f, posy, posz, dirx, diry, dirz, upx, upy, upz);
		RHand.setHead(posx+1.5f, posy, posz, dirx, diry, dirz, upx, upy, upz);
		body.setHead(posx, posy, posz, dirx, diry, dirz, upx, upy, upz);
	}
	public void render(){
		head.render();
		LLeg.render();
		
		RLeg.render();
		
		
		LHand.render();
		
		RHand.render();
		body.render();
		/*
        GL11.glBegin(GL11.GL_QUADS);
        // Front Face
        GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y,  1.0f+Position.z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f( 1.0f+Position.x, -1.0f+Position.y,  1.0f+Position.z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y,  1.0f+Position.z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y,  1.0f+Position.z);	// Top Left
        // Back Face
        GL11.glNormal3f( 0.0f, 0.0f, -1.0f);
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y, -1.0f+Position.z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y, -1.0f+Position.z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y, -1.0f+Position.z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f( 1.0f+Position.x, -1.0f+Position.y, -1.0f+Position.z);	// Bottom Left
        // Top Face
        GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y, -1.0f+Position.z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y,  1.0f+Position.z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y,  1.0f+Position.z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y, -1.0f+Position.z);	// Top Right
        // Bottom Face
        GL11.glNormal3f( 0.0f, -1.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y, -1.0f+Position.z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f( 1.0f+Position.x, -1.0f+Position.y, -1.0f+Position.z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f( 1.0f+Position.x, -1.0f+Position.y,  1.0f+Position.z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y,  1.0f+Position.z);	// Bottom Right
        // Right face
        GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f( 1.0f+Position.x, -1.0f+Position.y, -1.0f+Position.z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y, -1.0f+Position.z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y,  1.0f+Position.z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f( 1.0f+Position.x, -1.0f+Position.y,  1.0f+Position.z);	// Bottom Left
        // Left Face
        GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y, -1.0f+Position.z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y,  1.0f+Position.z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y,  1.0f+Position.z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y, -1.0f+Position.z);	// Top Left
        GL11.glEnd();*/
	}
	public void move(float x,float y,float z){
		this.Position.x=x;
		this.Position.y=y;
		this.Position.z=z;
	}
	 public void handleNavKeys(float seconds)
	 {
	
	 if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
		 this.StrafeRight(-camSpeedXZ*seconds);
	 }
	 // Pan right
	 if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
		 this.StrafeRight(camSpeedXZ*seconds);
	 }
	 // tilt down
	 if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
		 this.MoveForward(-camSpeedXZ*seconds);
	 }
	 // tilt up
	 if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
		 this.MoveForward(camSpeedXZ*seconds);
	 }
	 }
	 public void StrafeRight(float Distance) {
			Position = GL_Vector.add(Position, GL_Vector.multiply(RightVector, Distance));
		}
	 
		public void MoveForward(float Distance) {
			Position = GL_Vector.add(Position, GL_Vector.multiply(ViewDir, -Distance));
		}
}
