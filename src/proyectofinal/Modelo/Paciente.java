/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Modelo;



/**
 *
 * @author House
 */
public class Paciente {
    int id;
    String nombre;
    String apellido;
    String nombreusuario;
    String contrasena; 
    String sexo;
    int edad;
    double altura;
    double peso;
    
    double IMC;
    double glucosaIdeal= 100.00;//====el nivel de  glucosa ideal  va de los 72 a los 145 mg/gl
    double presionSIdeal;
    double presionDIdeal;
    double actividadIdeal;
    double aliemntacionIdeal;
    
   
    
    

    public Paciente() {
        
    }


    public Paciente( String nombre, String apellido, String nombreusuario, String contrasena, String sexo,int edad, double altura, double peso) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.edad=edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIMC() {
        return calcularIMC();
    }

    public double getGlucosaIdeal() {
        return glucosaIdeal;
    }

    public double getPresionSIdeal() {
        return calcularPS();
    }
    public double getPresionDIdeal() {
        return calcularPD();
    }

    public double getActividadIdeal() {
        return calcularAFI();
    }

    public double getAliemntacionIdeal() {
        return calcularCI();
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreusuario=" + nombreusuario + ", contrasena=" + contrasena + ", sexo=" + sexo + ", edad=" + edad + ", altura=" + altura + ", peso=" + peso + '}';
    }
    
     public double calcularPS(){
       double sistolica=0.0;
       if(this.sexo.equals("Masculino")){
        if(this.getEdad()>=16 && this.getEdad()<=18 ){
            sistolica=120.0;
       } else if(this.getEdad()>=19 && this.getEdad()<=24 ){
            sistolica=122.0;
       } else  if(this.getEdad()>=25 && this.getEdad()<=29 ){
            sistolica=123.5;
       } else   if(this.getEdad()>=30 && this.getEdad()<=39){
            sistolica=127.5;
       }
        else   if(this.getEdad()>=40 && this.getEdad()<=49){
            sistolica=130.0;
       }
         else   if(this.getEdad()>=50 && this.getEdad()<=59){
            sistolica=135.0;
       }
         else   if(this.getEdad()>=60){
            sistolica=137.5;
       }
   } else if(this.sexo.equals("Femenino")){
        if(this.getEdad()>=16 && this.getEdad()<=18 ){
            sistolica=115.0;
       } else if(this.getEdad()>=19 && this.getEdad()<=24 ){
            sistolica=115.0;
       } else  if(this.getEdad()>=25 && this.getEdad()<=29 ){
            sistolica=118.5;
       } else   if(this.getEdad()>=30 && this.getEdad()<=39){
            sistolica=122.0;
       }
        else   if(this.getEdad()>=40 && this.getEdad()<=49){
            sistolica=127.5;
       }
         else   if(this.getEdad()>=50 && this.getEdad()<=59){
            sistolica=132.5;
       }
         else   if(this.getEdad()>=60){
            sistolica=137.5;
       }
   }
   return sistolica;
   }
    public double calcularPD(){
       double diastolica=0.0;
       if(this.sexo.equals("Masculino")){
        if(this.getEdad()>=16 && this.getEdad()<=18 ){
            diastolica=73.0;
       } else if(this.getEdad()>=19 && this.getEdad()<=24 ){
            diastolica=75.0;
       } else  if(this.getEdad()>=25 && this.getEdad()<=29 ){
            diastolica=77.0;
       } else   if(this.getEdad()>=30 && this.getEdad()<=39){
            diastolica=80.0;
       }
        else   if(this.getEdad()>=40 && this.getEdad()<=49){
            diastolica=83.0;
       }
         else   if(this.getEdad()>=50 && this.getEdad()<=59){
            diastolica=84.0;
       }
         else   if(this.getEdad()>=60){
            diastolica=85.0;
       }
   } else if(this.sexo.equals("Femenino")){
        if(this.getEdad()>=16 && this.getEdad()<=18 ){
            diastolica=72.5;
       } else if(this.getEdad()>=19 && this.getEdad()<=24 ){
            diastolica=72.5;
       } else  if(this.getEdad()>=25 && this.getEdad()<=29 ){
            diastolica=73.0;
       } else   if(this.getEdad()>=30 && this.getEdad()<=39){
            diastolica=77.0;
       }
        else   if(this.getEdad()>=40 && this.getEdad()<=49){
            diastolica=80.5;
       }
         else   if(this.getEdad()>=50 && this.getEdad()<=59){
            diastolica=84.0;
       }
         else   if(this.getEdad()>=60){
            diastolica=85.0;
       }
   }
   return diastolica;
   }
     public double calcularAFI(){
  double ai=0.0;
  if(this.getEdad()>=5 && this.getEdad()<=17){
      ai= 1.0;
  }else if(this.getEdad()>=18 && this.getEdad()<=64){
        ai=0.36;
  }else if(this.getEdad()>=65){
        ai=0.07;
  }
  return ai;
  }
     public double calcularIMC(){
    double imc=0.0;
    imc= (this.getPeso())/((this.getAltura())*(this.getAltura()));
    return imc;
    }
      public Double calcularCI(){
    double calorias=0.0;
    if(this.sexo.equals("Masculino")){
        if(this.getEdad()>=1 && this.getEdad()<=3 ){
           calorias=this.peso*102; 
       } else if(this.getEdad()>=4 && this.getEdad()<=6 ){
           calorias=this.peso*90; 
       } else  if(this.getEdad()>=7 && this.getEdad()<=10){
           calorias=this.peso*70; 
       } else  if(this.getEdad()>=11 && this.getEdad()<14 ){
           calorias=this.peso*55; 
       }
        else   if(this.getEdad()>=15 && this.getEdad()<=18 ){
           calorias=this.peso*45; 
       }
         else   if(this.getEdad()>=19 && this.getEdad()<=24 ){
           calorias=this.peso*40; 
       }
         else  if(this.getEdad()>=25 && this.getEdad()<=50 ){
           calorias=this.peso*37; 
       }else  if(this.getEdad()>=51 && this.getEdad()<=200){
           calorias=this.peso*30; 
       }
   } else if(this.sexo.equals("Femenino")){
        if(this.getEdad()>=1 && this.getEdad()<=3 ){
           calorias=this.peso*102; 
       } else if(this.getEdad()>=4 && this.getEdad()<=6 ){
           calorias=this.peso*90; 
       } else  if(this.getEdad()>=7 && this.getEdad()<=10){
           calorias=this.peso*70; 
       } else  if(this.getEdad()>=11 && this.getEdad()<14 ){
           calorias=this.peso*47; 
       }
        else   if(this.getEdad()>=15 && this.getEdad()<=18 ){
           calorias=this.peso*40; 
       }
         else   if(this.getEdad()>=19 && this.getEdad()<=24 ){
           calorias=this.peso*38; 
       }
         else  if(this.getEdad()>=25 && this.getEdad()<=50 ){
           calorias=this.peso*36; 
       }else  if(this.getEdad()>=51 && this.getEdad()<=200){
           calorias=this.peso*30; 
       }
   } 
    return calorias;
    
    }
}
