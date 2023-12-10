package com.allenchan.chatserver.controllers;
import org.junit.jupiter.api.Test;
import com.allenchan.chatserver.controllers.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatControllerTest {

    @InjectMocks
    private ChatController chatController;

    @Mock
    private SimpMessagingTemplate simpMessagingTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(chatController, "simpMessagingTemplate", simpMessagingTemplate);
    }

    @Test
    public void testReceiveMessage() {
        Message message = new Message(); // Create a sample message for testing

        // Call the method being tested
        Message result = chatController.receiveMessage(message);

        // Assert the expected result
        assertEquals(message, result);
    }

    @Test
    public void testRecMessage() {
        Message message = new Message(); // Create a sample message for testing

        // Call the method being tested
        Message result = chatController.recMessage(message);

        // Assert the expected result
        assertEquals(message, result);
    }
}