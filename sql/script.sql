create user 'jeeproject'@'localhost' IDENTIFIED by 'jeeproject';
create DATABASE 'jeeproject';
grant all privileges on jeeproject.* to 'jeeproject'@'localhost' with grant option;