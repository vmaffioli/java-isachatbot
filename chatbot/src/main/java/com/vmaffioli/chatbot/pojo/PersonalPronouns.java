package com.vmaffioli.chatbot.pojo;

public class PersonalPronouns {


	private String eu;
	private String tu;
	private String ele_ela;
	private String nos;
	private String vos;
	private String eles_elas;
	
	public PersonalPronouns() {
		
	}

	public String getEu() {
		return eu;
	}

	public void setEu(String eu) {
		this.eu = eu;
	}

	public String getTu() {
		return tu;
	}

	public void setTu(String tu) {
		this.tu = tu;
	}

	public String getEle_ela() {
		return ele_ela;
	}

	public void setEle_ela(String ele_ela) {
		this.ele_ela = ele_ela;
	}

	public String getNos() {
		return nos;
	}

	public void setNos(String nos) {
		this.nos = nos;
	}

	public String getVos() {
		return vos;
	}

	public void setVos(String vos) {
		this.vos = vos;
	}

	public String getEles_elas() {
		return eles_elas;
	}

	public void setEles_elas(String eles_elas) {
		this.eles_elas = eles_elas;
	}
	
	
	@Override
	public String toString() {
		return "PersonalPronouns [eu=" + eu + ", tu=" + tu + ", ele_ela=" + ele_ela + ", nos=" + nos + ", vos=" + vos
				+ ", eles_elas=" + eles_elas + "]";
	}
	
	
}

