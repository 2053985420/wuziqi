package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.junit.jupiter.api.Test;

import wuziqi.GoBangframe;

public class frameListenerTest {
	@Test
	void testmouseClicked() throws InterruptedException, AWTException {
		GoBangframe gf = new GoBangframe();
		gf.initUI();
		Robot robot=new Robot();
		robot.delay(1000);
		robot.mouseMove(1075, 130);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		for(int i=0;i<9;i++) {
			if(i%2==0) {
				robot.mouseMove(550+i/2*40, 370);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(1000);
			}
			else {
				robot.mouseMove(590+(i-1)/2*40, 330);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(1000);
			}
		}
		robot.mouseMove(757, 436);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);
        
     
        robot.mouseMove(1075, 130);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);
        for(int i=0;i<10;i++) {
			if(i%2==0) {
				robot.mouseMove(510+i/2*80, 360);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(1000);
			}
			else {
				robot.mouseMove(510+(i-1)/2*40, 320);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.delay(1000);
			}
		}
        robot.mouseMove(757, 436);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);
        
    
        robot.mouseMove(1075, 130);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);
        robot.mouseMove(757, 436);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);
		robot.mouseMove(757, 436);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1000);
		robot.mouseMove(757, 436);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}

}
