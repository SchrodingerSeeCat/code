FROM alpine:3.12.0
RUN echo -e "http://mirrors.aliyun.com/alpine/v3.12/main\nhttp://mirrors.aliyun.com/alpine/v3.12/community" > /etc/apk/repositories \
    && apk update \
    && apk add --no-cache openjdk8-jre \
    && mkdir mc
WORKDIR /mc
COPY start.sh config /mc/
VOLUME /mc
RUN chmod a+x /mc/start.sh
EXPOSE 25565
CMD ["/mc/start.sh"]