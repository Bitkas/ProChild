package com.DAI.ProChild;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.User.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class UserTest {
    @Test
    public void getNomeTest() {
        User user = new User("João", "joaoCarvalho@hotmail.com", "Pai", "gasd", 91929193);
        assertEquals("João", user.getNome());
    }

    @Test
    public void loginTest() {
        User caller = new User("João", "joaoCarvalho@hotmail.com", "Pai", "gasd", 91929193);
        User dbUser = new User("João", "joaoCarvalho@hotmail.com", "Pai", "gasd", 91929193);
        User dbUserToFalse = new User("João", "joao@hotmail.com", "Pai", "gasd", 91929193);
        assertTrue(caller.login(dbUser));
        assertFalse(caller.login(dbUserToFalse));
    }
}
