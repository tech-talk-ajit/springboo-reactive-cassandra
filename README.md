This is spring boot reactive cassandra project. reactive Cassandra connection is created manually so that user id and password can be fetched from some external config sore and 
used rather setting it through spring data jpa

use the below cassandra query
also you can find the docker compose to run cassandta on docker

use cassandra_test

CREATE TABLE employee(
id int PRIMARY KEY,
name TEXT,
address TEXT,
email TEXT,
age int);
