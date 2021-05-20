package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {
	@NotBlank(message = "名前は必須です")
	private String name;
	@NotBlank(message = "年齢は必須です")
	@Pattern(regexp = "^[0-9]*$", message = "半角数字で入力してください")
	private String age;
	@NotBlank(message = "コメントは必須です")
	@Size(min = 1, max = 256, message = "コメントは1文字以上256文字以内で記載してください")
	private String comment;

	public Integer getIntAge() {
		return Integer.parseInt(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
