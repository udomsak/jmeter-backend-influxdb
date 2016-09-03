package unixdev.jmeter.listeners;

import java.util.List;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.visualizers.backend.AbstractBackendListenerClient;
import org.apache.jmeter.visualizers.backend.BackendListenerContext;

import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import org.influxdb.InfluxDB.LogLevel;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;
import org.influxdb.InfluxDBFactory;
import org.influxdb.InfluxDB;





public class InfluxdbListener extends AbstractBackendListenerClient{

    
    //private static final String PARAMETER_NAME_INFLUXDB_PROTOCOL = "" ;
    private static final String PARAMETER_NAME_INFLUXDB_DATABASE = "jmeter";
    private static final String PARAMETER_NAME_INFLUXDB_HOST = "127.0.0.1";
    private static final String PARAMETER_NAME_INFLUXDB_PORT = "8086";
    private static final String PARAMETER_NAME_INFLUXDB_USER = "root";
    private static final String PARAMETER_NAME_INFLUXDB_PASSWORD = "root";
    private static final String PARAMETER_NAME_INFLUXDB_MEASUREMENT  = "influxdb.measurement";
    private static final String PARAMETER_NAME_INFLUXDB_TAG = "influxdb.tag"; 

	private static final Logger LOGGER = LoggingManager.getLoggerForClass();

	private static final Object LOCK = new Object();

	private boolean isInfluxDBServerPingOk;
	
	private InfluxDB influxDB;
	
    @Override
	public Arguments getDefaultParameters(){
        Arguments parameters = new Arguments();
        

        parameters.addArgument(PARAMETER_NAME_INFLUXDB_DATABASE, null);
        parameters.addArgument(PARAMETER_NAME_INFLUXDB_HOST, null);
        parameters.addArgument(PARAMETER_NAME_INFLUXDB_PORT, "9200");
        parameters.addArgument(PARAMETER_NAME_INFLUXDB_USER, null);
        parameters.addArgument(PARAMETER_NAME_INFLUXDB_PASSWORD, null);
        parameters.addArgument(PARAMETER_NAME_INFLUXDB_MEASUREMENT, "http");
        parameters.addArgument(PARAMETER_NAME_INFLUXDB_TAG, null);
        return parameters;

    }
    /*
    @Override
	public void setupTest(BackendListenerContext context) throws Exception {
    	this.influxDB = InfluxDBFactory.connect("http://" + PARAMETER_NAME_INFLUXDB_HOST + ":" + PARAMETER_NAME_INFLUXDB_PORT, PARAMETER_NAME_INFLUXDB_USER, PARAMETER_NAME_INFLUXDB_PASSWORD);
    	
    	boolean influxDBstarted = false;
    	
		do {
			Pong response;
			try {
				response = this.influxDB.ping();
				LOGGER.info(response.toString());
				if (!response.getVersion().equalsIgnoreCase("unknown")) {
					influxDBstarted = true;
                                        isInfluxDBServerPingOk = true;
				}
			} catch (Exception e) {
				// NOOP intentional
				LOGGER.error("InfluxDB server ping test: Failed");
                                isInfluxDBServerPingOk = false; 
				e.printStackTrace();
			}
			Thread.sleep(100L);
		} while (!influxDBstarted);
		this.influxDB.setLogLevel(LogLevel.FULL);
    	
    }
    */
    @Override
	public void teardownTest(BackendListenerContext context) throws Exception {
            LOGGER.info("End influxdb");
        }

    
	@Override
	public void handleSampleResults(List<SampleResult> sampleResults,
			BackendListenerContext context) {
       
            influxDB = InfluxDBFactory.connect("http://" + context.getParameter(PARAMETER_NAME_INFLUXDB_HOST)  
                    + ":" + context.getParameter(PARAMETER_NAME_INFLUXDB_PORT), 
                    context.getParameter(PARAMETER_NAME_INFLUXDB_USER), 
                    context.getParameter(PARAMETER_NAME_INFLUXDB_PASSWORD));
            boolean influxDBstarted = false;
    	
		do {
			Pong response;
			try {
                                
				response = influxDB.ping();
				LOGGER.info(response.toString());
				if (!response.getVersion().equalsIgnoreCase("unknown")) {
					influxDBstarted = true;
                                        isInfluxDBServerPingOk = true;
                                        LOGGER.info("==== InfluxDB is connected");
				}
			} catch (Exception e) {
				// NOOP intentional
				LOGGER.error("InfluxDB server ping test: Failed");
                                isInfluxDBServerPingOk = false; 
				e.printStackTrace();                        
			}
			
		} while (!influxDBstarted);
		influxDB.setLogLevel(LogLevel.FULL);
            
            synchronized(LOCK){
                
                
                influxDB.setLogLevel(LogLevel.FULL);
                for ( SampleResult sampleResult : sampleResults){
                
                        
                    LOGGER.info("latency: " + sampleResult.getLatency());
                
                    BatchPoints batchPoints = BatchPoints.database( context.getParameter(PARAMETER_NAME_INFLUXDB_DATABASE))
                            .tag("async","true")
                            .retentionPolicy("default")
                            .build();
                    Point  point_sample = Point
                            .measurement(context.getParameter(PARAMETER_NAME_INFLUXDB_MEASUREMENT))
                            .tag("atag", "test")
                            .addField("reponse_time",sampleResult.getTime())
                            .addField("latency", sampleResult.getLatency())
                            .addField("connect_time", sampleResult.getConnectTime())
                            .addField("idle_time", sampleResult.getIdleTime())
                            .addField("response_code",sampleResult.getResponseCode())
                            .addField("is_reponse_ok", sampleResult.isResponseCodeOK())
                            .addField("is_successfull", sampleResult.isSuccessful())
                            .addField("sample_count", sampleResult.getSampleCount())
                            .addField("error_count", sampleResult.getErrorCount())
                            .addField("header_size", sampleResult.getHeadersSize())
                            .addField("response_message",sampleResult.getResponseMessage())
                            .addField("body_size", sampleResult.getBodySize())
                            .addField("bytes",sampleResult.getBytes())
                            .build();
                    batchPoints.point(point_sample);
                    influxDB.write(batchPoints);
                
                }
            
            } // end block Synchronize 
		// TODO Auto-generated method stub
	
                
	}//end handleSampleResults 

}
