package gldemo;

import org.lwjgl.opengl.GL11;

public class Block {
	
	int x=0;
	int y=0;
	int z=0;
	public void renderCube(){
        GL11.glBegin(GL11.GL_QUADS);
        // Front Face
        GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-1.0f+x, -1.0f+y,  1.0f+z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f( 1.0f+x, -1.0f+y,  1.0f+z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f( 1.0f+x,  1.0f+y,  1.0f+z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-1.0f+x,  1.0f+y,  1.0f+z);	// Top Left
        // Back Face
        GL11.glNormal3f( 0.0f, 0.0f, -1.0f);
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-1.0f+x, -1.0f+y, -1.0f+z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-1.0f+x,  1.0f+y, -1.0f+z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f( 1.0f+x,  1.0f+y, -1.0f+z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f( 1.0f+x, -1.0f+y, -1.0f+z);	// Bottom Left
        // Top Face
        GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-1.0f+x,  1.0f+y, -1.0f+z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-1.0f+x,  1.0f+y,  1.0f+z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f( 1.0f+x,  1.0f+y,  1.0f+z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f( 1.0f+x,  1.0f+y, -1.0f+z);	// Top Right
        // Bottom Face
        GL11.glNormal3f( 0.0f, -1.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-1.0f+x, -1.0f+y, -1.0f+z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f( 1.0f+x, -1.0f+y, -1.0f+z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f( 1.0f+x, -1.0f+y,  1.0f+z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-1.0f+x, -1.0f+y,  1.0f+z);	// Bottom Right
        // Right face
        GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f( 1.0f+x, -1.0f+y, -1.0f+z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f( 1.0f+x,  1.0f+y, -1.0f+z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f( 1.0f+x,  1.0f+y,  1.0f+z);	// Top Left
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f( 1.0f+x, -1.0f+y,  1.0f+z);	// Bottom Left
        // Left Face
        GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex3f(-1.0f, -1.0f+y, -1.0f+z);	// Bottom Left
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex3f(-1.0f, -1.0f+y,  1.0f+z);	// Bottom Right
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex3f(-1.0f,  1.0f+y,  1.0f+z);	// Top Right
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex3f(-1.0f,  1.0f+y, -1.0f+z);	// Top Left
        GL11.glEnd();
	}
	public void setCenter(int x,int y,int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
