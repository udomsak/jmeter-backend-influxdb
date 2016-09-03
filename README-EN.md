# jmeter-backend-influxdb
Jmeter Backend Listener with InfluxDB 

- English version cllick here 

# Jmeter Backend InfluxDB 

This is Jmeter Backend Listener plugin that can send test statistic ( HTTP ) direct to InfluxDB database that you can monitor your test result later with grafana.  

## Test statistic metric

- body_size	
- bytes	
- connect_time	
- error_count	
- header_size
- idle_time
- is_reponse_ok	
- is_successfull
- latency
- reponse_time
- response_code
- response_message
- sample_count 

# Development environment. 

- NetBean 8.1.
- Java OpenJDK 7.
- influxdb-java client libery.

# Downoad and Install.
- jmeter-influxdb-listener.jar put on $JMETER/lib/ext folder.
- select Backend Listener
- run Test 

# NOTE 

- I am not programmer ( I'm SysOps ) this is a dirty hack if you have an idea or see something wrong please help me to contribute. 
