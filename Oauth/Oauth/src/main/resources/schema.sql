create table `user`(
    id varchar(20),
    password varcher(100)
    nickname varchar(100)
    state char(1)
)

    # mysql start
mysql.server start

$ mysql -u root -p
root@1234

mysql> create database oauth2;
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| oauth2             |
+--------------------+
9 rows in set (0.01 sec)

mysql> use oauth2;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A
Database changed

mysql> create table user(
                                    id varchar(20),
                                    password varchar(100),
                                    nickname varchar(100),
                                    state char(1)
       );

mysql> show tables;
+------------------+
| Tables_in_oauth2 |
+------------------+
| user             |
+------------------+
1 row in set (0.00 sec)

mysql> desc user;
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| id       | varchar(20)  | YES  |     | NULL    |       |
| password | varchar(100) | YES  |     | NULL    |       |
| nickname | varchar(100) | YES  |     | NULL    |       |
| state    | char(1)      | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> insert into user values ('yoolee','{noop}yoolee','corin','Y');
Query OK, 1 row affected (0.01 sec)

mysql> select * from user;
+--------+----------+----------+-------+
| id     | password | nickname | state |
+--------+----------+----------+-------+
| yoolee | {noop}yoolee   | corin    | Y     |
+--------+----------+----------+-------+
1 row in set (0.00 sec)
