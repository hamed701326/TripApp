package org.payaneh.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.payaneh.entities.User;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void valid() {
        UserRepository userRep=UserRepository.getUserRepository();
        User user=new User("hamed12","123","hamed","sadeghi",605);
        userRep.save(user);

        assertEquals(userRep.valid(user),true);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
    }
}