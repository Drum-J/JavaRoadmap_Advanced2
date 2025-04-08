package reflection;

import reflection.data.Team;
import reflection.data.User;

public class FieldV3 {
    public static void main(String[] args) {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        // null일 경우 기본값 ("", 0)을 넣어줘야 한다고 가정하자.
        if (user.getId() == null) {
            user.setId("");
        }
        if (user.getName() == null) {
            user.setName("");
        }
        if (user.getAge() == null) {
            user.setAge(0);
        }

        if (team.getId() == null) {
            team.setId("");
        }
        if (team.getName() == null) {
            team.setName("");
        }

        System.out.println("===== after =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
    }
}
