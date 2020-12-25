package me.bumblebee.commonweb.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostRepository posts;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable("id") Post post) {
        // spring jpa가 지원해주는 도메일 클래스 컨버터 기능
        return post.getTitle();
    }

    @GetMapping("/posts")
    public PagedModel<EntityModel<Post>> getPosts(Pageable pageable, PagedResourcesAssembler<Post> assembler) {
//      스프링 버전 올라가면서 변경됨
//      PagedResources -> PageModel
//      Resource -> EntityModel

//         페이징과 정렬 관련 매개변수
//        - page : 0부터 시작
//        - size : 기본값 20
//        - sort : property.property(.ASC|DESC)
//        - 예) sort = created, desc&asc=title (asc 기본값)
//        Sort만 사용할 수 있으나, pageable 항상 쓰는 게 좋다. sorting도 가능하니까
        return assembler.toModel(posts.findAll(pageable));
    }

}
