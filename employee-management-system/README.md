# employee-management-system

Before:

- Copy env:

```
cd employee-management-system/src/main/resources
cp .env.example .env
```

- Install local postgres.


1. URL

```
http://localhost:8080
```

2. Welcome API

```
GET    /api/welcome
```
\
3. Employee API

```
GET       /api/employees # List
GET       /api/employees/{id}  # Detail
POST      /api/employees/create # Create
PATCH     /api/employees/{id}/update # Update
DELETE    /api/employees/{id}/delete  # Delete
GET       /api/employees/count  # Count
```

4. Empoyee View URL:

```
GET   /employees # View List
GET   /employees/{id} # View Detail
GET   /employees/{id}/edit # View Edit
POST  /employees/{id}/edit # View Update
GET   /employees/new # View New
POST  /employees/new # View Create
GET   /employees/{id}/delete # View Delete
```

5. Actuator API

```
GET    /actuator                    # List of all available endpoints
GET    /actuator/health             # Application health status
GET    /actuator/info               # Application information
GET    /actuator/metrics            # List of available metrics
GET    /actuator/metrics/{name}     # Specific metric details
GET    /actuator/env                # Environment properties information
GET    /actuator/configprops        # List of configuration properties
GET    /actuator/beans              # List of all Spring beans
GET    /actuator/mappings           # List of all request mappings
GET    /actuator/loggers            # List and configuration of loggers
POST   /actuator/loggers/{name}     # Change log level for specific logger
GET    /actuator/httptrace          # Information about recent HTTP requests
GET    /actuator/threaddump         # JVM thread dump
GET    /actuator/heapdump           # JVM heap dump (download file)
GET    /actuator/conditions         # List of auto-configuration conditions
```
