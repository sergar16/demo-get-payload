# GET + body payload

Run spring boot app using embeeded Tomcat container.

Demo project.
GET http request can have a payload, http spec. does not address this clearly.
This is up to vendor to provide support of request body or not.

Run embedded Tomcat:

``
$mvn spring-boot:run
``

Run embedded Jetty:

``
$mvn spring-boot:run
``

Test GET with payload:

``
curl -X GET \
  http://localhost:8080/demo \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
	"price": 20.55
   }'
``
