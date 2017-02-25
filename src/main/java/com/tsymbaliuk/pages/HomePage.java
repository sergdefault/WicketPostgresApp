package com.tsymbaliuk.pages;



import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private Integer counter = 0;
	
	public HomePage(final PageParameters parameters) {
		super(parameters);
		IModel countermodel = new Model<Integer>(){
			@Override
			public Integer getObject() {
				// TODO Auto-generated method stub
				return counter;
			}
			
		};
		
		add(new Link<Void>("increment"){

			@Override
			public void onClick() {
				counter++;
			}
		});
		add(new Link<Void>("decrement"){


			@Override
			public void onClick() {
				counter--;
			}
		});
		add(new Link<Void>("refresh"){
			@Override
			public void onClick() {
				counter=0;
			}
		});
		add(new Link<Void>("go"){
			@Override
			public void onClick() {
				setResponsePage(ShowList.class);
			}
		});
		add(new Link<Void>("pagewithform"){
			@Override
			public void onClick() {
				setResponsePage(FormPage.class);
			}
		});	
		add(new Label("counter", countermodel));
		

	}

}
