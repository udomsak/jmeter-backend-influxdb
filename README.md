# jmeter-backend-influxdb
Jmeter Backend Listener with InfluxDB 

- [English version cllick here](https://github.com/udomsak/jmeter-backend-influxdb/blob/master/README-EN.md)  

# Jmeter Backend InfluxDB 

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
- jmeter-influxdb-listener.jar จากนั้น นำไปวางไว้ใน Folder $JMETER/lib/ext
- เลือก Backend Listener
- รัน Test 

# หมายเหตุ 

- ผมไม่ใช่ โปรแกรมเมอร์  นี่เป็นการเขียนโดยแกะเอาจาก งานของคนอื่นมาเป็นแบบ แล้ว นำมาปรับปรุงเอาเอง

# CopyRight and License
- MIT License
