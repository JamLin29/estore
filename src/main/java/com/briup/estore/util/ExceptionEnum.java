package com.briup.estore.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
	SUCCESS("成功"),
	PARAM_IS_NULL("参数为空"),
	TOO_MANY_RESULT("查询结果过多"),
	SERVER_ERROR("服务器内部错误"),
	USERNAME_IS_EXIST("用户已存在");
	
	private String message;
}
