package examen;

import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Conection {
	
	private ObjectContainer db = null;
	
	
	//	funcion para abrir la conexion con el archivo que contiene la base de datos
	private void abrirRegistro() {
		db = Db4oEmbedded.openFile("MyDataBase");
	}
	//funcion para cerrar la conexion	
	private void cerrarRegistro() {
			db.close();
	}
//	Funcion de insertado de personas CreateUser.class
	void InsertUser(CreateUser u) {
		abrirRegistro();
		db.store(u);
		cerrarRegistro();
	}
//	Funcion de insertado de personas AdminUsers.class
	void InsertAdminUsers(AdminUsers au) {
		abrirRegistro();
		db.store(au);
		cerrarRegistro();
	}
	
	
//	funcion de Mostrado CreateUsers.class
	public CreateUser selectUser(CreateUser u) {
		abrirRegistro();
		ObjectSet resultado = db.queryByExample(u);
		CreateUser user = (CreateUser) resultado.next();
		cerrarRegistro();
		
		return user;
	}
//	funcion de Mostrado AdminUsers.class
	public AdminUsers selectAdminUser(AdminUsers au) {
		abrirRegistro();
		ObjectSet resultado = db.queryByExample(au);
		AdminUsers adminUser = (AdminUsers) resultado.next();
		cerrarRegistro();
		
		return adminUser;
	}
//	funcion de actualizacion de registros  
	
	public void actualizarRegistro(int id, String nom, String apeP, String apeM, int edad) {
		abrirRegistro();
		CreateUser u = new CreateUser();
		u.setId(id);
		ObjectSet resultado = db.queryByExample(u);
		CreateUser preResultado = (CreateUser) resultado.next();
		preResultado.setNombre(nom);
		preResultado.setPaterno(apeP);
		preResultado.setMaterno(apeM);
		preResultado.setEdad(edad);
		db.store(preResultado);
		cerrarRegistro();
	}
	public void actualizarFondos(int nip, int fondoInicial) {
		abrirRegistro();
		AdminUsers au = new AdminUsers();
		au.setNip(nip);
		ObjectSet resultado = db.queryByExample(au);
		AdminUsers preResultado = (AdminUsers) resultado.next();
		preResultado.setNip(nip);
		preResultado.setFondoInicial(fondoInicial);
		db.store(preResultado);
		cerrarRegistro();
	}
	
//	Funcion de eliminacion de registros 
	public void eliminarRegistro(int id) {
		abrirRegistro();
		CreateUser u = new CreateUser();
		u.setId(id);
		ObjectSet resultado = db.queryByExample(u);
		CreateUser preResultado = (CreateUser) resultado.next();
		db.delete(preResultado);
		cerrarRegistro();
	}

	
}

