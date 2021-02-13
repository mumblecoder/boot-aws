package com.example.boot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "TEST";

        postsRepository.save(Posts.builder().title(title)
                                            .content(content)
                                            .author("mumblecoder")
                                            .build()
        );

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {

        LocalDateTime now = LocalDateTime.of(2021, 2, 13, 0,0,0);
        postsRepository.save(Posts.builder().title("tt").content("cc").author("aa").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>> createDate : " +posts.getCreatedDate() + ", modifiedDate : " + posts.getModifiedDate());

        Assertions.assertThat(posts.getCreatedDate().isAfter(now));
        Assertions.assertThat(posts.getModifiedDate().isAfter(now));


    }
}
