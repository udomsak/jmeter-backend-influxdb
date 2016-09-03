# jmeter-backend-influxdb
Jmeter Backend Listener with InfluxDB 

- [English version cllick here](https://github.com/udomsak/jmeter-backend-influxdb/blob/master/README-EN.md)  

# Jmeter Backend Listener InfluxDB 

เป็น Jmeter Backend Listener plugin สามารถ ส่งค่า metric ซึ่งเป็น Jmeter statistic ตรงไปยัง InfluxDB โดยตรงได้เลย ซึ่งสะดวกต่อการ monitor และ การจัดเก็บ  ผลของการทดสอบ Load-test ไว้ดูทีหลังได้ 

![alt tag](https://github.com/udomsak/jmeter-backend-influxdb/blob/master/misc/result_on_influxdb.jpg)

## ค่าที่ส่งเข้าไป 

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

# สภาพแวดล้อมการพัฒนา 

- NetBean 8.1.
- Java OpenJDK 7.
- influxdb-java client libery.

# ดาวน์โหลด และ ติดตั้ง 
- ดาวน์โหลด jmeter-influxdb-listener.jar จากนั้น นำไปวางไว้ใน Folder $JMETER/lib/ext
- เลือก Backend Listener

![alt tag](https://github.com/udomsak/jmeter-backend-influxdb/blob/master/misc/select-backend-ltn.jpg)

- รัน Test 

# Dependencies library 

- guava-18.0.jar 
- okhttp-2.7.5.jar
- gson-2.3.1.jar
- okio-1.6.0.jar
- retrofit-1.9.0.jar
- influxdb-java-2.1-SNAPSHOT.jar ( build เอง ) 

# หมายเหตุ 

- ผมไม่ใช่ โปรแกรมเมอร์  นี่เป็นการเขียนโดยแกะเอาจาก งานของคนอื่นมาเป็นแบบ แล้ว นำมาปรับปรุงเอาเอง
- please help to contribute. :) 
# CopyRight and License
- MIT License
