package org.springframework.core;

/**
 * @ClassName: NestedIOException
 * @Description:
 * @Author
 * @Date 2022/11/10
 * @Version 1.0
 */
public class NestedIOException extends Exception{

	/** Use serialVersionUID from Spring 1.2 for interoperability. */
	private static final long serialVersionUID = 7100714597678207549L;

	public NestedIOException(String msg){
		super(msg);
	}

}
