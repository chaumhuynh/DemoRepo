package com.cogmento.qa.util;

import com.cogmento.qa.base.CogmentoTestBase;

public class TestUtil extends CogmentoTestBase{

	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT = 10;
	
	//switch to frame is a common method
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
}
