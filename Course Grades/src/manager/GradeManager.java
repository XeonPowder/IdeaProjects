package manager;

import activity.GradedActivity;

public class GradeManager {
    private java.util.HashMap<person.Person, java.util.ArrayList<activity.GradedActivity>> registry = new java.util.HashMap<>(0);

    public GradedActivity registerGradedActivity(person.Person p, activity.GradedActivity ga) {
        if (!registry.containsKey(p)) {
            registry.put(p, new java.util.ArrayList<>(java.util.Arrays.asList(ga)));
        } else {
            registry.get(p).add(ga);
        }
        return getGradedActivity(p, ga.getUuid());
    }
    public GradedActivity getGradedActivity(person.Person p, java.util.UUID activityUuid) {
        int index = 0;
        for(GradedActivity ga : registry.get(p)) {
            if (ga.getUuid() == activityUuid) {
                index = registry.get(p).indexOf(ga);
            }
        }
        return registry.get(p).get(index);
    }

}
