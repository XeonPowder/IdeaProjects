package manager;

import activity.Activity;

public class ActivityManager {

    private java.util.HashMap<java.util.UUID, activity.Activity> registry = new java.util.HashMap<>(0);

    public Activity registerActivity(Activity activity) {
        registry.put(activity.getUuid(), activity);
        return getActivity(activity.getUuid());
    }

    public Activity getActivity(java.util.UUID uuid) {
        return registry.get(uuid);
    }

    public java.util.Collection<Activity> getActivities() {
        return registry.values();
    }
}
