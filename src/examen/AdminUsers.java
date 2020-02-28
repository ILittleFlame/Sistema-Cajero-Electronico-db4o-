package examen;
public class AdminUsers {
	private String name=null;
	private int nip=0,
		numberCard=0,
		fondoInicial=0;
	public int getNip() {
		return nip;
	}
	public void setNip(int nip) {
		this.nip=nip;
	}
	public int getNumberCard() {
		return numberCard;
	}
	public void setNumberCard(int numberCard) {
		this.numberCard=numberCard;
	}
	public int getFondoInicial() {
		return fondoInicial;
	}
	public void setFondoInicial(int fondoInicial) {
		this.fondoInicial=fondoInicial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String toString() {
		
		return 	" Usuario "+ name;
	}
}
