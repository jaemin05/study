void setup(){
  Serial.begin(9600);
  pinMode(8, OUTPUT);
}
void loop() {
    while (Serial.available() > 0){
      char c = Serial.read();
      if(c=='1'){
        digitalWrite(8, HIGH);
        delay(1000);
        digitalWrite(8, LOW);
      }
      else if(c=='2'){
        digitalWrite(8, HIGH);
        delay(250);
        digitalWrite(8,LOW);
        delay(250);
        digitalWrite(8, HIGH);
        delay(250);
        digitalWrite(8,LOW);
        delay(250);
        digitalWrite(8, HIGH);
        delay(250);
        digitalWrite(8,LOW);
        delay(250);
        digitalWrite(8, HIGH);
        delay(250);
        digitalWrite(8,LOW);
        delay(250); 
        digitalWrite(8,HIGH);
        delay(250);
        digitalWrite(8,LOW);
      }
   }
}
