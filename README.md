# NOTE.
This project i use some code from someone on the internet (forgot about link refer sorry). i not wrote all by my self. 

# jmeter-backend-influxdb
Simple Jmeter Backend Listener with InfluxDB

![alt tag](https://github.com/udomsak/jmeter-backend-influxdb/blob/master/misc/unixdev-logo-web-h122.png)

- [English version cllick here](https://github.com/udomsak/jmeter-backend-influxdb/blob/master/README-EN.md)  
- This is utility use at Unixdev, Co,Ltd. http://www.unixdev.co.th ( Thai lang. ) 

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
- ดาวน์โหลด `file `ทั้งหมดใน folder artifact จากนั้น นำไปวางไว้ใน Folder $JMETER/lib/ext
- ถ้า build เองจะติดปัญหาเรื่อง dependencies class ( jar file ) ** TODO 
- เลือก Backend Listener

![alt tag](https://github.com/udomsak/jmeter-backend-influxdb/blob/master/misc/select-backend-ltn.jpg)

- รัน Test 

# Dependencies library 

ขั้นตอนการ build  influxDB-java จะใช้ dependencies สามสี่ตัวนี้ สิ่งที่ผมทำและติดปัญหาอยู่ตอนนี้ ไม่แน่ใจว่าจะ build `ยังไงถึงจะถูกต้อง ทางแก้ของผมตอนนี้ คือทำการ copy jar file ข้างล่างนี้ไป folder lib/ext `ทั้งหมด  

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
