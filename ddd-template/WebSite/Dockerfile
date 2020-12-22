From nginx:latest
#COPY ./dist /usr/share/nginx/html
#COPY ./conf/nginx.conf /etc/nginx/nginx.conf
COPY ./dist /app/html
COPY ./conf/nginx.conf /app/nginx.conf
COPY ./conf/init.sh /app/run.sh
ENTRYPOINT ["nohup","/app/run.sh","&"]
CMD [ "" ]
#ENTRYPOINT ["nginx","-g","daemon off"]