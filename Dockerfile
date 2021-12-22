#
# Build stage
#
FROM ttbb/compile:jdk11-git-mvn AS build
COPY . /opt/sh/compile
WORKDIR /opt/sh/compile
RUN mvn -B clean package


FROM ttbb/hadoop:nake

LABEL maintainer="shoothzj@gmail.com"

COPY --from=build /opt/sh/compile/hadoop-mate/target/hadoop-mate-0.0.1.jar /opt/sh/hadoop/mate/hadoop-mate.jar

COPY docker-build /opt/sh/hadoop/mate

WORKDIR /opt/sh/hadoop

CMD ["/usr/bin/dumb-init", "bash", "-vx","/opt/sh/hadoop/mate/scripts/start.sh"]
