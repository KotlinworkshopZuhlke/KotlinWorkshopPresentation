package com.zuehlke.kotlinworkshop.task;

class Task1 {
    private static class UserJava {
        public final int id;
        public final String name;
        public final String email;
        private boolean isActive;

        private UserJava(int id, String name, String email, boolean isActive) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.isActive = isActive;
        }

        public void activate() {
            this.isActive = true;
        }

        public void deactivate() {
            this.isActive = false;
        }

        public String getUserInfo() {
            return String.format("ID: %d, Name: %s, Email: %s, Active: %s", id, name, email, isActive);
        }

        @Override
        public String toString() {
            return getUserInfo();
        }
    }

    static class AdminUserJava extends UserJava {
        private AdminUserJava(int id, String name, String email) {
            super(id, name, email, true); // default isActive to true
        }
    }

    static class GuestUserJava extends UserJava {
        private GuestUserJava(int id, String name, String email) {
            super(id, name, email, true); // default isActive to true
        }
    }

    public static void main(String[] args) {
        UserJava userOne = new UserJava(1, "Bob", "bob.alice@zuehlke.com", true);
        AdminUserJava userTwo = new AdminUserJava(2, "Alice", "alice@example.com");
        GuestUserJava userThree = new GuestUserJava(3, "Charlie", "charlie@example.com");

        System.out.println(userOne);
        System.out.println(userTwo);
        System.out.println(userThree);
    }
}