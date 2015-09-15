package com.jbeic.AnnotationInject.example;

import java.util.ArrayList;
import java.util.List;

import com.jbeic.AnnotationInject.JBeicInject;



/**
 * TODO ����        ������         .<br>
 *<p>TODO ��ϸ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��15��
 */
public class JBeicInjectMain {
	public static void main(String[] args) {
		Student student=new Student();
		//ֱ��ע�룬�ʺ�ֻ��һ����Class������
		JBeicInject.inject(student, new JavaBook());
		
		//����������ע�룬�ʺ϶����ͬClass������
		Pen pen=new Pen("JBeic-pan");
		Pen pen2=new Pen("JBeic-pan2");
		//ע���Զ������Ͷ���
		JBeicInject.inject(student, "pen",pen);
		JBeicInject.inject(student,"pen2", pen2);
		
		//int��double��float���Զ�����װ��Ͳ���
		//ע��double����
		JBeicInject.inject(student,"money", 1000.156);
		//ע��Integer����
		JBeicInject.inject(student, Integer.valueOf(12354));
		//ע��String����
		JBeicInject.inject(student,"name","Jbeic����name");
		
		//�������Ե�λ�ý���ע�룬λ�ò�����0��ʼ
		JBeicInject.inject(student,5,"Jbeic����index");
		
		//ע��List����
		List<Book> books=new ArrayList<Book>();
		books.add(new CBook());
		books.add(new JavaBook());	
		JBeicInject.inject(student,"bookList",books);
		
		System.out.println(student.toString());
		
		
	}

}
