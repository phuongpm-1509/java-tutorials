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
DELETE    /api/employees/{id}/delete  #Delete
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
