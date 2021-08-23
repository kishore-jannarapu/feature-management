insert into user(user_name,email) values ('user1','user1@email.com');
insert into user(user_name,email) values ('user2','user2@email.com');
insert into feature(feature_name,feature_description) values('feature1','Feature1 Description');
insert into feature(feature_name,feature_description) values('feature2','Feature2 Description');
insert into user_feature(user_id,feature_id,enable) values(1,1,true);
insert into user_feature(user_id,feature_id,enable) values(1,2,false);
insert into user_feature(user_id,feature_id,enable) values(2,1,false);
insert into user_feature(user_id,feature_id,enable) values(2,2,true);
