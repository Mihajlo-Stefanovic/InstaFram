package model.exceptions;

import model.exceptions.exceptionTypes.MyExceptionType;

public class MyException extends Throwable{

	private static final long serialVersionUID = 6620950931016971770L;
	private MyExceptionType type;
	private String exceptionDescr;
	private Exception sysException;
	
	private String message;
	
	public MyException(MyExceptionType type) {
		this.type = type;
	}
	
	public MyException(MyExceptionType type, Exception e) {
		sysException = e;
	}
	
	public MyException(MyExceptionType type, String exceptionDescr) {
		this.type = type;
		this.exceptionDescr = exceptionDescr;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public MyExceptionType getType() {
		return type;
	}

	public String getExceptionDescr() {
		return exceptionDescr;
	}

	public Exception getSysException() {
		return sysException;
	}
	
}
