I made this project in my Computer Networking Course.
I used Socket Programming in Java and Arduino in this project.


To play this project you need a server PC which will be connect with your circuit. And it must be connected 
with ISP. And you will run the e_electricity_server_java program in this PC. And Upload the arduino code in 
an arduino than connect it with the server PC. Go to Device and Printers from Start menu the see the COM port 
for the arduino and enter the port number in the java server program. and after that wait a while for client connection.


Runt the client program in client PC and enter the server PC IP address amnd then submit and wait for the connection. Client PC
must be connected with ISP. Once the connection established then you can send on or off signal from client to server pc via the java program.
Server will receive the command and it(Server) will send this command to arduino via USB cable and Arduino program receive the command and it will 
give output at Digital Pin 12 as a HIGH or LOW Signal. So you can use a 5v Relay to switch the electric 220v-230v appliances. 


You can use this project in android also for fully automation of Home Electric Appliances.
