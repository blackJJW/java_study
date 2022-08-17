package nestedClassAndNestedInterface;

public class Button {

	OnClickListener listener; // �������̽� Ÿ�� �ʵ�
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;   // �Ű� ������ ������
	} 
	
	void touch() { // ���� ��ü�� onClick() �޼ҵ� ȣ��
		listener.onClick();
	}
	
	interface OnClickListener{ // ��ø �������̽�
		void onClick();
	}
}
