import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);
    static double saldo = 1_000_000d;

    public static void main(String[] args) {
        login();
    }
    public static void login() {
        // simulacion de la base de datos
        // Ejercicio 1
        int Usuario = 12345;
        int clave = 2026;
        int contador = 3;
        boolean verificado = false;
        int errorPorTipoDato = 5;
        int cuentaIngresada;
        int claveIngresada;
        do {
            System.out.println("=================Bienvenido a tu banco================");
            System.out.print("Por favor ingresa tu numero de cuenta: ");
            try {
                cuentaIngresada = sc.nextInt();
                sc.nextLine(); 
                if (cuentaIngresada == Usuario) {
                System.out.print("Por favor ingrese su contraseña: ");
                claveIngresada = sc.nextInt();
                sc.nextLine();
                if (claveIngresada == clave) {
                    System.out.println("ingresando al sistema . . . . . . . ");
                    verificado = true;
                    break;
                }else{
                    System.out.println("Credenciales incorrectas");
                    contador--;
                    System.out.println("tiene " + contador +" intentos");
                }
                }else{
                    System.out.println("Cuenta de usuario incorrecta");
                    contador--;
                    System.out.println("tiene " + contador +" intentos");
                }       
                } catch (Exception e) {
                    System.out.println("Error, porfavor ingrese solo numeros.");
                    sc.nextLine();
                    errorPorTipoDato--;
                    if (errorPorTipoDato == 0) {
                        System.out.println("Ha superado el numero de intentos, porfavor intentelo mas tarde");
                        break;
                    }
                }
        } while (contador > 0 );
        if (verificado == true) {
            System.out.println("Bienvenido usuario "+ Usuario + " logeo exitoso");
            menu();
        } else {
            System.out.println("Ha superado el numero de intentos, cuenta bloqueada . . . .");
        }
    }
    public static void menu() { 

        String opcion;
        int cuentaTransferencia = 0;
        double valorTranferencia;
        do {
            System.out.println("============== Menú ============");
            System.out.println("seleccione el numero del tramite que desea ");
            System.out.println("1. consultar saldo");
            System.out.println("2. Transferir dinero");
            System.out.println("3. retirar dinero");
            System.out.println("4. salir ");
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Su saldo es : "+ saldo);
                    break;
                case "2":
                    try {
                        System.out.println("ingresa el valor a transferir");
                        valorTranferencia = sc.nextDouble();
                        if (valorTranferencia > saldo) {
                            System.out.println("Saldo insuficiente");
                            break;
                        }
                        else{
                        System.out.println("Ingrese el numero de cuenta a transferir: ");
                        cuentaTransferencia = sc.nextInt();
                        sc.nextLine();
                        saldo = saldo - valorTranferencia;
                        System.out.println("se ha realizado exitosamente la transferencia a la cuenta "+cuentaTransferencia+" por valor de "+valorTranferencia+" pesos, su nuevo saldo es: "+ saldo);
                        }                  
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor invalido");
                    }
                    break;
                case "3":
                    try {
                        System.out.println("ingrese la cantidad de dinero a retirar: ");
                        valorTranferencia = sc.nextDouble();
                        if (valorTranferencia > saldo) {
                            System.out.println("no tiene saldo suficiente");
                        }else if(valorTranferencia<0){
                            System.out.println("Valor invalido");
                        }else{
                            saldo -= valorTranferencia;
                            System.out.println("su nuevo saldo es: "+saldo);
                        }
                    } catch (Exception e) {
                        System.out.println("Valor invalido");
                    }
                    break;
                case "4":
                    System.out.println("Hasta luego");
                    return;
                default:
                    System.out.println("ingreso un valor invalido");
                    break; 
                }

        } while (true);

        
    }
}
