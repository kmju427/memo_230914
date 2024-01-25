package com.memo.post.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.memo.post.domain.Post;

@Mapper
public interface PostMapper {
	
	// input : X / output : List<Map> - 테스트용
	public List<Map<String, Object>> selectPostList();
	
	// input : userId(로그인된 사람) / output : List<Post>
	public List<Post> selectPostListByUserId(int userId);
	
	// input : userId, subject, content, imagePath / output : X
	public void insertPost(
			@Param("userId") int userId,
			@Param("subject") String subject, 
			@Param("content") String content,
			@Param("imagePath") String imagePath);
	
	// input : postId, userId / output : Post
	public Post selectPostByPostIdUserId(
			@Param("postId") int postId, 
			@Param("userId") int userId);
	
	// input : postId, subject, content, imagePath / output : X
	public void updatePostByPostId(
			@Param("postId") int postId, 
			@Param("subject") String subject, 
			@Param("content") String content,
			@Param("imagePath") String imagePath);
	
	// input : postId / output : int
	public int deletePostByPostId(int postId);
	
} // public interface PostMapper