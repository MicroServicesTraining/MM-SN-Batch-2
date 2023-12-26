/**
 * 
 */
package com.servicenow.secdemo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * 
 */
public class PasswordEncoderUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String password = "demosecret";
		String encodedPwd =  NoOpPasswordEncoder.getInstance().encode(password);
		//System.out.println(encodedPwd);

		encodedPwd = new BCryptPasswordEncoder().encode("ab12");
		System.out.println(encodedPwd);
		
		//encodedPwd = new Pbkdf2PasswordEncoder().encode("mindmajix");
		//System.out.println(encodedPwd);
		
		encodedPwd = new StandardPasswordEncoder().encode("hyd");
		//System.out.println(encodedPwd);
		
	}

}
