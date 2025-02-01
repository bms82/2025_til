package per.msb.til.lessons.jan.wk4.multitenancy;
/**
 * MultiTenancy Example
 *
 * Application Tenant Context
 *
 * AppTenantContext class provides a mechanism to manage tenant context in a multi-tenant web application. It intercepts incoming requests, extracts tenant information from request headers, and sets the current tenant for the duration of the request processing. This allows different parts of the application to operate in the context of the appropriate tenant, facilitating tenant-specific behavior and data isolation.
 *
 *     This class implements the Filter interface. In Java Servlet programming, filters are used to perform pre-processing and post-processing tasks on requests and responses that pass through the web application. The Filter interface defines methods that a filter class must implement, including the doFilter() method, which is invoked to perform the actual filtering logic.
 *     LOGGER_TENANT_ID: This constant defines the name of the logger tenant ID, which is used for logging purposes.
 *     PRIVATE_TENANT_HEADER: This constant represents the name of the header in HTTP requests that carries information about the private tenant.
 *     DEFAULT_TENANT: This constant specifies the default tenant identifier to be used if no specific tenant is provided.
 *     The class defines a ThreadLocal variable named currentTenant. This variable stores the tenant identifier for the current thread. ThreadLocal allows storing data that is specific to each thread independently. In this case, it's used to maintain the tenant context across different parts of the application within the same thread.
 *     getCurrentTenant(): This static method retrieves the current tenant identifier from the currentTenant thread-local variable. If no tenant is set, it returns the default tenant identifier.
 *     setCurrentTenant(String tenant): This static method sets the current tenant identifier in the currentTenant thread-local variable. It also puts the tenant identifier in the logging context using Mapped Diagnostic Context (MDC) for logging purposes.
 *     clear(): This static method clears the current tenant identifier from the currentTenant thread-local variable and clears the MDC context.
 *     This method is required to implement the Filter interface. It intercepts incoming requests and allows processing before and after the request is forwarded to the servlet or other filters in the chain.
 *     It extracts the private tenant identifier from the HTTP request header (X-PrivateTenant) if present and sets it as the current tenant using setCurrentTenant() method.
 *     It then passes the request and response objects to the next filter in the chain or the servlet for further processing by invoking chain.doFilter(request, response)
 *
 *
 * Hibernate Configuration
 *
 * HibernateConfig configuration class sets up Hibernate as the JPA provider within the Spring application context. It configures the EntityManagerFactory with the necessary properties, including multi-tenancy related settings, allowing the application to interact with the database using Hibernate's ORM capabilities.
 *
 *     This method defines a bean of type JpaVendorAdapter, which is required for configuring JPA properties specific to the chosen JPA implementation. In this case, it returns a HibernateJpaVendorAdapter, indicating that Hibernate is being used as the JPA provider.
 *     This method defines a bean of type LocalContainerEntityManagerFactoryBean, which is responsible for creating and configuring an EntityManagerFactory. The EntityManagerFactory is the core interface for creating EntityManager instances in JPA applications.
 *     It takes parameters dataSource, multiTenantConnectionProviderImpl, and currentTenantIdentifierResolverImpl, which are injected by the Spring container.
 *     It creates a HashMap to hold JPA properties, copies properties from jpaProperties, and adds multi-tenancy related properties such as MULTI_TENANT_CONNECTION_PROVIDER and MULTI_TENANT_IDENTIFIER_RESOLVER.
 *     Then, it configures the LocalContainerEntityManagerFactoryBean instance with the data source, packages to scan for entity classes, JPA vendor adapter, and the map of JPA properties.
 *     Finally, it returns the configured LocalContainerEntityManagerFactoryBean.
 *     em.setPackagesToScan("com.xocayev.multitanancy.demoapp*"): This line specifies the packages to scan for JPA entities. In this example, it scans the com.xocayev.multitanancy.demoapp package and its sub-packages for entity classes.
 *
 *
 * Multitenacy Connection configuration
 *
 *     The constructor injects a DataSource instance, which is used to obtain database connections.
 *     getAnyConnection(): This method is responsible for retrieving a database connection from the DataSource. It's used to obtain a connection when no specific tenant identifier is provided.
 *     releaseAnyConnection(Connection connection): This method releases the provided database connection.
 *     getConnection(String tenantIdentifier): This method is called to obtain a database connection for a specific tenant. It first retrieves a connection using getAnyConnection(), sets the schema (or database) to the specified tenant identifier, and returns the connection.
 *     releaseConnection(String tenantIdentifier, Connection connection): This method is called to release a database connection associated with a specific tenant. It resets the schema to a default value (in this case, "public") and releases the connection.
 *     supportsAggressiveRelease(): Indicates whether this connection provider supports aggressive release of database connections.
 *     isUnwrappableAs(Class aClass): Indicates whether this connection provider can be unwrapped as the specified class.
 *     unwrap(Class<T> aClass): Unwraps this connection provider as the specified class if possible.
 *     The class utilizes a logger from SLF4J (Simple Logging Facade for Java) for logging connection-related activities such as obtaining and releasing connections.
 *     The class uses the setSchema() method on the Connection object to set the database schema for a particular tenant. This ensures that each tenant's data is isolated within its own schema in the database.
 *
 * Overall, MultiTenantConnectionProviderImpl is responsible for providing database connections with appropriate schema settings based on tenant identifiers in a multi-tenant Hibernate application. It enables the application to interact with tenant-specific data while maintaining data isolation and security between tenants.
 *
 *
 * Current Tenant Identification
 *
 * The CurrentTenantIdentifierResolver class is typically used in multi-tenant applications. In a multi-tenant architecture, a single instance of an application serves multiple tenants, where each tenant may have its own data, configuration, and access privileges.
 *
 * This class is part of the Hibernate framework, which is an Object-Relational Mapping (ORM) library for Java. In Hibernate, the CurrentTenantIdentifierResolver interface provides a way to dynamically determine the identifier of the current tenant during runtime. The identifier could be based on various factors such as a session attribute, a request parameter, or any other context-specific information.
 *
 * When implementing the CurrentTenantIdentifierResolver, you need to override the resolveCurrentTenantIdentifier() method, which should return the identifier of the current tenant. Hibernate uses this method to determine which database schema or connection pool to use for the current tenant's data operations.
 *
 * In summary, the CurrentTenantIdentifierResolver class plays a crucial role in multi-tenant Hibernate applications by dynamically resolving the current tenant identifier, thereby enabling the application to serve multiple tenants with isolation and efficiency.
 *
 *
 *
 *
 */