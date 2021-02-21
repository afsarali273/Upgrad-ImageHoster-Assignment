package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentsRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    CommentsRepository commentsRepository;

    //The method calls the createNewComment() method in the Repository and passes the comment to be persisted in the database
    public void createComment(Comment comment) {
        commentsRepository.createNewComment(comment);
    }


}
