package org.pharmacy.poc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
public class Employee {

	private int emplId;
	@NotBlank(message = "First name is mandatory")
	private String firstNm;
	private String lastNm;
	private String address;
	@NotBlank(message = "Telephone number is mandatory for any emergency contacts")
	private String telephone;
	@NotBlank(message = "Emil address is mandatory for official communications")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Please enter a valid email address")
	private String email;

	public Employee() {

	}

	@Override
	public String toString() {
		return "User [firstNm=" + firstNm + ", lastNm=" + lastNm + ", address=" + address + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}

}
