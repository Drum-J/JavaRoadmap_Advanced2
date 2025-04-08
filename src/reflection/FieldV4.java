package reflection;

import reflection.data.Team;
import reflection.data.User;

// User, Team 데이터 중 null인 경우 기본값("", 0)을 넣어줘야 한다고 가정하자.
public class FieldV4 {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("id1", null, null);
        Team team = new Team("team1", null);

        System.out.println("===== before =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);

        FieldUtil.nullFieldToDefault(user);
        FieldUtil.nullFieldToDefault(team);

        System.out.println("===== after =====");
        System.out.println("user = " + user);
        System.out.println("team = " + team);
    }
}
