package gr.fleming.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import gr.fleming.services.Service;

public abstract class TablePage<T extends Serializable> extends BasePage {
	
	private Form<Void> form;
	protected TextField<String> filter;
	private AjaxButton submit;
	private DataTable<T, String> table;

	public TablePage() {
		super();

		form = new Form<Void>("form") {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisibilityAllowed(hasSearchCriteria());
			}
		};
		add(form);
		
		filter = new TextField<String>("filter", Model.of((String) null));
		filter.setLabel(Model.of("Criterion"));
		form.add(filter);
		
		submit = new AjaxButton("submit", form) {
			protected void onSubmit(AjaxRequestTarget target) {
				table.setCurrentPage(0);
				target.add(table);
			}
		};
		form.add(submit);
		
		SortableDataProvider<T, String> provider = new SortableDataProvider<T,String>() {

			public Iterator<? extends T> iterator(long first, long count) {
				return getService().search((int)first,(int) count, filter.getModelObject()).iterator();
			}

			public long size() {
				return getService().searchCount(filter.getModelObject());
			}

			public IModel<T> model(T object) {
				return Model.of(object);
			}
			
		};
				
		table = new DataTable<T, String> ("table", getColumns()  , provider, 1);
		table.addTopToolbar(new HeadersToolbar<String>(table, provider));
		table.addBottomToolbar(new NoRecordsToolbar(table));
		table.addBottomToolbar(new NavigationToolbar(table));
		table.setOutputMarkupId(true);
		add(table);
		
	}

//	public TablePage(IModel<?> model) {
//		super(model);
//	}
//
//	public TablePage(PageParameters parameters) {
//		super(parameters);
//	}
	
	protected boolean hasSearchCriteria() {
		return true;
	}
	
	protected abstract Service<T> getService();
	
	protected abstract List<IColumn<T, String>> getColumns();

}
