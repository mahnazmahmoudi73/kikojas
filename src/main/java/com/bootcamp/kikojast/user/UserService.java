package com.bootcamp.kikojast.user;

import com.bootcamp.kikojast.commen.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository repository;


    @Override
    public User save(User user) {
        return repository.save(user);
    }


    @Override
    public User update(User user) {
        User lastUser=  getById(user.getId());
        lastUser.setName(user.getName());
        lastUser.setPassword(user.getPassword());
        lastUser.setEmailOrPhone(user.getEmailOrPhone());
        lastUser.setProfile(user.getProfile());

        return repository.save(lastUser);
    }


    @Override
    public void delete(Long id) {
        Optional<User> optionalUser=repository.findById(id);

        if (!optionalUser.isPresent()){

            throw new NotFoundException("User Not Found");
        }
        repository.deleteById(id);
    }


    @Override
    public User getById(Long id) {
        Optional<User> optionalUser=repository.findById(id);

        if (!optionalUser.isPresent()){

            throw new NotFoundException("User Not Found");
        }


        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

}