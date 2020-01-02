FROM mysql:5.7

ADD ./mysql/sql-mode.cnf /etc/mysql/conf.d/sql-mode.cnf
ADD ./mysql /docker-entrypoint-initdb.d

CMD ["mysqld"]
