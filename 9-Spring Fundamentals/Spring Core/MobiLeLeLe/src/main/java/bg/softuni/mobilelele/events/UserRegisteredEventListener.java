package bg.softuni.mobilelele.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventListener implements ApplicationListener<UserRegisteredEvent> {
    @Override
    public void onApplicationEvent(UserRegisteredEvent event) {
        System.out.println("Successfully registered " + event.getUsername());
    }
}
