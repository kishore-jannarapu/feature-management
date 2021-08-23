create table user(user_id number(10) primary key auto_increment,user_name varchar(200) not null,email varchar(200) not null);
create table feature(feature_id number(10) primary key auto_increment,feature_name varchar(100) not null,feature_description varchar(500));
create table user_feature(id number(15) primary key auto_increment,user_id number(10) references user(user_id),feature_id number(10) references feature(feature_id),enable boolean not null,unique(user_id,feature_id));
