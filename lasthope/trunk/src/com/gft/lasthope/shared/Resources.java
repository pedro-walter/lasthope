package com.gft.lasthope.shared;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

	@Source("/images/warrior.png")
	ImageResource warrior();
	
	@Source("/images/mage.png")
	ImageResource mage();
	
	@Source("/images/archer.png")
	ImageResource archer();
	
	@Source("/images/rogue.png")
	ImageResource rogue();

}
