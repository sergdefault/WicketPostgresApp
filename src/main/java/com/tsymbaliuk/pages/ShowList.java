package com.tsymbaliuk.pages;


import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.tsymbaliuk.dao.TaskDAO;
import com.tsymbaliuk.entity.Task;

public class ShowList extends WebPage {

	@SpringBean
	private TaskDAO dao;

	private static final long serialVersionUID = 1L;

	public ShowList(final PageParameters pageParameters) {
		PageableListView<?> listViev = new PageableListView<Task>("tasks",dao.getAll(),5) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem item) {
			Task task = (Task) item.getModelObject();
			item.add(new Label("id",task.getId()));
			item.add(new Label("description",task.getDescription()));
			item.add(new Link<Task>("delete", item.getModel()){
				@Override
				public void onClick() {
				  Task selected = (Task) getModelObject();
				  dao.deleteById(selected.getId());
				}	
			});
		  }
		};
		
		add(listViev);
		add(new AjaxPagingNavigator("navigator", listViev));
	}
}
