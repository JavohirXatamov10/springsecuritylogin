package org.example.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.entity.MyUser;
import org.example.entity.Role;
import org.example.entity.UserRole;
import org.example.repo.RoleRepo;
import org.example.repo.UserRepo;
import org.example.repo.UserRoleRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Runnable {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final UserRoleRepo userRoleRepo;
    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    public void run(){
      List<MyUser> users= userRepo.findByAll();
      if(users.isEmpty()){
          Role role1=new Role("ROLE_STUDENT");
          Role role2=new Role("ROLE_ADMIN");
          Role role3=new Role("ROLE_OPERATOR");
          Integer roleId1 = roleRepo.save(role1);
          Integer roleId2 = roleRepo.save(role2);
          Integer roleId3 = roleRepo.save(role3);

          MyUser myUser1=new MyUser("1234", passwordEncoder.encode( "root123"),"Javohir Hatamov");
          MyUser myUser2=new MyUser("4321", passwordEncoder.encode( "root321"), "Jahongir Hatamov");
          MyUser myUser3=new MyUser( "1243", passwordEncoder.encode( "root213"), "Nurshod Hatamov");

          Integer userId1 = userRepo.save(myUser1);
          Integer userId2 = userRepo.save(myUser2);
          Integer userId3 = userRepo.save(myUser3);

          userRoleRepo.save(userId1,roleId1);
          userRoleRepo.save(userId2,roleId2);
          userRoleRepo.save(userId3,roleId3);


      }
    }
}
