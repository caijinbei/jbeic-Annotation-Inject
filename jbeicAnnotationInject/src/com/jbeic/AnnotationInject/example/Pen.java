package com.jbeic.AnnotationInject.example;

/**
 * TODO ����       ��          .<br>
 *<p>TODO ��ϸ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) JBeic</p>
 *
 * @author JBeic
 * @version V1.0 2015��9��14��
 */
public class Pen {
	private String nameString;

	public Pen() {
	}

	public Pen(String nameString) {
		this.nameString = nameString;
	}

	@Override
	public String toString() {
		return "Pen:" + nameString;

	}

}
