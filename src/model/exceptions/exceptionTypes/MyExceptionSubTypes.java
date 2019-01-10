package model.exceptions.exceptionTypes;

public enum  MyExceptionSubTypes implements MyExceptionType {
	;
	public enum DELETENODELISTENER implements MyExceptionType{
		NOPROJECT,NONODESELECTED,DELETEROOT
	}
	public enum CLOSEPROJECTLISTENER implements MyExceptionType{
		NOPROJECT
	}
	public enum ADDTREELISTENER implements MyExceptionType{
		NOPROJECT, NONODESELECTED
	}
	public enum LOADPROJECTLISTENER implements MyExceptionType{
		FILEEMPTY, NEWROOTADDED
	}
	public enum LOADER implements MyExceptionType{
		IOEXCEPTION
	}
	public enum NEWNODELISTENER implements MyExceptionType{
		NOTREE, ADDONPARAMETER
	}
	public enum SAVE implements MyExceptionType{
		NOPROJECT
	}
	public enum PARAMETERTAB implements MyExceptionType{
		WRONGSUBTYPE, NOTPICTURE, NOTDOCUMENT
	}
	public enum LOGIN implements MyExceptionType{
		WRONGINFO, USERALREADYEXSISTS
	}
	public enum NEWMODULE implements MyExceptionType{
		NOPATH
	}
	public enum INSTALL implements MyExceptionType{
		FILENOTVALID, NOSUCHFILE, NOLOOK
	}
}
