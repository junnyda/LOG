package io.lcalmsky.app.modules.account.endpoint.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignUpForm {
	@NotBlank 
    @Length(min = 3, max = 20) 
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9_-]{3,20}$")  // 사용 불가능한 정규식 
    private String nickname;
	
	@Email // (4)
	@NotBlank
    private String email;
    
	@NotBlank
	@Length(min = 8, max = 50)
    private String password;

	@NotBlank
	@Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9_-]{3,20}$")  // 사용 불가능한 정규식 
    private String phonenumber;
}
