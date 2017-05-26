void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(12,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  while(Serial.available())
  {
    char ch=Serial.read();
    Serial.println(ch);
    if(ch=='H')
      digitalWrite(12,1);
    else if(ch=='L')
      digitalWrite(12,0);
    
  }
}
