package examen;

public class CreateUser {
	int id=0,
		edad=0;
	String nom=null,
			apeP=null,
			apeM=null;
//	public CreateUser(int id,String nom){
//		this.id=id;
//		this.nom=nom;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}
	public String getNombre() {
		return nom;
	}
	public void setNombre(String nom) {
		this.nom=nom;
	}
	public String getPaterno() {
		return apeP;
	}
	public void setPaterno(String apeP) {
		this.apeP=apeP;
	}
	public String getMaterno() {
		return apeM;
	}
	public void setMaterno(String apeM) {
		this.apeM=apeM;
	}
	
	public String toString() {
		
		return "id Usuario:"+id+
				" nombre:"+ nom + 
				" apellido paterno:" + apeP + 
				" apellido materno:" + apeM + 
				" edad:" + edad;
	}
	
}
