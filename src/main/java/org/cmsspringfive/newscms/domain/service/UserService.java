package org.cmsspringfive.newscms.domain.service;

import org.cmsspringfive.newscms.domain.exceptions.UserNotFoundException;
import org.cmsspringfive.newscms.domain.models.User;
import org.cmsspringfive.newscms.domain.repository.UserRepository;
import org.cmsspringfive.newscms.domain.vo.UserRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User update(String id, UserRequest userRequest){
        final Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            final User userDB = new User();
            userDB.setUserIdentity(userRequest.getIdentity());
            userDB.setUserName(userRequest.getName());
            userDB.setUserRole(userRequest.getRole());
            return this.userRepository.save(userDB);
        }else{
            throw new UserNotFoundException("User with id " + id + " not found.");
        }

    }

    @Transactional
    public User create(UserRequest userRequest){
        User user = new User();
        user.setUserIdentity(userRequest.getIdentity());
        user.setUserName(userRequest.getName());
        user.setUserRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    @Transactional
    public void removeUser(String id){
        final Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            final User userDB = user.get();
             this.userRepository.delete(userDB);
        }else{
            throw new UserNotFoundException("User with id " + id + " not found.");
        }
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findOne(String id){
        final Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            final User userDB = new User();
            return userDB;
        }else{
            throw new UserNotFoundException("User with id " + id + " not found.");
        }

    }

}
