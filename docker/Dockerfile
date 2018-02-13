FROM openjdk:9
COPY . JdbcNetPerfServer
RUN mkdir /JdbcNetPerfServer/out
RUN cd /JdbcNetPerfServer/src \
    && javac -d ../out *.java
EXPOSE 8888
WORKDIR /JdbcNetPerfServer/out
CMD java Main
