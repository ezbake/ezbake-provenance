# Provenance Service

## Description
The Provenance service is a Thrift service that allows applications to register documents by URI, associate those documents to age off rules,
and record the relationship between an original document and documents with information derived from the original document.
Additionally, applications can define age off rules (really just a description of the retention time for a class of data) so that
the platform can track what application data should be aged-off.

## Maven dependency

```xml
<dependency>
    <groupId>ezbake</groupId>
    <artifactId>provenance-service</artifactId>
    <version>2.0-SNAPSHOT</version>
</dependency>
```

## ezCentos test/deployment settings

buildpacks/provenance-service/config/app.properties

```ini
# redis key to generate ids
provenance.id.generator.key=provenance-id-generator
# max size to add documents in batch
provenance.adddocuments.maxsize=500

# accumulo
storage.backend=com.thinkaurelius.titan.diskstorage.accumulo.AccumuloStoreManager
storage.tablename=provenance

#elastic search
storage.index.search.backend=elasticsearch
storage.index.search.client-only=true
storage.index.search.index-name=provenance
storage.index.search.sniff=false
```

buildpacks/provenance-service/provenance-service-manifest.yml

```ini
Application:
  name: common_services
  datasets: []
  security_id: 12345
  auths: []
  Services:
    -
      type: DataSet
      language: Java
      service_name: EzProvenanceService
      database: Titan
      resources:
        cpu: small
        mem: small
        disk: small
      scaling:
        number_of_instances: 1
      artifact_info:
        bin: /vagrant/ezbakejars/provenance-service-2.0-SNAPSHOT-jar-with-dependencies.jar
        config: []
```

Provenance service also requires ezgroups service running
To setup a buildpack for the ezgroups service:

buildpacks/groups/conf/app.properties

```ini
storage.backend=com.thinkaurelius.titan.diskstorage.accumulo.AccumuloStoreManager
storage.tablename=ezgroups
ezbake.groups.service.x509.restrict=false
```

buildpacks/groups/groups-manifest.yml

```ini
Application:
  name: common_services
  datasets: []
  security_id: 12345
  auths: []
  Services:
    -
      type: DataSet
      language: Java
      service_name: ezgroups
      database: Titan
      resources:
        cpu: small
        mem: small
        disk: small
      scaling:
        number_of_instances: 1
      artifact_info:
        bin: /vagrant/ezbakejars/ezbake-groups-service-2.0-SNAPSHOT-thrift-runnable.jar
        config: []
```

To make EzProvenanceService Admin for ezgroups service, modify the EzbakeClient object in /vagrant/scripts/users.json

```ini
 "CN=EzbakeClient, OU=42six, O=CSC, C=US": {
         "name": "Ezbake Client",
         "uid": "EzbakeClient.1234567890",
         "authorizations": {
             "auths":["A", "B", "C"],
             "citizenship":"USA",
             "level":"low",
             "organization": "EzBake"
         },
         "groups": {
         "_Ez_internal_project_" : [
                "_Ez_administrator"
            ],
             "EzBake": [
                 "Core",
                 "Frack"
             ]
         },
         "communities": [{
             "communityName": "community",
             "communityType": "community",
             "organization": "EzBake",
             "topic":["t1"],
             "region":["r1"],
             "groups":[]
         }]
     },
```

To start the service

```shell
cd /vagrant
sudo scripts/startHadoop.sh
sudo scripts/startAccumulo.sh
sudo service elasticsearch start
sudo scripts/startService.sh groups
sudo scripts/startService.sh provenance-service
```

