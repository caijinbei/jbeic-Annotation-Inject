package com.jbeic.AnnotationInject.example;


import com.jbeic.AnnotationInject.Annotation.Inject;

/**
 * TODO ����      ѧ���࣬��������������          .<br>
 *<p>TODO ��ϸ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��14��
 */
public class Student {
	@Inject
	private Pen pen;
	
	@Inject
	private Book book;
	
	public Student(){
	}
	
	@Override
	public String  toString(){	
		return "Student:"+pen.toString()+","+book.toString();
	}

}
