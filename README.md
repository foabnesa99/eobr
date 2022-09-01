Database init script:

``CREATE SCHEMA `eobrazovanje` ;
CREATE USER 'eobr-admin'@'%' IDENTIFIED BY 'eobrazovanje123';
GRANT ALL PRIVILEGES ON eobrazovanje.* TO 'eobr-admin'@'%';``
