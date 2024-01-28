package com.mrizkisaputra.auth.query;

import lombok.Getter;

@Getter
public enum ApplicationUserQuery {
    SQL_LOGIN("""
                select username, password, active
                from s_users
                where username = ?;
            """),

    SQL_PERMISSION("""
                select
                    s_users.username,
                    s_permissions.permission_value as authority
                from s_users
                inner join s_roles on s_users.id_role = s_roles.id
                inner join s_roles_permissions on s_roles.id = s_roles_permissions.id_role
                inner join s_permissions on s_roles_permissions.id_permission = s_permissions.id
                where username = ?;
            """);

    private final String query;

    private ApplicationUserQuery(String query) {
        this.query = query;
    }
}
