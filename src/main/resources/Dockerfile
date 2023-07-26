FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB itjobs
COPY 01-init-db.sql /docker-entrypoint-initdb.d/

ENTRYPOINT ["top", "-b"]