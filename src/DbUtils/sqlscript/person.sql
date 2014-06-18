CREATE TABLE person ( 
     id char(5) NOT NULL, 
     name varchar2(30) NULL, 
     age smallint NULL, 
     address varchar2(120) NULL, 
     constraint pk_person primary key (id)
) 