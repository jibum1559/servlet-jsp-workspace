package com.kh.product;

import java.sql.Timestamp;

public class ProductComment {
/*
comment_id: 댓글 식별자
product_id: 제품 테이블의 product_id와 외래 키(Foreign Key)로 연결
commenter_name: 댓글을 작성한 사용자의 이름
comment_text: 실제 댓글 내용
comment_date: 댓글 작성 일시 
 */
	private int commentId;
	private int productId;
	private String commenterName;
	private String commentText;
	private Timestamp commentDate;
	
	//값을 저장하고 저장된 내용을 보내기 위한 생성자
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
