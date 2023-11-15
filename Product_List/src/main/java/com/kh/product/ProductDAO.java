package com.kh.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "khcafe";
	private static final String jdbcPassword = "khcafe";
	
	public ProductDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM products";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				int productId = resultSet.getInt("product_id");
				String productName = resultSet.getString("product_name");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				int stockQuantity = resultSet.getInt("stock_quantity");
				
				Product product = new Product(productId, productName, category, price, stockQuantity);
				products.add(product);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public Product getProductId(int productId) {
		
		Product product = null;
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM products WHERE product_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, productId);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()) {
				productId = resultSet.getInt("product_id");
				String productName = resultSet.getString("product_name");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				int stockQuantity = resultSet.getInt("stock_quantity");
				
				product = new Product(productId, productName, category, price, stockQuantity);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//select �ؼ� 1���� �� �� �ִ� ���� �ۼ��ϰ�
		//new product �̿��ؼ� �� ������ ����
		return product;
	}
	 //������Ʈ�� �ϱ� ���� ������ �߰�
    public void updateProduct(Product product) {
        String UPDATE_PRODUCT = "UPDATE products SET product_name=?, category=?, price=?, stock_quantity=? WHERE product_id=?";
    	try {
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement ps = conn.prepareStatement(UPDATE_PRODUCT);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getCategory());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getStockQuantity());
			ps.setInt(5, product.getProductId());
			
			ps.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	//����� �߰��ϴ� DB�� Insert��
	public void addComment(ProductComment comment) {
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "INSERT INTO product_comments (comment_id, product_id, commenter_name, comment_text, comment_date) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, comment.getCommentId());
			ps.setInt(2, comment.getProductId());
			ps.setString(3, comment.getCommenterName());
			ps.setString(4, comment.getCommentText());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��� ��ü ����ϴ� �޼���
	public ArrayList<ProductComment> getCommentByProductId(int productId) {
		ArrayList<ProductComment> commentList = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM product_comments WHERE product_id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				int commentId = resultSet.getInt("comment_id");
				String commenterName = resultSet.getString("commenter_name");
				String commentText = resultSet.getString("comment_text");
				Timestamp commentDate = resultSet.getTimestamp("comment_date");
				
				ProductComment comment = new ProductComment(commentId,productId,commenterName,commentText,commentDate);
				commentList.add(comment);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return commentList;
	}
	
}
