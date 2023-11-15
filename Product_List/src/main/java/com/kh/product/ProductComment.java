package com.kh.product;

import java.sql.Timestamp;

public class ProductComment {
/*
comment_id: ��� �ĺ���
product_id: ��ǰ ���̺��� product_id�� �ܷ� Ű(Foreign Key)�� ����
commenter_name: ����� �ۼ��� ������� �̸�
comment_text: ���� ��� ����
comment_date: ��� �ۼ� �Ͻ� 
 */
	private int commentId;
	private int productId;
	private String commenterName;
	private String commentText;
	private Timestamp commentDate;
	
	//���� �����ϰ� ����� ������ ������ ���� ������
	public ProductComment(int commentId, int productId, String commenterName, String commentText, Timestamp commentDate) {
		this.commentId = commentId;
		this.productId = productId;
		this.commenterName = commenterName;
		this.commentText = commentText;
		this.commentDate = commentDate;
	}
	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCommenterName() {
		return commenterName;
	}
	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
}
