package com.memo.post.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data // Getter, Setter 둘 다 가지고 있음
public class Post {
	private int id;
	private int userId;
	private String subject;
	private String content;
	private String imagePath;
	private Date createdAt;
	private Date updatedAt;
} // public class Post