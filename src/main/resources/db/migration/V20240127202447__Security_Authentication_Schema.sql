CREATE TABLE s_permissions
(
    id               character varying(255) NOT NULL,
    permission_label character varying(255) NOT NULL,
    permission_value character varying(255) NOT NULL,
    CONSTRAINT s_permissions_permission_label_check CHECK (((permission_label)::text = ANY ((ARRAY['PRODUCT_READ':: character varying, 'PRODUCT_WRITE':: character varying, 'EMPLOYE_READ':: character varying, 'EMPLOYE_WRITE':: character varying])::text[])
) ),
    CONSTRAINT s_permissions_permission_value_check CHECK (((permission_value)::text = ANY ((ARRAY['PRODUCT::READ'::character varying, 'PRODUCT::WRITE'::character varying, 'EMPLOYE::READ'::character varying, 'EMPLOYE::WRITE'::character varying])::text[])))
);

CREATE TABLE s_roles
(
    id   character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    unique (name),
    CONSTRAINT s_roles_name_check CHECK (((name)::text = ANY ((ARRAY['ADMIN':: character varying, 'EMPLOYE':: character varying])::text[])
) )
);

CREATE TABLE s_roles_permissions
(
    id_role       character varying(255) NOT NULL,
    id_permission character varying(255) NOT NULL
);

CREATE TABLE s_users
(
    id       character varying(255) NOT NULL,
    active   boolean,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    id_role  character varying(255) NOT NULL,
    unique (username)
);


ALTER TABLE ONLY s_permissions
    ADD CONSTRAINT s_permissions_pkey PRIMARY KEY (id);

ALTER TABLE ONLY s_roles_permissions
    ADD CONSTRAINT s_roles_permissions_pkey PRIMARY KEY (id_role, id_permission);

ALTER TABLE ONLY s_roles
    ADD CONSTRAINT s_roles_pkey PRIMARY KEY (id);

ALTER TABLE ONLY s_users
    ADD CONSTRAINT s_users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY s_users
    ADD CONSTRAINT fk4k103cqcehdbobgrydgsa44gu FOREIGN KEY (id_role) REFERENCES public.s_roles(id);

ALTER TABLE ONLY s_roles_permissions
    ADD CONSTRAINT fk58sqqjg0ldl3phs2fqbm6c19c FOREIGN KEY (id_role) REFERENCES public.s_roles(id);

ALTER TABLE ONLY s_roles_permissions
    ADD CONSTRAINT fkiqxh1rv3syrwn7cagiebq9es7 FOREIGN KEY (id_permission) REFERENCES public.s_permissions(id);

