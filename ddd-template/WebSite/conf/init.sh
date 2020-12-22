#!/bin/bash
rm -rf /usr/share/nginx/html/*
cp -r /app/html/. /usr/share/nginx/html
cp /app/nginx.conf /etc/nginx/nginx.conf
#echo "cp finish"
nginx
tail -f /dev/null