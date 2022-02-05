# Observability

Observability in ECP is provided though a standard process using leveraging multiple components.Various ECP components ship log information to a centralized searchable index with visualization and analytics.

## Core Technologies for Log Management

| Function | Component | Description|
| - | - | - |
| Search Index | Elasticsearch | Centralized searchable log data |
| Log Data Pipeline | Logstash | Data processing pipeline including transformation.  This log data is routed to the search index through this pipeline.|
| Visualization and Analytics | Splunk ||
| Tracing | Zipkin ||

## Folder structure

For more information on folder content check its README file.

* ```./Zipkin``` Zipkin service for tracing.
* ```./Elasticsearch``` Elasticshearch index.
* ```./Logstash``` Logstash.
