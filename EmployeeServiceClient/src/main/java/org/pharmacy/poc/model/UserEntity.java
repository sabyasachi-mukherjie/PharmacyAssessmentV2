package org.pharmacy.poc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class UserEntity {

	@Id
	@GeneratedValue
	private int emplId;
	private String firstNm;
	private String lastNm;
	private String address;
	private String telephone;
	private String email;

	public UserEntity() {

	}

	public UserEntity(int emplId, String firstNm, String lastNm, String address, String telephone, String email) {
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
