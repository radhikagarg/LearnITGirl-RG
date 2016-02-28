package learnit.model;

import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

/**
 * Created by radhikagarg on 2/28/16.
 */
public class LoginModel {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private String message2;

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
}