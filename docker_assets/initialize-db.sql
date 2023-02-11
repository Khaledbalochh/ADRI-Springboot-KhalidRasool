CREATE TABLE user (
    user_id SERIAL,
    user_name VARCHAR(20),
    email VARCHAR(40),
    information VARCHAR(300) 
);

INSERT INTO user(user_name, email, information) 
VALUES ('eslamallam', 'eslamallam@adri.nz', 'This is the creator of the test')
, ('Salman', 'salmanemail@adri.nz', "This is the guy that's testing you guys")
, ('Anotherguy', 'someguy@adri.nz', 'some description');