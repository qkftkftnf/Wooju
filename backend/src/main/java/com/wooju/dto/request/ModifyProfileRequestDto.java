package com.wooju.dto.request;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ModifyProfileRequestDto")
public class ModifyProfileRequestDto {

	String nickname;
	String img;
	
}
