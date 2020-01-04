package gr.fleming;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import gr.fleming.pages.PersonPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see gr.fleming.Start#main(String[])
 */
public class WicketApplication extends WebApplication implements ApplicationContextAware
{
	
	private ApplicationContext applicationContext;
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
		mountPage("persons", PersonPage.class);
		mountPage("menu", HomePage.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public static WicketApplication get() {
		return (WicketApplication) WebApplication.get();
	}
	
	public <T> T getBean(Class<T> type) {
		return applicationContext.getBean(type);
	}
}
