package com.jbeic.AnnotationInject.model;

import java.lang.reflect.Field;

import com.jbeic.AnnotationInject.Annotation.Inject;
import com.jbeic.AnnotationInject.exception.JBeicInjectException;


/**
 * TODO ����     ע������ע�������            .<br>
 *<p>TODO ��ϸ���������ڽ�ĳ��������ע��һ����������</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��14��
 */
public class JBeicInjectModel {
	
	/**
	 * <p>��������sourceObject�е�ĳ�������Ķ�����injectObject�������ע��
	 * ��������������������ͬ������ԣ�����Զ�ע���һ������������ʹ��inject(Object sourceObject,String fieldName,Object injectObject)��inject(Object sourceObject,int index,Object injectObject)
	 *  </p>
	 *
	 * @param sourceObject  ������
	 * @param injectObject �����Ķ��� 
	 */
	public static  void inject(Object sourceObject,Object injectObject){
		if(sourceObject==null){
			JBeicInjectException.showMsg("sourceObjectΪnull");
			return;
		}
		if(injectObject==null){
			JBeicInjectException.showMsg("injectObjectΪnull");
			return;
		}
		
		Class<? extends Object> injectclass= sourceObject.getClass();
		Field[] fields=injectclass.getDeclaredFields();//��ȡ�����ֶ�
		for(Field filed:fields){
			//��ȡInjectע��
			Inject injes=filed.getAnnotation(Inject.class);
			if(injes!=null){
				try {
					//�ж� ע����� �� ����filed���� �Ƿ�һ��
					if(!filed.getType().getName().equals(injectObject.getClass().getName())){
						continue;
					}
					filed.setAccessible(true);//����Ϊ���޸�
					filed.set(sourceObject, injectObject);//ע�����
					break;
				} catch (IllegalArgumentException e) {
					JBeicInjectException.showMsg("�쳣");
				} catch (IllegalAccessException e) {
					JBeicInjectException.showMsg("�쳣");
				}
			}
		}
	}
	
	/**
	 * <p>�����������ͬ�������ʱ����������sourceObject�е���������ΪfieldName�����Ķ�����injectObject�������ע��</p>
	 * @param sourceObject  ������
	 * @param fieldName   �����������
	 * @param injectObject  �����Ķ��� 
	 */
	public static void inject(Object sourceObject,String fieldName,Object injectObject){
		if(sourceObject==null){
			JBeicInjectException.showMsg("sourceObjectΪnull");
			return;
		}
		if(injectObject==null){
			JBeicInjectException.showMsg("injectObjectΪnull");
			return;
		}
		
		Class<? extends Object> injectclass= sourceObject.getClass();
		Field filed=null;
		try {
			filed = injectclass.getDeclaredField(fieldName);
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			JBeicInjectException.showMsg(injectclass.getName()+"�Ҳ���"+fieldName+"����");
			return;
		}
	
		//��ȡInjectע��
		Inject injes=filed.getAnnotation(Inject.class);
		if(injes!=null){
			try {
				//�ж� ע����� �� ����filed���� �Ƿ�һ��
				if(!filed.getType().getName().equals(injectObject.getClass().getName())){
					JBeicInjectException.showMsg(injectclass.getName()+"��"+fieldName+"��������Ϊ"+filed.getType().getName()+",���ݲ�����������"+injectObject.getClass().getName());
				}
				filed.setAccessible(true);//����Ϊ���޸�
				filed.set(sourceObject, injectObject);//ע�����
			} catch (IllegalArgumentException e) {
				JBeicInjectException.showMsg("�쳣");
			} catch (IllegalAccessException e) {
				JBeicInjectException.showMsg("�쳣");
			}
		}else {
			JBeicInjectException.showMsg(injectclass.getName()+"��"+fieldName+"����û��@Injectע��");
		}
		
	}
	
	/**
	 * <p>�����������ͬ�������ʱ����������sourceObject�еĵ�index����ͬ�������Ķ�����injectObject�������ע��</p>
	 *
	 * @param sourceObject ������
	 * @param index
	 * @param injectObject  �����Ķ��� 
	 */
	public static void inject(Object sourceObject,int index,Object injectObject){
		
	}
	

}
