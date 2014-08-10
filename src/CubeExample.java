import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class CubeExample {
	static  float[][] vertex_list=
	 {
	    {-0.5f, -0.5f, -0.5f},
	    { 0.5f, -0.5f, -0.5f},
	    {-0.5f,  0.5f, -0.5f},
	    { 0.5f,  0.5f, -0.5f},
	    {-0.5f, -0.5f,  0.5f},
	     {0.5f, -0.5f,  0.5f},
	    {-0.5f,  0.5f,  0.5f},
	    { 0.5f,  0.5f,  0.5f}
	    };
	static  int[][] index_list=
		 {
		{0, 2, 3, 1},
			{ 0, 4, 6, 2},
			{ 0, 1, 5, 4},
	    {4, 5, 7, 6},
	    { 1, 3, 7, 5},
	    {2, 6, 7, 3}
		    };
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
		//GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		while (!Display.isCloseRequested()) {
			// Clear the screen and depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			// set the color of the quad (R,G,B,A)
			GL11.glColor3f(0.5f, 0.5f, 1.0f);

			// draw quad
			GL11.glBegin(GL11.GL_QUADS);
			
			
			for(int i=0; i<6; ++i)         // 有六个面，循环六次
			    for(int j=0; j<4; ++j)  
			    		GL11.glVertex3f(vertex_list[index_list[i][j]][0],
			    				vertex_list[index_list[i][j]][1],
			    				vertex_list[index_list[i][j]][2]);
			GL11.glEnd();
			Display.update();
		}

		Display.destroy();
	}

	public static void main(String[] argv) {
		CubeExample quadExample = new CubeExample();
		quadExample.start();
	}
}
