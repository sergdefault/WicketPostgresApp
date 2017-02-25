package com.tsymbaliuk.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class SamplePanel extends Panel {

	public SamplePanel(String id) {
		super(id);
		add(new Label("label", "This is panel"));	
	}
}
