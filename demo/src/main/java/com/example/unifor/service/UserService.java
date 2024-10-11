package com.example.unifor.service;

import com.example.unifor.entity.Skill;
import com.example.unifor.entity.User;
import com.example.unifor.repository.SkillRepository;
import com.example.unifor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillRepository skillRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updateUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updateUser.getName());
                    user.setEmail(updateUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User addSkillToUser(Long userId, Long skillId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));
        user.getSkills().add(skill);
        return userRepository.save(user);

    }

}
