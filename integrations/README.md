# Integrations

ECP integrations are built in a service-oriented architecture using the Apache Camel open source integration framework. Camel provides a high-degree of flexibility in meeting integration and data distribution needs, is well-supported and widely used.  

For more information on Apache Camel see <https://camel.apache.org/>

## Folder structure

Each integration is implemented in Camel and runs as a stand-alone application. Integrations may contain one or more routes.

* ```./open511events-ghostcms``` Updates GhostCMS based website with recent Open511 API events.
* ```./drivebc-api-proxy``` Proxy of the DriveBC API.
* ```./health-checks``` Example project from Camel to ensure build process is working. This can be removed as integrations are established.
