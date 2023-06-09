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

    public Forum findOrThrow(final UUID id){
        return forum_repository
                .findById(id)
                .orElseThrow(
                        ()->new NoSuchElementException("No such id was found with this number + " + id)
                );
    }
    public Iterable<Forum> findAllForums(){
        return forum_repository.findAll();
    }
    public Forum findForumById(UUID id){
        return findOrThrow(id);
    }
    public void removeForum(UUID id){
        forum_repository.deleteById(id);
    }
    public Forum addForum(Forum forum){
        return forum_repository.save(forum);
    }
    public void updateForum(UUID id, Forum forum){
        findForumById(id);
        forum_repository.save(forum);
    }
}
