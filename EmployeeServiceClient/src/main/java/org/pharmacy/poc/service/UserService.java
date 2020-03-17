package org.pharmacy.poc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.pharmacy.poc.model.User;
import org.pharmacy.poc.model.UserEntity;
import org.pharmacy.poc.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public UserService() {
		// Default Constructor
	}

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	/* Saves the employee entity into MYSQL database */
	public Object save(final User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		repository.save(userEntity);
		user.setEmplId(userEntity.getEmplId());
		return user;
	}

	/* Updates the employee entity into MYSQL database */
	public Object update(final User user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		Optional<UserEntity> existingStudent = repository.findById(userEntity.getEmplId());
		if (existingStudent.isPresent()) {
			save(user);
			return user;
		}
		return "No student record found for update in DB";
	}

	/* Gets all the employee entities saved so far from MYSQL database */
	public List<UserEntity> getAll(String columns, String records, String pageNo) {
		final List<UserEntity> users = new ArrayList<>();
		repository.findAll().forEach(user -> users.add(user));
		return modifyResult(columns, records, pageNo, users);
	}

	/* Modifies the data in such a format as the requestor had requested for */
	private List<UserEntity> modifyResult(String columns, String records, String pageNo, List<UserEntity> users) {
		List<UserEntity> modifiedUsers = new ArrayList<>();
		if (StringUtils.isEmpty(records) || StringUtils.isEmpty(pageNo)) {
			modifiedUsers = users;
		} else {
			if (users.size() >= Integer.parseInt(pageNo) * Integer.parseInt(records))
				modifiedUsers = users.subList(Integer.parseInt(records) * (Integer.parseInt(pageNo) - 1),
						Integer.parseInt(pageNo) * Integer.parseInt(records));
		}
		List<String> fields = new ArrayList<>();
		fields.add("firstname");
		fields.add("lastname");
		fields.add("email");
		fields.add("address");
		fields.add("telephone");
		List<String> columnsNeeded = new ArrayList<String>();
		if (columns != null) {
			columnsNeeded = Arrays.asList(columns.split(","));
		}
		if (!columnsNeeded.isEmpty()) {
			fields.removeAll(columnsNeeded);
			for (String removeColumn : fields) {
				switch (removeColumn) {
				case "firstname":
					for (UserEntity user : modifiedUsers) {
						user.setFirstNm(null);
					}
					break;

				case "lastname":
					for (UserEntity user : modifiedUsers) {
						user.setLastNm(null);
					}
					break;
				case "email":
					for (UserEntity user : modifiedUsers) {
						user.setEmail(null);
					}
					break;
				case "telephone":
					for (UserEntity user : modifiedUsers) {
						user.setTelephone(null);
					}
					break;
				case "address":
					for (UserEntity user : modifiedUsers) {
						user.setAddress(null);
					}
					break;
				}
			}
		}
		return modifiedUsers;
	}


}
