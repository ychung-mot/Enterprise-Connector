FROM logstash:7.16.3

EXPOSE 8001
EXPOSE 8002

COPY logstash.yml /usr/share/logstash/config/logstash.yml
COPY pipelines.yml /usr/share/logstash/config/pipelines.yml
COPY kong_logstash.conf /usr/share/logstash/pipeline/kong_logstash.conf
COPY kamel_logstash.conf /usr/share/logstash/pipeline/kamel_logstash.conf


