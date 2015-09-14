package com.jbeic.AnnotationInject.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * TODO ����   ע��Ҫע���������      .<br>
 *<p>TODO ��ϸ���������������ĳ���ֶ���Ҫ��������ע��</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��14��
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
	
	/**
	 * ��ע���Ƿ���ԣ�Ĭ����true������Ϊfalseʱ�޷���ע���Field����ע��<br>
	 *
	 * @return  boolean 
	 */
	boolean isEnable() default true;
	
}
