package traveller.com.travelplanner.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RouteDao {

    /**
     *
     * @param attractions an array of attraction id
     * @return an array of attraction id that is shuffled
     */
    public String[] generateRoute(String[] attractions) {
        List<String> attList = Arrays.asList(attractions);
        Collections.shuffle(attList);
        return attList.toArray(new String[attList.size()]);
    }
}
