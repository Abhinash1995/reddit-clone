package com.abhinash.RedditcCone.mapper;

import com.abhinash.RedditcCone.dto.PostDto;
import com.abhinash.RedditcCone.dto.PostResponse;
import com.abhinash.RedditcCone.model.Post;
import com.abhinash.RedditcCone.model.Subreddit;
import com.abhinash.RedditcCone.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")//annotation to specify that this interface is a Mapstruct Mapper and Spring
// should identify it as a component and should be able to inject it into other components like SubredditService.
public abstract class PostMapper {



////    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    public abstract Post map(PostDto postRequest, Subreddit subreddit, User user);


//    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
//    @Mapping(target = "duration", expression = "java(getDuration(post))")
//    @Mapping(target = "upVote", expression = "java(isPostUpVoted(post))")
//    @Mapping(target = "downVote", expression = "java(isPostDownVoted(post))")

    @Mappings({
            @Mapping(source = "postId", target = "id"),
            @Mapping(source = "subreddit.name", target = "subredditName"),
            @Mapping(target = "userName", source = "user.username")
    })
    public abstract PostResponse mapToDto(Post post);
}
