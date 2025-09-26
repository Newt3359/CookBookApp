CREATE SEQUENCE IF NOT EXISTS recipe_id_seq;
ALTER TABLE recipe
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE recipe
    ALTER COLUMN id SET DEFAULT nextval('recipe_id_seq');

ALTER SEQUENCE recipe_id_seq OWNED BY recipe.id;