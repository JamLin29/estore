package com.briup.estore.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EstoreException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ExceptionEnum exceptionEnum;
}
