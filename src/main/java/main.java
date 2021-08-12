import com.rush_xxx.model.Developer;
import com.rush_xxx.model.Skill;
import com.rush_xxx.model.Team;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        Skill skill1 = new Skill(1, "Java");
        List<Skill> skillsList = new ArrayList<>();
        skillsList.add(skill1);

        Developer dev1 = new Developer(1, "John", "Connor", skillsList);
        List<Developer> developerList = new ArrayList<>();
        developerList.add(dev1);

        Team team1 = new Team(1, "Team1", developerList);

        System.out.println("Team - " + team1.getName());
        for (Developer developer: team1.getDevelopers()) {
            System.out.println("developer ID - " + developer.getId());
            System.out.println("developer FirstName - " + developer.getFirstName());
            System.out.println("developer LastName - " + developer.getLastName());
        }

    }
}
