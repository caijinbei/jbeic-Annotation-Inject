package com.jbeic.AnnotationInject;

import java.lang.reflect.Field;

import com.jbeic.AnnotationInject.Annotation.Inject;
import com.jbeic.AnnotationInject.exception.JBeicInjectException;

/**
 * TODO ���� ע������ע������� .<br>
 * <p>
 * TODO ��ϸ���������ڽ�ĳ��������ע��һ����������
 * </p>
 * 
 * <p>
 * Copyright: ��Ȩ���� (c) JBeic
 * </p>
 * 
 * @author JBeic
 * @version V1.0 2015��9��14��
 */
public class JBeicInject {

	/**
	 * <p>
	 * ��������sourceObject�е�ĳ�������Ķ�����injectObject�������ע��
	 * ��������������������ͬ������ԣ�����Զ�ע���һ������������ʹ��inject(Object sourceObject,String
	 * fieldName,Object injectObject)��inject(Object sourceObject,int
	 * index,Object injectObject)
	 * </p>
	 * 
	 * @param sourceObject
	 *            ������
	 * @param injectObject
	 *            �����Ķ���
	 */
	public static void inject(Object sourceObject, Object injectObject) {
		if (sourceObject == null) {
			JBeicInjectException.showMsg("����sourceObject����Ϊnull");
			return;
		}
		if (injectObject == null) {
			JBeicInjectException.showMsg("����injectObject����Ϊnull");
			return;
		}

		Class<? extends Object> injectclass = sourceObject.getClass();
		Field[] fields = injectclass.getDeclaredFields();// ��ȡ�����ֶ�
		for (Field filed : fields) {
			// ��ȡInjectע��
			Inject injes = filed.getAnnotation(Inject.class);
			if (injes != null) {
				try {

					// �ж� ע����� �Ƿ�������filed����������������
					if (!isInstance(filed,injectObject)){
						continue;
					}
					filed.setAccessible(true);// ����Ϊ���޸�
					filed.set(sourceObject, injectObject);// ע�����
					break;
				} catch (IllegalArgumentException e) {
					JBeicInjectException.showMsg("ע��Ķ����������ȷ");
				} catch (IllegalAccessException e) {
					JBeicInjectException.showMsg("û��Ȩ��ȥע�����");
				}
			}
		}
	}

	/**
	 * <p>
	 * �����������ͬ�������ʱ����������sourceObject�е���������ΪfieldName�����Ķ�����injectObject�������ע��
	 * </p>
	 * 
	 * @param sourceObject
	 *            ������
	 * @param fieldName
	 *            �����������
	 * @param injectObject
	 *            �����Ķ���
	 */
	public static void inject(Object sourceObject, String fieldName, Object injectObject) {
		if (sourceObject == null) {
			JBeicInjectException.showMsg("����sourceObject����Ϊnull");
			return;
		}
		if (injectObject == null) {
			JBeicInjectException.showMsg("����injectObject����Ϊnull");
			return;
		}

		Class<? extends Object> injectclass = sourceObject.getClass();
		Field filed = null;
		try {
			filed = injectclass.getDeclaredField(fieldName);
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			JBeicInjectException.showMsg(injectclass.getName() + "�Ҳ���" + fieldName + "����");
			return;
		}

		// ��ȡInjectע��
		Inject injes = filed.getAnnotation(Inject.class);
		if (injes != null) {
			try {
				// �ж� ע����� �Ƿ�������filed����������������
				if (!isInstance(filed,injectObject)) {
					JBeicInjectException.showMsg(injectclass.getName() + "��" + fieldName + "��������Ϊ" + filed.getType().getName() + ",���ݲ�����������" + injectObject.getClass().getName());
				}
				filed.setAccessible(true);// ����Ϊ���޸�
				filed.set(sourceObject, injectObject);// ע�����
			} catch (IllegalArgumentException e) {
				JBeicInjectException.showMsg("ע��Ķ����������ȷ");
			} catch (IllegalAccessException e) {
				JBeicInjectException.showMsg("û��Ȩ��ȥע�����");
			}
		} else {
			JBeicInjectException.showMsg(injectclass.getName() + "��" + fieldName + "����û��@Injectע��");
		}

	}

	/**
	 * <p>
	 * �����������ͬ�������ʱ����������sourceObject�еĵ�index-1����ͬ�������Ķ�����injectObject�������ע�롣
	 * <b>index��0��ʼ</b>
	 * </p>
	 * 
	 * @param sourceObject
	 *            ������
	 * @param index ���λ
	 * @param injectObject
	 *            �����Ķ���
	 */
	public static void inject(Object sourceObject, int index, Object injectObject) {
		
		if (sourceObject == null) {
			JBeicInjectException.showMsg("����sourceObject����Ϊnull");
			return;
		}
		if (injectObject == null) {
			JBeicInjectException.showMsg("����injectObject����Ϊnull");
			return;
		}
		if (index<1) {
			JBeicInjectException.showMsg("����index����С��1");
			return;
		}

		Class<? extends Object> injectclass = sourceObject.getClass();
		Field[] fields = injectclass.getDeclaredFields();// ��ȡ�����ֶ�
	
		Field filed= fields[index];
		// ��ȡInjectע��
				Inject injes = filed.getAnnotation(Inject.class);
				if (injes != null) {
					try {
						// �ж� ע����� �Ƿ�������filed����������������
						if (!isInstance(filed,injectObject)) {
							JBeicInjectException.showMsg(injectclass.getName() + "��" + filed.getName() + "��������Ϊ" + filed.getType().getName() + ",���ݲ�����������" + injectObject.getClass().getName());
						}
						filed.setAccessible(true);// ����Ϊ���޸�
						filed.set(sourceObject, injectObject);// ע�����
					} catch (IllegalArgumentException e) {
						JBeicInjectException.showMsg("ע��Ķ����������ȷ");
					} catch (IllegalAccessException e) {
						JBeicInjectException.showMsg("û��Ȩ��ע�����");
					}
				} else {
					JBeicInjectException.showMsg(injectclass.getName() + "��" +filed.getName()+ "����û��@Injectע��");
				}
		

	}


	/**
	 * TODO  �ж�ע��Ķ����Ƿ��������һ�£���ͬ�� ���������� �����ǣ�         .<br>
	 *
	 * @param field ������
	 * @param injectObject ע�����
	 * @return  boolean 
	 */
	private static boolean isInstance(Field field, Object injectObject) {

		if (field.getType().isInstance(injectObject)) {
			return true;
		} else {
			if (field.getType().getName().equals("int") && injectObject.getClass().getName().equals("java.lang.Integer") || field.getType().getName().equals("double") && injectObject.getClass().getName().equals("java.lang.Double") || field.getType().getName().equals("long") && injectObject.getClass().getName().equals("java.lang.Long") || field.getType().getName().equals("float") && injectObject.getClass().getName().equals("java.lang.Float") || field.getType().getName().equals("boolean") && injectObject.getClass().getName().equals("java.lang.Boolean") || field.getType().getName().equals("char") && injectObject.getClass().getName().equals("java.lang.Character")) {
				return true;
			} else {
				return false;
			}

		}

	}

}
