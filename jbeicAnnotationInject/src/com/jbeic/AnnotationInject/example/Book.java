package com.jbeic.AnnotationInject.example;

/**
 * TODO ����     ��            .<br>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��14��
 */
public class Book {
	private String msgString="";
	public Book(String msgString){
		this.msgString=msgString;
	}
	@Override
	public String  toString(){	
		return "Book:"+msgString;
	}

}
