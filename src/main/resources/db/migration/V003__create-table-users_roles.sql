CREATE TABLE public.users_roles (
	user_id int8 NOT NULL,
	roles_id int8 NOT NULL
);

ALTER TABLE public.users_roles ADD CONSTRAINT fk2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES public.users(id);
ALTER TABLE public.users_roles ADD CONSTRAINT fka62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id) REFERENCES public.roles(id);