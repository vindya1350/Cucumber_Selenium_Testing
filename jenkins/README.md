# Jenkins Training

##

Note that this is just a basic jenkins image containing everything everything to try out jenkins with automation scripts.
It would not be considered good practice to set things up this way and is only for the purposes of training and learning the basics of how jenkins works

It contains:
* jenkins instance (no nodes)
* chrome - latest version at time of image build
* open-jdk-17 where java is used
* standard jenkins plugins

## Build Docker Image
docker build -f dockerfile-jenkinsmaster -t jenkins-master .

## Run docker Image
docker run -p 9080:8080 -p 50000:50000 --name jenkins-master --group-add 0 -d -v //var/run/docker.sock:/var/run/docker.sock --env JENKINS_ADMIN_USERNAME= --env JENKINS_ADMIN_PASSWORD= --env OKTA_DOMAIN= --env OKTA_BACKEND_SECRET= --env OKTA_BACKEND_CLIENTID= --env OKTA_FRONTEND_CLIENTID= jenkins-master

* JENKINS_ADMIN_USERNAME - admin user for jenkins
* JENKINS_ADMIN_PASSWORD - admin password for jenkins
* OKTA_DOMAIN  - okta domain for the application authentication
* OKTA_BACKEND_SECRET - okta backend client secret for the jupiter toys application
* OKTA_BACKEND_CLIENTID - okta backend client id for the jupiter toys application
* OKTA_FRONTEND_CLIENTID - okta frontend client id for the jupiter toys application

The jenkins user details will be the login credentials for jenkins and the other environment variables will be setup in jenkins as secrets
