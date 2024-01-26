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
	
	// input : userId(로그인된 사람), prevId, nextId, limit(POST_MAX_SIZE) / output : List<Post>
	public List<Post> selectPostListByUserId(
			@Param("userId") int userId,
			@Param("standardId") Integer standardId,
			@Param("direction") String direction,
			@Param("limit") int limit);
	
	// 이전 or 다음 페이지의 마지막인지 확인
	// input : userId, sort(DESC OR ASC) / output : int
	public int selectPostIdByUserIdSort(
			@Param("userId") int userId,
			@Param("sort") String sort);
	
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