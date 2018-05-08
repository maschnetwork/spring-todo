CREATE TABLE IF NOT EXISTS public.todo(
  id SERIAL PRIMARY KEY,
  name TEXT,
  description TEXT,
  done boolean
);