class Prostokat
{
   double dlugosc;
   double szerokosc;
   
   Prostokat()            
   {                      
      this.dlugosc=0.0;   
      this.szerokosc=0.0; 
   }                      
   
   Prostokat(double dlugosc,double szerokosc)  
   {                                          
      this.dlugosc=dlugosc;                   
      this.szerokosc=szerokosc;               
   }                                          
   
   double pole()                
   {                            
      return dlugosc*szerokosc; 
   }                            
}