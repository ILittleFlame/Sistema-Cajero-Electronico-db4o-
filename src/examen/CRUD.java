package examen;

public class CRUD {
	private Conection crud = new Conection();
	private CreateUser user = new CreateUser();
	private AdminUsers adminUser= new AdminUsers();
	public void InsertUser(int id, String name, String paterno, String materno, int edad) {
		user.setId(id);
		user.setNombre(name);
		user.setPaterno(paterno);
		user.setMaterno(materno);
		user.setEdad(edad);
		crud.InsertUser(user);
	}
	public void InsertAdminUser(int nip,String name, int numberCard, int fondoInicial) {
		adminUser.setNip(nip);
		adminUser.setName(name);
		adminUser.setNumberCard(numberCard);
		adminUser.setFondoInicial(fondoInicial);
		crud.InsertAdminUsers(adminUser);
	}
	public void UpdateUser(int id, String name, String paterno, String materno, int edad) {
		crud.actualizarRegistro(id, name, paterno, materno, edad);
	}
	public void SelectUser(int id) {
		user.setId(id);
		user = crud.selectUser(user);
		System.out.println(user);
	}
	public void SelectAdminUser(int nip) {
		adminUser.setNip(nip);
		adminUser = crud.selectAdminUser(adminUser);
		System.out.println(adminUser);
	}
	//Seleccion del nip del usuario creado por el admin
	public int SelectAdminUserNip(int nip) {
		adminUser.setNip(nip);
		adminUser = crud.selectAdminUser(adminUser);
		return adminUser.getNip();
	}
	
	public int SelectAdminUserNumberCard(int nip) {
		adminUser.setNip(nip);
		adminUser = crud.selectAdminUser(adminUser);
		return adminUser.getNumberCard();
	}
	public int SelectAdminUserFondos(int nip) {
		adminUser.setNip(nip);
		adminUser = crud.selectAdminUser(adminUser);
		return adminUser.getFondoInicial();
	}
	
	public int DepositoFondos(int nip,int fondo) {
		
		adminUser.setNip(nip);
		adminUser = crud.selectAdminUser(adminUser);
		int oldFondo=adminUser.getFondoInicial();
		fondo=fondo+oldFondo;
		crud.actualizarFondos(nip, fondo);
		return fondo;
		
	}
	public int RetiroFondos(int nip,int fondo) {
		
		adminUser.setNip(nip);
		adminUser = crud.selectAdminUser(adminUser);
		int oldFondo=adminUser.getFondoInicial();
		if(fondo>oldFondo) {
			System.out.println("No cuentas con saldo sufuciente para el retiro");
			fondo=oldFondo;
		}else {
			fondo=oldFondo-fondo;
		}
		crud.actualizarFondos(nip, fondo);
		return fondo;
		
	}
}
