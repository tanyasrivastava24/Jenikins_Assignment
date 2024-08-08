package com.magicalarena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArenaTest {

    private Arena arena;
    private Player spyPlayerA;
    private Player spyPlayerB;

    @BeforeEach
    public void setUp() {
        arena = new Arena();
        spyPlayerA = spy(new Player(50, 5, 10));
        spyPlayerB = spy(new Player(100, 10, 5));
    }

    @Test
    public void testFight() {
        // Simulate fight
        arena.fight(spyPlayerA, spyPlayerB);

        // Verify that health was set to 0 or less for one of the players
//        verify(spyPlayerA, atLeastOnce()).setHealth(argThat(health -> health <= 0));
//        verify(spyPlayerB, atLeastOnce()).setHealth(argThat(health -> health <= 0));

        // Additional assertions to verify game logic
        assertTrue(spyPlayerA.getHealth() <= 0 || spyPlayerB.getHealth() <= 0);
    }
}
