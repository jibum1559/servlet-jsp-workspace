package paginationDAO;

public class PaginationUtil {
	//1.������ ������ 2.������ ������ 3.��Ż ������
	public static int paginationStart(int pageNumber, int pageSize) {
		return (pageNumber - 1) * pageSize + 1;
	}
	/*
	  �־��� ������ ��ȣ�� ������ ũ�⸦ �̿��ؼ� ��ȸ�� ������ ��
	  ������ �ε����� ���
	  ������ ��ȣ�� 1���� �����ϰ� �� �������� �� ���� �������� ���������� ���� ���
	 */
	public static int paginationEnd(int pageNumber, int pageSize) {
		return pageNumber * pageSize;
	}
	/*
	  �־��� ������ ��ȣ�� ������ ũ�⸦ �̿��ؼ� ��ȸ�� ���� ������ �ε����� ���
	  ������ ��ȣ�� 1���� �����ϰ� �� �������� �� ���� ���������� ���� �޶���
	 */
	
	public static int paginationTotal(int totalItems, int pageSize) {
		return (int)Math.ceil((double)totalItems/pageSize);
	}
	/*
	  ��ü ������ ���� ������ ũ�⸦ �̿��ؼ� ��ü ������ ���� ����ϴ� �޼ҵ�
	  ��ü ����� ������ ũ��� �������� 
	  �Ҽ��� ������ ���� ���� ��쿡�� �ø������ؼ� ���ó�� �ϵ��� ����
	 */
	
}
