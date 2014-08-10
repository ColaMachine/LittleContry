package gldemo;

import org.lwjgl.opengl.GL11;

import glmodel.GL_Vector;

public class HumanBody {
	private int widht;
	private int height;
	private int thick;
	public GL_Vector Position ;
	//���������λ��Ӧ����ƨ������ ����
	GL_Vector P1=new GL_Vector(-1f,-4f,1f);
	GL_Vector P2=new GL_Vector(1f,-4f,1f);
	GL_Vector P3=new GL_Vector(1f,-4f,-1f);
	GL_Vector P4=new GL_Vector(-1f,-4f,-1f);
	GL_Vector P5=new GL_Vector(-1f,0f,1f);
	GL_Vector P6=new GL_Vector(1f,0f,1f);
	GL_Vector P7=new GL_Vector(1f,0f,-1f);
	GL_Vector P8=new GL_Vector(-1f,0f,-1f);
	
	public void setHead(float posx, float posy, float posz,
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
	}
	public void render(){

        GL11.glBegin(GL11.GL_QUADS);
        // Front Face
        GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
        GL11.glTexCoord2f(5/16f, 0f); GL11.glVertex3f(-1.0f+Position.x, -1.5f+Position.y,  0.5f+Position.z);	// Bottom Left ǰ����
        GL11.glTexCoord2f(7/16f, 0f); GL11.glVertex3f( 1.0f+Position.x, -1.5f+Position.y,  0.5f+Position.z);	// Bottom Right ǰ����
        GL11.glTexCoord2f(7/16f, 3/8f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y,  0.5f+Position.z);	// Top Right ǰ����
        GL11.glTexCoord2f(5/16f, 3/8f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y,  0.5f+Position.z);	// Top Left	ǰ����
        // Back Face
        GL11.glNormal3f( 0.0f, 0.0f, -1.0f);
        GL11.glTexCoord2f(4/8f,0f); GL11.glVertex3f(-1.0f+Position.x, -1.5f+Position.y, -0.5f+Position.z);	// Bottom Right ������
        GL11.glTexCoord2f(5/8f, 0f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y, -0.5f+Position.z);	// Top Right ������
        GL11.glTexCoord2f(5/8f, 3/8f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y, -0.5f+Position.z);	// Top Left ������
        GL11.glTexCoord2f(4/8f,3/8f); GL11.glVertex3f( 1.0f+Position.x, -1.5f+Position.y, -0.5f+Position.z);	// Bottom Left ������
        // Top Face
        GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
        GL11.glTexCoord2f(1/8f, 3/4f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y, -0.5f+Position.z);	// Top Left 
        GL11.glTexCoord2f(2/8f, 3/4f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y,  0.5f+Position.z);	// Bottom Left
        GL11.glTexCoord2f(2/8f, 1f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y,  0.5f+Position.z);	// Bottom Right
        GL11.glTexCoord2f(1/8f, 1f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y, -0.5f+Position.z);	// Top Right
        // Bottom Face
        GL11.glNormal3f( 0.0f, -1.0f, 0.0f);
        GL11.glTexCoord2f(2/8f, 3/4f); GL11.glVertex3f(-1.0f+Position.x, -1.5f+Position.y, -0.5f+Position.z);	// Top Right ������
        GL11.glTexCoord2f(3/8f, 3/4f); GL11.glVertex3f( 1.0f+Position.x, -1.5f+Position.y, -0.5f+Position.z);	// Top Left ������
        GL11.glTexCoord2f(3/8f, 1f); GL11.glVertex3f( 1.0f+Position.x, -1.5f+Position.y,  0.5f+Position.z);	// Bottom Left ǰ����
        GL11.glTexCoord2f(2/8f, 1f); GL11.glVertex3f(-1.0f+Position.x, -1.5f+Position.y,  0.5f+Position.z);	// Bottom Right ǰ����
        // Right face
        GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(3/8f, 2/4f); GL11.glVertex3f( 1.0f+Position.x, -1.5f+Position.y, -0.5f+Position.z);	// Bottom Right ������
        GL11.glTexCoord2f(3/8f,3/4f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y, -0.5f+Position.z);	// Top Right ������
        GL11.glTexCoord2f(2/8f, 3/4f); GL11.glVertex3f( 1.0f+Position.x,  1.0f+Position.y,  0.5f+Position.z);	// Top Left ǰ����
        GL11.glTexCoord2f(2/8f, 2/4f); GL11.glVertex3f( 1.0f+Position.x, -1.5f+Position.y,  0.5f+Position.z);	// Bottom Left ǰ����
        // Left Face
        GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0f, 2/4f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y, -0.5f+Position.z);	// Bottom Left ������
        GL11.glTexCoord2f(1/8f, 2/4f); GL11.glVertex3f(-1.0f+Position.x, -1.0f+Position.y,  0.5f+Position.z);	// Bottom Right ǰ����
        GL11.glTexCoord2f(1/8f, 3/4f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y,  0.5f+Position.z);	// Top Right ǰ����
        GL11.glTexCoord2f(0f, 3/4f); GL11.glVertex3f(-1.0f+Position.x,  1.0f+Position.y, -0.5f+Position.z);	// Top Left
        GL11.glEnd();
	
	}
}
