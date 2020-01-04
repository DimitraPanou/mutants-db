package gr.fleming.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import gr.fleming.services.PersonService;

public class BasePage extends WebPage {
	
	public BasePage() {
		super();
	}

	public BasePage(IModel<?> model) {
		super(model);
	}

	public BasePage(PageParameters parameters) {
		super(parameters);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Label("page-title", newPageTitle()));
		add(new BookmarkablePageLink<Void>("persons", PersonPage.class));
//		add(new BookmarkablePageLink<Void>("persons", PersonPage.class, new PageParameters ...));
	}
	
	protected IModel<String> newPageTitle() {
		return Model.of("Page Title");
	}
	
}
