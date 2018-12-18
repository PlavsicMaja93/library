insert into student
values(10001,'Sladja', 'Informatika');

insert into student
values(10002,'Drazo', 'Matematika');

insert into student
values(10003,'Jovo', 'Biologija');

insert into student
values(10004,'Zoka', 'Matematika');

insert into student
values(100025,'Mladjo', 'Informatika');

insert into student
values(10006,'Alen', 'Geografija');

insert into student
values(10007,'Tetak', 'Geografija');

insert into autor(id,ime)
values(50,'P.Petrovic');

insert into autor(id,ime)
values(51,'M.Markovic');

insert into autor(id,ime)
values(52,'D.Dacic');

insert into autor(id,ime)
values(53,'L.Lazic');

insert into autor(id,ime)
values(54,'R.Radic');

insert into knjiga(id, naziv, autor_id)
values(2001,'Algebra', 50);

insert into knjiga(id, naziv, autor_id)
values(2002,'Algebra', 50);

insert into knjiga(id, naziv, autor_id)
values(2003,'Algebra', 50);

insert into knjiga(id, naziv, autor_id)
values(2004,'Algebra', 51);

insert into knjiga(id, naziv, autor_id)
values(2005,'Geomorfologija', 52);

insert into knjiga(id, naziv, autor_id)
values(2006,'Genetika', 53);

insert into knjiga(id, naziv, autor_id)
values(2007,'Genetika', 53);

insert into knjiga(id, naziv, autor_id)
values(2008,'Genetika', 54);

insert into knjiga(id, naziv, autor_id)
values(2009,'Genetika', 54);

insert into servis(id,student_index_id,knjiga_id)
values(1,10002,2009);
insert into servis(id,student_index_id,knjiga_id)
values(2,10004,2003);
insert into servis(id,student_index_id,knjiga_id)
values(3,10006,2004);
insert into servis(id,student_index_id,knjiga_id)
values(4,10007,2002);



