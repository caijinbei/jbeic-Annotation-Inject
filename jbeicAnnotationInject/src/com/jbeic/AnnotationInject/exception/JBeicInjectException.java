package com.jbeic.AnnotationInject.exception;

/**
 * TODO ����        JBeicAnnotationInject�쳣������         .<br>
 *<p>TODO ��ϸ���������ڲ���JBeicAnnotationInject�����е��쳣���</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��14��
 */
public class JBeicInjectException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public JBeicInjectException(String msg){
		super(msg);
	}
	public static void showMsg(String msg){
		try {
			throw new JBeicInjectException(msg);
		} catch (JBeicInjectException e) {
			e.printStackTrace();
		}
	} 

}
