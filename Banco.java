//paquetes;
import java.util.Scanner;


//Clase
public class Banco{
  //Atributos;
  Client[] client_list = {new Client(123, 500000), new Client(122, 30000)};
  ATM[] atm_list = {new ATM(11, 100000000)};


//Comportamientos;
  public void welcome(){
    Scanner input = new Scanner(System.in);
    System.out.println("Bienvenido al banco UdemBank");
    System.out.println("Ingrese su id: ");
    int id = input.nextInt();


    for(int i = 0; i<client_list.length; i++){
      if(client_list[i].id == id){
        ATM atm = atm_list[0];
        Client cliente = client_list[i];
        System.out.println("Elija una opción");
        System.out.println("(1) Ver su dinero actual");
        System.out.println("(2) Retirar su dinero");
        System.out.println("(3) Actualizar saldo");
        System.out.println("Ingrese respuesta: ");
        int respuesta = input.nextInt();

          

        switch(respuesta){
          case 1:
            System.out.println("Su dinero actual es: "+cliente.check_Balance());
            break;
            
          case 2:
            System.out.println("Ingrese la cantidad de dinero a retirar: ");
            int valor = input.nextInt();
            System.out.println("Saldo actualizado: "+cliente.whithdraw(valor));
            atm.whithdraw_atm(valor);
            break;
            
          case 3:
            System.out.println("Ingrese la cantidad de dinero a consignar: ");
            int cant= input.nextInt();
            System.out.println("Saldo actualizado: "+cliente.upgrade_Balance(cant));
            atm.update_Balance_atm(cant);
            break;
            
          default:
            System.out.println("Opción invalida");

        }break;
      }else{
        System.out.println("Id invalido");
        
      }
    }
  }
}