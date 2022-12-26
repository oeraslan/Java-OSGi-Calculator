package numberconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import NumberConventerService.NumberConverterService;
import NumberConventerService.NumberConverterServiceImpl;


public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<NumberConverterService> serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		NumberConverterService service = new NumberConverterServiceImpl();
		serviceRegistration = context.registerService(NumberConverterService.class, service, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		serviceRegistration.unregister();
		System.out.println("NumberConverterService stoped...");
	}

}
