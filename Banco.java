//paquetes;
import java.util.Scanner;


//Clase
public class Banco{
  Scanner input = new Scanner(System.in);
  //Atributos;
  Client[] client_list = {new Client(123, 500000), new Client(122, 30000)};
  ATM[] atm_list = {new ATM(11, 100000000)};


//Comportamientos;
  public void welcome(){
    System.out.println("Bienvenido al banco UdemBank");
    System.out.println("Ingrese su id: ");
    int id = input.nextInt();
    verificacion(id);
  }

  public void verificacion(int id){
    try{
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
        transacciones(respuesta, atm, cliente);
        break;
      }else{
        throw new CustomException("Id no registrado");
        }
    
      }
    }catch(CustomException e){
      System.out.println("Ocurrio un error intentalo más tarde.");
    }
  }


          
  public void transacciones(int respuesta, ATM atm, Client cliente){
    try{
        switch(respuesta){
          case 1:
            System.out.println("Su dinero actual es: "+cliente.check_Balance());
            break;
            
          case 2:
            System.out.println("Ingrese la cantidad de dinero a retirar: ");
            int valor = input.nextInt();
            if (valor > cliente.balance){
              throw new CustomException("Saldo insuficiente. ");
            }else if(valor < 0){ 
              throw new CustomException("Valor incorrecto. ");
            }else if(atm.balance == 0){ 
              throw new CustomException("ATM en mantenimiento. ");
            }else{
              System.out.println("Saldo actualizado: "+cliente.whithdraw(valor));
              atm.whithdraw_atm(valor);}
            break;
            
          case 3:
            System.out.println("Ingrese la cantidad de dinero a consignar: ");
            int cant= input.nextInt();
            if(cant>3000000){
              throw new CustomException("El limite de transacciones es de 3.000.000");
            }else if(cant < 0){ 
              throw new CustomException("Valor incorrecto. ");
            }else{
            System.out.println("Saldo actualizado: "+cliente.upgrade_Balance(cant));
            atm.update_Balance_atm(cant);
            }
            break;
            
          default:
            System.out.println("Opción invalida");
            

        }
      }catch(CustomException e){
        System.out.println("Ocurrio un error intentalo más tarde.");
      }
    }
}