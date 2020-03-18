package org.pharmacy.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private int emplId;
	private String firstNm;
	private String lastNm;
	private String address;
	private String telephone;
	private String email;

	public User() {

	}

	@Override
	public String toString() {
		return "User [firstNm=" + firstNm + ", lastNm=" + lastNm + ", address=" + address + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}

}
