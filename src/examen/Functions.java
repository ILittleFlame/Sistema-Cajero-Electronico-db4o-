package examen;

import java.util.Scanner;

public class Functions {
	CRUD query=new CRUD();
	AdminUsers user=new AdminUsers();
	int nip=0,
			numberCard=0,
			fondoInicial=0;
	String	acount=null,
			opcion=null;
	Scanner scan = new Scanner(System.in);
	
	
	public void admin() {
		System.out.println("Eres un Administrador o quieres entrar al cajero?Administrador 1/cajero 2 (user:raul password:admin)");
		acount=scan.nextLine();
		switch(acount) {
		case "1":
			System.out.println("Bienvenido al panel administrador ingresa el usuario");
			String user=scan.nextLine();
			System.out.println("Bienvenido ingresa el password");
			String password=scan.nextLine();
			String confirm;
			
			//usuario:raul password:admin
			if(user.equals("raul") && password.equals("admin")) {
				System.out.println("Bienvenido "+user);
				query.SelectUser(0);
				System.out.println("Quieres Ingresar un usuario?si/no");
				confirm=scan.nextLine();
			
				if(confirm.equals("si")) {
					
				System.out.println("Ingresa el NIP:");
				nip=Integer.parseInt(scan.nextLine());
				
				System.out.println("Ingresa el nombre completo:");
				String name=scan.nextLine();
				
				System.out.println("Ingresa el numero de tarjeta:");
				numberCard=Integer.parseInt(scan.nextLine());
				
				System.out.println("Ingresa el fondo inicial:");
				fondoInicial=Integer.parseInt(scan.nextLine());
					query.InsertAdminUser(nip, name, numberCard, fondoInicial);
				System.out.println("usuario registrado exitosamente");	
					query.SelectAdminUser(nip);
					System.exit(0);
				}else{
					System.out.println("Operacion cancelada");
					admin();
					}		
			}else {
				System.out.println("Usuario no valido has regresado al inicio");
				admin();
			}
		break;
		case "2":
			cajero(2);
		default:
			System.out.println("Opcion no valida intenta de nuevo");
	
			admin();
//				query.SelectUser(1);
//				
//				System.out.println("Que deseas hacer \n1=depositar\n"
//						+ "2=Visualizacion de fondos\n"
//						+ "3=retirar\n");
//				int opcion=Integer.parseInt(scan.nextLine());
//				switch(opcion) {
//				case 1:
//					System.out.println("opcion en mantenimiento");
//					System.exit(0);
//				break;
//				case 2:
//					System.out.println("Ingresa el usuario");
//					opcion=Integer.parseInt(scan.nextLine());
//					System.out.println("Estos son sus fondos");
//					query.SelectAdminUser(opcion);
//					System.exit(0);
//				break;
//				case 3:
//					System.out.println("opcion en mantenimiento");
//					System.exit(0);
//				break;
//				default:
//						
//				}
			}
		admin();
		
	}
	
	public void cajero(int cajero) {
		System.out.println("Bienvenido al cajero electronico");
		
		System.out.println("Ingresa tu NIP");
		nip=Integer.parseInt(scan.nextLine());
		
		System.out.println("Ingresa tu numero de tarjeta");
		numberCard=Integer.parseInt(scan.nextLine());
		
		int myNumberCard=query.SelectAdminUserNumberCard(nip);
		int myNip=query.SelectAdminUserNip(nip);
		
		if(nip==myNip && numberCard==myNumberCard) {
			System.out.println("Bienvenido");
			query.SelectAdminUser(nip);
			
			opcionesCajero();		
			//System.out.println("Tu nip es "+myNip);
			//System.out.println("Tu numero de tarjeta es "+myNumberCard);
			
		}else {
			System.out.println("Lo sentimos este usuario no es valido");
			cajero(2);
		}
		
		System.exit(0);
	}
	
	public void opcionesCajero() {
		System.out.println("Que deseas hacer?\n"
				+ "1=depositar\n"
				+ "2=Visualizacion de fondos\n"
				+ "3=retirar\n"
				+ "4=Cerrar Sesion");
				opcion=scan.nextLine();
				switch(opcion) {
				case "1":
					System.out.println("cuanto quieres depositar?");
					int deposito=Integer.parseInt(scan.nextLine());
					System.out.println("fondo actual es de "+query.DepositoFondos(nip, deposito));
					System.out.println("Gracias por usar");
					opcionesCajero();
				break;
				case "2":
					System.out.println("Tus fondos actuales son de $"+query.SelectAdminUserFondos(nip));
					opcionesCajero();
				break;
				case "3":
					System.out.println("cuanto quieres retirar?");
					int retiro=Integer.parseInt(scan.nextLine());
					System.out.println("fondo actual es de "+query.RetiroFondos(nip, retiro));
					System.out.println("Gracias por usar");
					opcionesCajero();
				break;
				case "4":
					admin();
					break;
				default:
					opcionesCajero();

				}
	}
	
}
