package gr.fleming.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import gr.fleming.WicketApplication;
import gr.fleming.domain.Person;
import gr.fleming.services.PersonService;
import gr.fleming.services.Service;

public class PersonPage extends TablePage<Person> {

	private PersonService personService = WicketApplication.get().getBean(PersonService.class);

	@Override
	protected List<IColumn<Person, String>> getColumns() {
		List<IColumn<Person, String>> columns = new ArrayList<IColumn<Person, String>>();
		columns.add(new PropertyColumn<Person, String>(Model.of("Name"), "name"));
		columns.add(new PropertyColumn<Person, String>(Model.of("Parent Name"), "parent.name"));
		return columns;
	}
	
	@Override
	protected IModel<String> newPageTitle() {
		return Model.of("Persons");
	}

	@Override
	protected PersonService getService() {
		return personService;
	}

}
