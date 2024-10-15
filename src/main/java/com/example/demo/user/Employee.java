package com.example.demo.user;
// import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
// @Data
@Data
@Document(collection = "my-collection")
public class Employee {
    @Id
    String _id;
    String name;
    Integer age;
    String email;

    public String _idget() {
		return this._id;
	}

    public void set_id(String _id ) {
		this._id = _id;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
