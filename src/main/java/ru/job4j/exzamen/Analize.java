package ru.job4j.exzamen;

import java.util.*;

public class Analize {
    int added;
    int changed;
    int deleted;

    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> map = new HashMap<>();
        for (User prev : previous) {
            map.put(prev.getId(), prev);
        }
        for (User curr : current) {
            if (map.containsKey(curr.getId())) {
                if (!map.containsValue(curr)) {
                    changed++;
                }
                added++;
            }
        }
        deleted = added - map.size() + changed;
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return added == info.added &&
                    changed == info.changed &&
                    deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
