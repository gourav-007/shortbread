package org.selenium.pom.objects;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;

    public User(int id) throws IOException {
        User [] users = JacksonUtils.deSerialize("user.json", User[].class);
        for (User user:users){
            if (user.getId()==id){
                this.username=user.getUsername();
                this.password=user.getPassword();
            }
        }
    }
}
