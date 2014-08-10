
import org.lwjgl.LWJGLException;

import org.lwjgl.opengl.Display;

import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class LinesExample {

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		// init OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		while (!Display.isCloseRequested()) {
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			GL11.glColor3f(1.0f, 1.0f, 1.0f);
			GL11.glEnable(GL11.GL_LINE_STIPPLE);
			// Clear the screen and depth buffer
			{
			
			}
			
			
			GL11.glLineStipple(1, (short) 0x0101);

			drawOneLine(50.0f, 100.0f, 150.0f, 100.0f);
			
			GL11.glLineStipple(1, (short)0x00FF);
			drawOneLine(150.0f, 100.0f,250.0f, 100.0f);
			
			GL11.glLineStipple(1, (short)0x1C47);
			drawOneLine(250.0f, 100.0f,350.0f, 100.0f);
			/*
			 * 
			 * 
			GL11.glLineStipple(1, (short)0x1C47);
			drawOneLine(250.0f, 125.0f,350.0f, 125.0f);
			
			GL11.glLineWidth(5);
			
			GL11.glLineStipple(1, (short) 0x0101);

			drawOneLine(50.0f, 100.0f, 150.0f, 100.0f);
			
			GL11.glLineStipple(1, (short)0x00FF);
			drawOneLine(150.0f, 100.0f,250.0f, 100.0f);
			
			GL11.glLineStipple(1, (short)0x1C47);
			drawOneLine(250.0f, 100.0f,350.0f, 100.0f);*/
			
	
			GL11.glDisable(GL11.GL_LINE_STIPPLE);
		
			try {Display.update();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		Display.destroy();
	}
	 public void drawOneLine(float x1, float y1,float x2,float y2){
	    	GL11.glBegin(GL11.GL_LINES);
	    	GL11.glVertex2f(x1,y1);
	    	GL11.glVertex2f(x2,y2);
	    	GL11.glEnd();
	    }
	public static void main(String[] argv) {
		LinesExample quadExample = new LinesExample();
		quadExample.start();
	}
}
