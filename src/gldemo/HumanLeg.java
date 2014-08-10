package gldemo;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import glmodel.GL_Vector;

public class HumanLeg {
	/*
	 * width:1
	 * (-0.5 ,0,0.5) (0.5,0)
	 * 	P8	P7
	 * P5 P6
	 *  ______
	 * |	|
	 * |	|
	 * |	|Height:4	
	 * |	|
	 * |	|
	 * |	|
	 * ------
	 * 	P4	P3
	 * P1 P2
	 * (-0.5,-4,0.5) (0.5,-4,0.5)
	 */
	
	GL_Vector P1=new GL_Vector(-0.5f,-3f,0.5f);
	GL_Vector P2=new GL_Vector(0.5f,-3f,0.5f);
	GL_Vector P3=new GL_Vector(0.5f,-3f,-0.5f);
	GL_Vector P4=new GL_Vector(-0.5f,-3f,-0.5f);
	GL_Vector P5=new GL_Vector(-0.5f,0f,0.5f);
	GL_Vector P6=new GL_Vector(0.5f,0f,0.5f);
	GL_Vector P7=new GL_Vector(0.5f,0f,-0.5f);
	GL_Vector P8=new GL_Vector(-0.5f,0f,-0.5f);
	private int widht;
	private int height;
	private int thick;
	public GL_Vector Position ;
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
		 //GL11.glTranslatef(Position.x,Position.y,Position.z); // down a bit
		
		//λ��������ϵͳ
		//1��������������������
		//
		/*
		 * width:2
		 * ---------
		 * |	   |height:1
		 * -------
		 * 
		 */
		//����ת
		//��λ��
		GL11.glTranslatef(Position.x,Position.y,Position.z);
        GL11.glBegin(GL11.GL_QUADS);
        // Front Face
        
        GL11.glNormal3f( 0.0f, 0.0f, 1.0f);
        GL11.glTexCoord2f(0f, 0f); glVertex3fv(P1);	// Bottom Left ǰ����
        GL11.glTexCoord2f(1/16f, 0f);glVertex3fv(P2);	// Bottom Right ǰ����
        GL11.glTexCoord2f(1/16f, 3/8f);glVertex3fv(P6);	// Top Right ǰ����
        GL11.glTexCoord2f(0f, 3/8f); glVertex3fv(P5);	// Top Left	ǰ����
        // Back Face
        
        GL11.glNormal3f( 0.0f, 0.0f, -1.0f);
        GL11.glTexCoord2f(0f, 0f); glVertex3fv(P3);	// Bottom Left ������
        GL11.glTexCoord2f(1/16f, 0f); glVertex3fv(P4);	// Bottom Right ������
        GL11.glTexCoord2f(1/16f, 3/8f); glVertex3fv(P8);	// Top Right ������
        GL11.glTexCoord2f(0f, 3/8f);glVertex3fv(P7);	// Top Left ������
       
        // Top Face
        GL11.glNormal3f( 0.0f, 1.0f, 0.0f);
      
        GL11.glTexCoord2f(1/16f, 3/8f); glVertex3fv(P5);	// Bottom Left ǰ����
        GL11.glTexCoord2f(2/16f, 3/8f); glVertex3fv(P6);	// Bottom Right ǰ����
        GL11.glTexCoord2f(2/16f, 4/8f); glVertex3fv(P7);	// Top Right ������
        GL11.glTexCoord2f(1/16f, 4/8f); glVertex3fv(P8);	// Top Left ������
        // Bottom Face
        GL11.glNormal3f( 0.0f, -1.0f, 0.0f);
        GL11.glTexCoord2f(1/16f, 3/8f);glVertex3fv(P4);	// Top Right ������
        GL11.glTexCoord2f(2/16f, 3/8f); glVertex3fv(P3);	// Top Left ������
        GL11.glTexCoord2f(2/16f, 4/8f);glVertex3fv(P2);	// Bottom Left ǰ����
        GL11.glTexCoord2f(1/16f, 4/8f);glVertex3fv(P1);	// Bottom Right ǰ����
        // Right face
        GL11.glNormal3f( 1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0f, 0f); glVertex3fv(P2);	// Bottom Left ǰ����
        GL11.glTexCoord2f(1/16f, 0f);glVertex3fv(P3);	// Bottom Right ������
        GL11.glTexCoord2f(1/16f, 3/8f); glVertex3fv(P7);	// Top Right ������
        GL11.glTexCoord2f(0f, 3/8f);glVertex3fv(P6);	// Top Left ǰ����
      
        // Left Face
        GL11.glNormal3f( -1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0f, 0f); glVertex3fv(P4);	// Bottom Left ������
        GL11.glTexCoord2f(1/16f, 0f);glVertex3fv(P1);	// Bottom Right ǰ����
        GL11.glTexCoord2f(1/16f, 3/8f);glVertex3fv(P5);	// Top Right ǰ����
        GL11.glTexCoord2f(0f, 3/8f);glVertex3fv(P8);	// Top Leftǰ����
        GL11.glEnd();
    	GL11.glTranslatef(-Position.x,-Position.y,-Position.z);
	}
	
	public void glVertex3fv(GL_Vector p){
		GL11.glVertex3f(p.x,p.y,p.z);
	}
}
