package com.example.unifor.service;

import com.example.unifor.entity.UserProfile;
import com.example.unifor.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfile> findAllUserProfile(){
        return userProfileRepository.findAll();
    }

    public Optional<UserProfile> findUserProfileById(Long id){
        return userProfileRepository.findById(id);
    }

    public UserProfile saveUserProfile(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

    public void deleteUserProfile(Long id){
        userProfileRepository.deleteById(id);
    }

}
