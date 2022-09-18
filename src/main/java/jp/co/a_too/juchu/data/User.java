package jp.co.a_too.juchu.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	//@Id
	private String userName;
	private String password;
	private String info;
	private String attrs;
	private String department;
	private String displayName;
}


