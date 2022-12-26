package Calculator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import CalculatorService.*;
import NumberConventerService.NumberConverterService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private NumberConverterService service;

	static BundleContext getContext() {

		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		ServiceReference<NumberConverterService> serviceReference = context
				.getServiceReference(NumberConverterService.class);
		service = context.getService(serviceReference);
		CalculatorUI window = new CalculatorUI(service);
		window.setVisible(true);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;

		System.out.println("Calculator stoped...");
	}

}
