package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import ImageHoster.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;



    @RequestMapping(value = "/image/{id}/{title}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable("id") String id,@RequestParam("comment") String comment, HttpSession session) throws IOException {

        User user = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImage(Integer.parseInt(id));
        Comment newComment = new Comment();
        newComment.setUser(user);
        newComment.setImage(image);
        newComment.setText(comment);
        newComment.setCreatedDate(LocalDate.now());
        commentService.createComment(newComment);
        session.setAttribute("image",image);
        return "redirect:/images/"+id+"/"+image.getTitle();
    }

}
