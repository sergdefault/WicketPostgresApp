package com.tsymbaliuk.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import com.tsymbaliuk.entity.Task;

public class FormPage extends WebPage {
	
	public FormPage(){
		add(new FeedbackPanel("feadback"));
		Task task = new Task();
		Form form = new Form("form");
		TextField<String> description = new TextField<String>("string",new PropertyModel<String>(task, "description"));
		description.setRequired(true);
		description.add(new StringValidator(5, 10));
		TextField id = new TextField<Integer>("integer",new PropertyModel<Integer>(task, "id"));
		form.add(new Link<Void>("cancel"){
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
		form.add(new Button("accept"){
			@Override
			public void onSubmit() {
				super.onSubmit();
				System.out.println("description : "+ task.getDescription());
				System.out.println("id : "+ task.getId());
			}
		});
		form.add(description);
		form.add(id);
		add(form);
		add(new SamplePanel("panel"));
	}
}
