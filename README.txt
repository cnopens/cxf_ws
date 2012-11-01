
generate database domain objects from config file in src/main/resources/generatorConfig.xml with

	mkdir -p MBGTestProject/src
	mvn mybatis-generator:generate

Then copy the generated files in MBGTestProject to the correct location.

start jetty with 

	mvn clean package jetty:run


run project cxf_client with 

	mvn clean package exec:java

to test client side of web service

wsdl location with jetty running is

	http://localhost:8080/cxf_holiday_service/hrService?wsdl
