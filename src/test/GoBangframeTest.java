package test;

import static org.junit.Assert.assertThat;

import java.io.Console;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import wuziqi.GoBangframe;

class GoBangframeTest {
	@Test
	void testInitUI() throws InterruptedException {
		GoBangframe gf = new GoBangframe();
		gf.initUI();
		Thread.sleep(10000);
	}
	@Test
	void testPopUp() {
		GoBangframe gf = new GoBangframe();
		gf.PopUp("test");
	}
	@Ignore
	@Test
	void testPaintGraphics() {
		//GoBangframe gf = new GoBangframe();
		//Graphics g = gf.getGraphics();
	}

}
