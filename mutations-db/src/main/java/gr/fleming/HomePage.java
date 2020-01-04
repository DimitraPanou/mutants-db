package gr.fleming;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import gr.fleming.pages.BasePage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

//		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here

	}
	
	@Override
	protected IModel<String> newPageTitle() {
		return Model.of("Menu");
	}
}
