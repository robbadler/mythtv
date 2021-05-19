FROM ubuntu:18.04


ARG MYTHTV_VERSION
ENV APACHE_LOG_DIR=/var/log/apache2 \
    DEBIAN_FRONTEND=noninteractive \
    LANG=en_US.UTF-8 \
    LANGUAGE=en_US.UTF-8 \
    LC_ALL=en_US.UTF-8 \
    LD_LIBRARY_PATH=/usr/local/lib \
    TZ=UTC

ARG SSH_PORT=2022
ARG MYTHWEB_PORT=6760

#RUN apt-get update \
#  && apt-get install -y --no-install-recommends \
#     software-properties-common
 
RUN  echo "export LANG=$LANG" >> /etc/environment \
  && echo "export LANGUAGE=$LANGUAGE >> /etc/environment \
  && echo "export LC_ALL=$LC_ALL >> /etc/environment \
  && echo "export TZ=$TZ >> /etc/environment \
  && echo "export APACHE_LOG_DIR=$APACHE_LOG_DIR >> /etc/environment \
  && apt-get -yq update \
  && apt-get install -y --no-install-recommends \
    gnupg locales software-properties-common wget \
  && add-apt-repository ppa:mythbuntu/${MYTHTV_VERSION} \
  && add-apt-repository ppa:x2go/stable \
  && apt-get -yq update \
  && locale-gen $LANG \
  && apt-get install -y --no-install-recommends \
    apache2 \
    curl \
    hdhomerun-config \
    libhdhomerun-dev \
    iproute2 \
    iputils-ping \
    less \
    libmyth-python \
    lsb-release \
    mariadb-client \
    mythtv-backend \
    mythtv-common \
    mythtv-transcode-utils \
    mythweb \
    net-tools \
    openssh-client \
    openssh-server \
    php-mythtv \
    psmisc \
    sudo \
    tzdata \
    v4l-utils \
    vim \
    w3m \
    x11-utils \
    x2goserver-xsession \
    xauth \
    xmltv \
    xterm \
  && apt-get install -y --no-install-recommends \
    make g++ \
  && cd /tmp/ \
  && wget http://download.silicondust.com/hdhomerun/libhdhomerun_20201023.tgz \
  && tar -zxvf libhd*.tgz && rm libhd*.tgz \
  && cd libhd* \
  && make \
  && cp libhdhomerun.so /usr/local/lib/libhdhomerun.so.4 \
  && cp hdhomerun_config /usr/local/bin/ \
  && apt-get remove -y make g++ && echo && echo maybe run apt autoremove && echo && echo \
  && rm -rf /var/lib/apt/lists/* \
  && OLD_UID=$(id -u mythtv) \
  && echo $OLD_UID \
  && OLD_GID=$(id -g mythtv) \
  && usermod -u 1002 mythtv \
  && groupmod -g 1002 mythtv \
  && find /home/mythtv -group $OLD_GID -exec chgrp -h mythtv {} \; \
  && find /home/mythtv -user $OLD_UID -exec chown -h mythtv {} \;



COPY src/ /root/

  #&& echo "root:Docker!" | chpasswd 
RUN sed -i -e "s/\#\?Port 22/Port $SSH_PORT/" /etc/ssh/sshd_config \
  && sed -i -e "s/Listen 80/Listen $MYTHWEB_PORT/" /etc/apache2/ports.conf \
  && echo "mythtv:mythtv" | chpasswd \
  && mv /root/mythweb.conf /root/mythweb-settings.conf \
    /etc/apache2/sites-available/ \
  && usermod \
    --shell /bin/bash \
    -a -G users,mythtv,adm,sudo \
    mythtv \
  && chown -R mythtv /var/log/mythtv \
  && rm /home/mythtv/.mythtv/config.xml \
  && mkdir -p /usr/local/bin \
  && for f in /usr/bin/myth* ; do \
       ln -s $f /usr/local/bin/ ;\
     done \
  && cat /etc/apache2/ports.conf


#RUN set -i "s/PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/sshd_config \
#  && mkdir -p /tmp/.X11-unix && chmod 1777 /tmp/.X11-unix \
#  && mkdir -p /var/run/dbus

EXPOSE \
  $MYTHWEB_PORT \
  $SSH_PORT \
  3306 \
  5000/udp \
  5000/udp \
  5002/udp \
  5004/udp \
  5901 \
  6543 \
  6543 \
  6544 \
  6544 \
  6549 \
  65001 \
  65001/udp 

VOLUME $APACHE_LOG_DIR
ENTRYPOINT ["/root/entrypoint.sh"]

