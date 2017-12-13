package tools;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import pojo.User;

public class UserMatcher extends TypeSafeMatcher<User> {
    private User m_user;

    public UserMatcher(User m_user) {
        this.m_user = m_user;

    }

    @Override
    public boolean matchesSafely(User user) {

        return m_user.equals(user);
    }

    @Override
    public void describeTo(Description description) {

    }
}
