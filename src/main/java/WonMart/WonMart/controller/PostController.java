package WonMart.WonMart.controller;

import WonMart.WonMart.domain.Post;
import WonMart.WonMart.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController { // 게시글 생성, 게시글 조회

    private final PostService postService;

    @GetMapping("/post/new")
    public String createPost(Model model) {
        model.addAttribute("form", new PostForm());
        return "post/createPostForm";
    }

    @PostMapping("/post/new")
    public String create(PostForm form) {
        postService.post(form.getNickName(), form.getTitle(), form.getPrice(), form.getBody());

        return "redirect:/";
    }

    @GetMapping("/post")
    public String posts(Model model) {
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);

        return "post/postList";
    }

}
