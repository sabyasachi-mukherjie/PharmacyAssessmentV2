package org.pharmacy.poc.model;

import lombok.Data;

@Data
public class User {

	private int emplId;
	private String firstNm;
	private String lastNm;
	private String address;
	private String telephone;
	private String email;

	public User() {

	}

	public User(int emplId, String firstNm, String lastNm, String address, String telephone, String email) {
		this.emplId = emplId;
		this.firstNm = firstNm;
		this.lastNm = lastNm;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [firstNm=" + firstNm + ", lastNm=" + lastNm + ", address=" + address + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}

}
