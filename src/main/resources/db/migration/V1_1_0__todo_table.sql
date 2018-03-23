CREATE TABLE public.todo(
  id SERIAL PRIMARY KEY,
  name TEXT,
  description TEXT,
  done boolean
);