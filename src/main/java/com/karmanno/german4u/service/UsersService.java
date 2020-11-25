package com.karmanno.german4u.service;

import com.karmanno.german4u.model.TelegramUser;
import com.karmanno.german4u.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsersService {
    private final UsersRepository usersRepository;

    public TelegramUser findOrCreateUser(TelegramUser user) {
        if (!usersRepository.existsByUsername(user.getUsername())) {
            log.info("User with username {} not found, creating...", user.getUsername());
            return usersRepository.save(user);
        }
        log.info("User with username {} found", user.getUsername());
        return usersRepository.findByUsername(user.getUsername())
                .orElseThrow();
    }
}
