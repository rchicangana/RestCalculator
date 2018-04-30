#Usamos el jboss/Wildfly image
FROM jboss/wildfly

#Desplegamos el war
ADD RestCalcultator-1.0.0.war /opt/jboss/wildfly/standalone/deployments/
