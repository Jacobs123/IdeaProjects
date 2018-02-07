package shopapp.shopplanner.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document
public class User {

    @Id
    private String id;
    private String name;
    private String surname;
    private String login;
    private String password;
}
