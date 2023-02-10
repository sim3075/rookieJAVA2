public class ATM{

//Atributos;
  int balance;
  int id;

  
//Método constructor;
  public ATM(int id, int balance){
    this.id = id;
    this.balance = balance;
  }

  
//Comportamientos;
  public void whithdraw_atm(int valor){
    this.balance -= valor;

  }

  public void update_Balance_atm(int valor){
    this.balance += valor;
    
    
  }
  
}