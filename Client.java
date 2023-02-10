public class Client{
  int balance;
  int id;

  //Metodo constructor;
  public Client(int id, int balance){
    this.id = id;
    this.balance = balance;
  }

//Comportamientos;
  public int check_Balance(){
    return this.balance;
  }

  public int whithdraw(int valor){
    this.balance -= valor;
    return this.balance;
  }

  public int upgrade_Balance(int valor){
    this.balance += valor;
    return this.balance;
  }
}