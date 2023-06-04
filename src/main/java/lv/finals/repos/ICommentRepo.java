package lv.finals.repos;

import org.springframework.data.repository.CrudRepository;

import lv.finals.models.Comment;

public interface ICommentRepo extends CrudRepository<Comment, Long>{

}