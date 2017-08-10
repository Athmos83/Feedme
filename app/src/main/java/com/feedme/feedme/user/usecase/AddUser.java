package com.feedme.feedme.user.usecase;

import com.feedme.feedme.common.domain.usecase.ObservableFromConsumerUseCase;
import com.feedme.feedme.user.domain.model.User;
import com.feedme.feedme.user.repository.UserRepository;

import io.reactivex.Observable;

/**
 * Created by Athmos on 26/05/2017.
 */

public class AddUser {

    private final UserRepository userRepository;
    private User user;

    public AddUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Observable<User> execute() {
        return userRepository.addUser(user);
    }
}
