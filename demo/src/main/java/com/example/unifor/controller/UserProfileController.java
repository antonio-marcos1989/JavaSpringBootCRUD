package com.example.unifor.controller;

import com.example.unifor.entity.UserProfile;
import com.example.unifor.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-profiles")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @GetMapping
    public List<UserProfile> getAllUserProfile(){
        return userProfileService.findAllUserProfile();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long id){
        Optional<UserProfile> userProfile = userProfileService.findUserProfileById(id);
        return userProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile){
        return userProfileService.saveUserProfile(userProfile);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id){
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.noContent().build();
    }

}
