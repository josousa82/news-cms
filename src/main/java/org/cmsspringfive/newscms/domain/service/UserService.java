package org.cmsspringfive.newscms.domain.service;

import org.cmsspringfive.newscms.domain.exceptions.UserNotFoundException;
import org.cmsspringfive.newscms.domain.models.User;
import org.cmsspringfive.newscms.domain.repository.UserRepository;
import org.cmsspringfive.newscms.domain.voDtos.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User update(String id, UserRequest userRequest){

        final Optional<User> user = Optional.ofNullable(this.userRepository.findByUserId(id));
        if(user.isPresent()){
            final User userDB = new User();
            userDB.setUserIdentity(userRequest.getIdentity());
            userDB.setUserName(userRequest.getName());
            userDB.setUserRole(userRequest.getRole());
            return this.userRepository.save(userDB);
        }else{
            throw new UserNotFoundException(HttpStatus.NOT_FOUND, "User with id " + id + " not found.");
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
    public User removeUser(String id){
        final Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            final User userDB = user.get();
            userRepository.delete(userDB);
            return userDB;
        }else{
            throw new UserNotFoundException("User with id " + id + " not found.");
        }
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findUserById(String id){
        final Optional<User> user = Optional.ofNullable(userRepository.findByUserId(id));
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserNotFoundException(HttpStatus.NOT_FOUND, "User with id " + id + " not found.");
        }

    }

}
