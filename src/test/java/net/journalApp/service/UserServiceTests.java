package net.journalApp.service;

import net.journalApp.entity.User;
import net.journalApp.repository.UserRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTests {
    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ValueSource(strings = {
            "Jack",
            "Harsh",
            "Ayush"
    })
    void testFindByUsername(String username){
        User actualUser = userRepository.findByUsername(username);
        assertNotNull(actualUser);
        assertFalse(actualUser.getJournalEntries().isEmpty());//user's journal entries present? TRUE : FALSE
    }
}
