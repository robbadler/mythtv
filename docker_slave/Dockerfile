FROM ubuntu:16.04

RUN apt-get update \
  && apt-get install -y --no-install-recommends \
     software-properties-common 

ARG MYTHTV_VERSION
RUN add-apt-repository ppa:mythbuntu/${MYTHTV_VERSION}


RUN apt-get update \
  && apt-get install -y --no-install-recommends \
     mythtv-backend

RUN OLD_UID=$(id -u mythtv) \
  && echo $OLD_UID \
  && OLD_GID=$(id -g mythtv) \
  && usermod -u 1002 mythtv \
  && groupmod -g 1002 mythtv \
  && find /home/mythtv -group $OLD_GID -exec chgrp -h mythtv {} \; \
  && find /home/mythtv -user $OLD_UID -exec chown -h mythtv {} \;


RUN ln -s -f /etc/mythtv/config.xml \
             /home/mythtv/.mythtv/config.xml


RUN apt-get install -y --no-install-recommends \
    locales \
  && locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

RUN apt-get install -y --no-install-recommends \
    iproute2

RUN apt-get install -y --no-install-recommends \
    iputils-ping

ARG SSH_PORT=2022

RUN apt-get install -y --no-install-recommends \
    mariadb-client \
    openssh-server \
    openssh-client

RUN sed -i -e "s/Port 22/Port $SSH_PORT/" /etc/ssh/sshd_config \
  &&  echo "mythtv:mythtv" | chpasswd


RUN apt-get install -y --no-install-recommends \
    x11-utils xauth x11-apps

RUN apt-get install -y --no-install-recommends \
    vim

RUN usermod \
    --shell /bin/bash \
    -a -G users,mythtv,adm,sudo \
    mythtv

RUN echo "root:Docker!" | chpasswd

ENV DEBIAN_FRONTEND noninteractive

RUN add-apt-repository ppa:x2go/stable \
  && apt-get update -y \
  && apt-get install -y x2goserver-xsession
RUN set -i "s/PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/sshd_config \
  && mkdir -p /tmp/.X11-unix && chmod 1777 /tmp/.X11-unix \
  && mkdir -p /var/run/dbus


EXPOSE $SSH_PORT 5000/udp 6543 6544 6522 3306 5901
COPY entrypoint.sh /root/entrypoint.sh

RUN chown -R mythtv /var/log/mythtv
RUN rm /home/mythtv/.mythtv/config.xml

RUN mkdir -p /usr/local/bin \
  && for f in /usr/bin/myth* ; do \
     ln -s $f /usr/local/bin/ ;\
     done

#USER mythtv
ENTRYPOINT ["/root/entrypoint.sh"]
