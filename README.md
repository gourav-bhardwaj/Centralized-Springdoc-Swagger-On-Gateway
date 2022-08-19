# Centralized Springdoc Swagger Documentation

Spring cloud gateway use as a single entry point or interaction point for all connected microservices so here in this example we centralize the swagger documentation of all microservices at one place using gateway.

## Points which we need to follow here

- Create a spring cloud gateway by using dependencies:
  - org.springframework.cloud:spring-cloud-starter-gateway
  - org.springframework.boot:spring-boot-starter-actuator
  - org.springframework.boot:spring-boot-starter-webflux
  - org.springdoc:springdoc-openapi-webflux-ui
  - org.springdoc:springdoc-openapi-webflux-core
  - org.springframework.boot:spring-boot-devtools
- Create other microservices with following dependencies:
  - org.springframework.boot:spring-boot-starter-web
  - org.springframework.boot:spring-boot-starter-actuator
  - org.springframework.boot:spring-boot-devtools
  - org.springframework.cloud:spring-cloud-starter-netflix-eureka-client
  - org.springdoc:springdoc-openapi-ui

## Add some code in gateway

```sh
@Hidden
@RestController
public class CommonController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/v3/api-docs/swagger-config")
	public Map<String, Object> v3swaggerConfigurations(ServerHttpRequest request) throws URISyntaxException {
		URI uri = request.getURI();
		URI url = new URI(uri.getScheme(), uri.getAuthority(), null, null, null);
		Map<String, Object> swaggerConfigMap = new LinkedHashMap<>();
		List<AbstractSwaggerUiConfigProperties.SwaggerUrl> swaggerUrls = new LinkedList<>();
		discoveryClient.getServices().forEach(System.out::println);
		discoveryClient.getServices().stream().filter(serviceName -> serviceName.endsWith("-service")).forEach(serviceName -> {
			String serviceExactName = serviceName.replaceAll("-service", "");
			swaggerUrls.add(new AbstractSwaggerUiConfigProperties.SwaggerUrl(serviceName, url + "/" + serviceExactName + "/v3/api-docs", serviceName));
		});
		swaggerConfigMap.put("urls", swaggerUrls);
		return swaggerConfigMap;
	}

}
```

## Add a specific property on gateway and all microservices's application.yml

``` sh
server:
  forward-headers-strategy: framework
```

> Note: If you forgot to specify this property then you will face CORS issue while calling APIs of all microservices from swagger UI.
