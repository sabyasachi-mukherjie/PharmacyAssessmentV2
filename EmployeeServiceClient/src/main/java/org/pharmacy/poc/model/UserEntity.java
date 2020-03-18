package org.pharmacy.poc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

	@Override
	public String toString() {
		return "User [firstNm=" + firstNm + ", lastNm=" + lastNm + ", address=" + address + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}

}
