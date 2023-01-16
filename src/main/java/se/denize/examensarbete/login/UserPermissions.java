package se.denize.examensarbete.login;

public enum UserPermissions {

        USER_READ("user:read"),
        ADMIN_READ("admin:read"),
        ADMIN_WRITE ("admin:write");

        private final String permission;

        UserPermissions (String permission) {
            this.permission = permission;
        }

        public String getPermission () {
            return permission;
        }

    }
