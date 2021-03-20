package com.DAI.ProChild;
import com.DAI.ProChild.Kid.Kid;
import com.DAI.ProChild.User.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserTest {
    @Test
    public void getNomeTest() {
        User user = new User("João", "joaoCarvalho@hotmail.com", "Pai", "gasd", 91929193);
        assertEquals(user.getNome(), "João");
    }
}
