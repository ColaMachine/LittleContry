package gldemo;

import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;

import glapp.*;

/**
 * Run a bare-bones GLApp.  Draws one white triangle centered on screen.
 * <P>
 * GLApp initializes the LWJGL environment for OpenGL rendering,
 * ie. creates a window, sets the display mode, inits mouse and keyboard,
 * then runs a loop that calls draw().
 * <P>
 * napier at potatoland dot org
 */
public class GLApp_Demo_cube extends GLApp {
	
	/**
	 * Start the application.  run() calls setup(), handles mouse and keyboard input,
	 * calls render() in a loop.
	 */
    public static void main(String args[]) {
    	// create the app
    	GLApp_Demo_cube demo = new GLApp_Demo_cube();

    	// set title, window size
    	demo.window_title = "Hello World";
    	demo.displayWidth = 640;
    	demo.displayHeight = 480;

    	// start running: will call init(), setup(), draw(), mouse functions
    	demo.run();
    }

    /**
     * Initialize the scene.  Called by GLApp.run().  For now the default
     * settings will be fine, so no code here.
     */
    public void setup()
    {
//    	GL11.glViewport(-2, -2, 4, 4);
//    	GL11.glMatrixMode(GL11.GL_PROJECTION);
//    	GL11.glLoadIdentity();//将当前的用户坐标系的原点移到了屏幕中心：类似于一个复位操作..
//    	GLU.gluOrtho2D(-2f, -2f, 2f, 2f);//参数分别代表(左下角x坐标,右上角x坐标,左下角y坐标,右上角y坐标)——坐标全相对于窗口左下角--原点),
    	GL11.glPointSize(1);
    }

    /**
     * Render one frame.  Called by GLApp.run().
     */
    
    int[] A1={0,0,1};
    int[] A2={1,0,1};
    int[] A3={1,0,0};
    int[] A4={0,0,0};
    
    int[] A5={0,1,1};
    int[] A6={1,1,1};
    int[] A7={1,1,0};
    int[] A8={0,1,0};
    public void draw() {
    	  // Clear screen and depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        // Select The Modelview Matrix (controls model orientation)
       GL11.glMatrixMode(GL11.GL_MODELVIEW);
        // Reset the coordinate system to center of screen
        GL11.glLoadIdentity();
        // Place the viewpoint
        GLU.gluLookAt(
            5f, 5f, 10f,   // eye position (10 units in front of the origin)
            0f, 0f, 0f,    // target to look at (the origin)
            0f, 1f, 0f);   // which way is up (Y axis)//哪个方向槽上
        // draw a triangle centered around 0,0,0
        GL11.glBegin(GL11.GL_LINES);           // draw triangles
            GL11.glVertex3f(0,0,1);        //A1-A2
            GL11.glVertex3f(1,0,1);         
            
            GL11.glVertex3f(1,0,1);         //A2-A3
            GL11.glVertex3f(1,0,0);        
            
            GL11.glVertex3f(1,0,0);         // A3-A4
            GL11.glVertex3f(0,0,0);         
            
            GL11.glVertex3f(0,0,1);         // A4-A1
            GL11.glVertex3f(0,0,0);         
            
            GL11.glVertex3f(0,0,1);         // A1-A5
            GL11.glVertex3f(0,1,1);         
            
            GL11.glVertex3f(1,0,1);        // A2-A6
            GL11.glVertex3f(1,1,1);         
            
            GL11.glVertex3f(1,0,0);           // A3-A7
            GL11.glVertex3f(1,1,0);        
            
            GL11.glVertex3f(0,0,0);          // A4-A8
            GL11.glVertex3f(0,1,0);        
            
            GL11.glVertex3f(0,1,1);         // A5-A6
            GL11.glVertex3f(1,1,1);  
            
            GL11.glVertex3f(1,1,1);  		// A6-A7
            GL11.glVertex3f(1,1,0);         
            
            GL11.glVertex3f(1,1,0);         // A7-A8
            GL11.glVertex3f(0,1,0);        
            
            GL11.glVertex3f(0,1,0);          // A8-A5
            GL11.glVertex3f( 0,1,1);         
        GL11.glEnd();         
    }
}
