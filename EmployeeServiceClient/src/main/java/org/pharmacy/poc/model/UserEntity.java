package org.pharmacy.poc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

	/**
	 * @return the emplId
	 */
	public int getEmplId() {
		return emplId;
	}

	/**
	 * @param emplId the emplId to set
	 */
	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}

	/**
	 * @return the firstNm
	 */
	public String getFirstNm() {
		return firstNm;
	}

	/**
	 * @param firstNm the firstNm to set
	 */
	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	/**
	 * @return the lastNm
	 */
	public String getLastNm() {
		return lastNm;
	}

	/**
	 * @param lastNm the lastNm to set
	 */
	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [firstNm=" + firstNm + ", lastNm=" + lastNm + ", address=" + address + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}

}
