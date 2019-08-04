package com.bubble.application;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@ApplicationPath("/rest")
@Configuration
public class RestApplication extends ResourceConfig{
//	private static RelaxedPropertyResolver relaxedPropertyResolver;
//
//	private static final String ENV_SWAGGER = "logic.swagger.";
//	private static final String PROP_VERSION = "version";
//	private static final String PROP_HOST = "host";
//	private static final String PROP_BASE_PATH = "basePath";
//	private static final String PROP_DESCRIPTION = "description";
//	private static final String PROP_TITLE = "title";
//	private static final String PROP_LICENCE = "licence";
//	private static final String PROP_LICENCE_URL = "licenceUrl";
//	private static final String PROP_CONTACT = "contact";
//	private static final String PROP_TERMS_OF_SERVICE_URL = "termsOfServiceUrl";
//	private static final String PROP_RESOURCE_PACKAGE = "resourcePackage";
    public RestApplication() {
        // 注册JSON转换器
//        register(JacksonJsonProvider.class);
//
//        register(RestRequestFilter.class);
//
//        register(RestResponseFilter.class);
//
//        register(MultiPartFeature.class);
//
//        register(CacheFilterFactory.class);

//        packages("io.swagger.jersey.listing");

        packages("com.bubble.ws");

//        packages("com.qcs.configuration.ws");
//
//        packages("com.qcs.government.ws");
//
//        packages("com.qcs.activity.ws");
//
//        packages("com.qcs.inspection.ws");
//
//        packages("com.qcs.incident.ws");
//
//        packages("com.qcs.investigation.ws");
//
//		packages("com.qcs.observation.ws");
//
//        packages("com.sds.ws");
//
//        packages("com.quantum.training.ws");
//
//        packages("com.ehs.authorization.ws");
//
//        packages("com.ehs.regulations.ws");
//
//        packages("com.ehs.environment.ws");
//
//        packages("com.quantum.cspc.ws");
//
//        packages("com.nippon.ws");
//        
//        packages("com.ehs.govregulation.ws");

    }

//	private void configureSwagger() {
//		register(ApiListingResource.class);
//		register(SwaggerSerializers.class);
//		register(ReflectiveJaxrsScanner.class);
//
//		BeanConfig beanConfig = new BeanConfig();
//
//		if (relaxedPropertyResolver != null) {
//			beanConfig.setVersion(relaxedPropertyResolver.getProperty(PROP_VERSION, String.class, ""));
//			// beanConfig.setSchemes(new String[]{"http", "https"});
//			beanConfig.setHost(relaxedPropertyResolver.getProperty(PROP_HOST, String.class, ""));
//			beanConfig.setBasePath(relaxedPropertyResolver.getProperty(PROP_BASE_PATH, String.class, ""));
//
//			beanConfig.setDescription(relaxedPropertyResolver.getProperty(PROP_DESCRIPTION, String.class, ""));
//			beanConfig.setTitle(relaxedPropertyResolver.getProperty(PROP_TITLE, String.class, ""));
//			beanConfig.setLicense(relaxedPropertyResolver.getProperty(PROP_LICENCE, String.class, ""));
//			beanConfig.setLicenseUrl(relaxedPropertyResolver.getProperty(PROP_LICENCE_URL, String.class, ""));
//			beanConfig.setContact(relaxedPropertyResolver.getProperty(PROP_CONTACT, String.class, ""));
//			beanConfig.setTermsOfServiceUrl(
//					relaxedPropertyResolver.getProperty(PROP_TERMS_OF_SERVICE_URL, String.class, ""));
//
//			beanConfig.setResourcePackage(relaxedPropertyResolver.getProperty(PROP_RESOURCE_PACKAGE, String.class, ""));
//
//		}
//
//		beanConfig.setPrettyPrint(true);
//		beanConfig.setScan(true);
//	}

//	@Override
//	public void setEnvironment(Environment environment) {
//		relaxedPropertyResolver = new RelaxedPropertyResolver(environment, ENV_SWAGGER);
//		configureSwagger();
//	}
}