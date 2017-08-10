package com.feedme.feedme.user.usecase;


import com.feedme.feedme.common.domain.usecase.SingleUseCase;
import com.feedme.feedme.user.domain.model.User;
import com.feedme.feedme.user.repository.UserRepository;

import io.reactivex.Observable;
import io.reactivex.Single;


public class GetUsers extends SingleUseCase<User> {

    private final UserRepository userRepository;

    public GetUsers(UserRepository dataRepository) {
        this.userRepository = dataRepository;
    }

    public Single<User> execute() {
        return userRepository.getUser();
    }
}
