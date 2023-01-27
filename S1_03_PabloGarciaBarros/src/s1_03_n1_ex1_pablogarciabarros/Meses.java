package s1_03_n1_ex1_pablogarciabarros;

import java.util.Objects;

public class Meses {
	
	private String mes;
	
	public Meses(String mes) {
		this.mes = mes;
	}
	
	public String getMes() {
		return this.mes;
	}
	
	@Override
	public String toString() {
		return this.mes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Meses) {
			Meses otroMes = (Meses)obj;
			if(this.mes.equalsIgnoreCase(otroMes.getMes())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(mes);
	}

}
