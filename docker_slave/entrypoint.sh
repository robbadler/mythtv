#!/usr/bin/env bash

service ssh start
for retry in $(seq 1 10); do
  while killall -0 mythtv-setup; do sleep 5; done
  su mythtv "-c /usr/bin/mythbackend -v jobqueue,general --logpath=/var/log/mythtv --noupnp" || echo Unexpected exit retry=$retry
  sleep 60
done