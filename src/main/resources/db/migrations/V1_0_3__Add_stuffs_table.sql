create table if not exists stuffs(
  id uuid default uuid_generate_v4(),
  user_name varchar not null,
  user_pass varchar not null,
  user_role varchar not null,
  primary key(id));

insert into stuffs(user_name, user_pass, user_role) values
  ('Ihor_Bibichkov', crypt('root_password', gen_salt('bf')), 'ROLE_ROOT'),
  ('Yevhen_Shlikov', crypt('admin_password2', gen_salt('bf')), 'ROLE_ADMIN'),
  ('Svitlana', crypt('user_password', gen_salt('bf')), 'ROLE_USER');
