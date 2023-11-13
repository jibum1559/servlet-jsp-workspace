package paginationDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "khcafe";
	private static final String jdbcPassword = "khcafe";
	//1.��� ��ǰ�� ������ ���� �޼���
	//	������ ��ȣ�� ������ ũ�⸦ �޾ƿͼ� ����Ʈ�� �߰��ϴ� �޼���
	public List<Products> getAllProducts(int pageNumber, int pageSize) {
		List<Products> productList = new ArrayList<>();
		//������������ �� �������� ���� ����ó��
		int start = PaginationUtil.paginationStart(pageNumber, pageSize);
		int end = PaginationUtil.paginationEnd(pageNumber, pageSize);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM products " //products ���̺���
					+ "ORDER BY product_id "	   //product_id �������� ������ ����
					// ������ OFFSET FETCH NEXT �������� ������ ��
					+ "OFFSET ? " //OFFSET : �������⸦ ������ ���� ��ġ�� ��Ÿ��
					+ "ROWS FETCH NEXT? " //FETCH NEXT : ������ ������ ���� �� ����
					+ "ROWS ONLY";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Products products = new Products();
				products.setProductId(rs.getInt("product_id"));
				products.setProductName(rs.getString("product_name"));
				productList.add(products);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}
	
	//2.��ü ��ǰ ���� ������ ���� �޼���
	public int getTotalProducts() {
		int totalProducts = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			String sql = "SELECT COUNT(*) AS total FROM products";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				totalProducts = rs.getInt("total");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalProducts;
	}

}

