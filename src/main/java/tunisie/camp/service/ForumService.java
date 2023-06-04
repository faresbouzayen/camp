package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Forum;
import tunisie.camp.repository.ForumRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ForumService {
    private ForumRepository forum_repository;
    @Autowired
    public ForumService(ForumRepository forum_repository){
        this.forum_repository = forum_repository;
    }

    public Forum findOrThrow(final UUID forum_id){
        return forum_repository
                .findById(forum_id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + forum_id)
                );
    }
    public Iterable<Forum> findAllForums(){
        return forum_repository.findAll();
    }
    public Forum findForumById(UUID forum_id){
        return findOrThrow(forum_id);
    }
    public void removeForum(UUID forum_id){
        forum_repository.deleteById(forum_id);
    }
    public Forum addForum(Forum forum){
        return forum_repository.save(forum);
    }
    public void updateForum(UUID forum_id, Forum forum){
        findForumById(forum_id);
        forum_repository.save(forum);
    }
}
