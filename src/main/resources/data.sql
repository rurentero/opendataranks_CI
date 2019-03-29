-- Datos base para la tabla Tag
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T1', 'Administracion');
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T2', 'Gobierno');
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T3', 'Videojuegos');
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T4', 'Caceres');

-- Datos base para la tabla Organization
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O1', 'Todo para la descripcion de APIs', 'Swagger');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O2', 'Prueba de APIs', 'PostmanOrg');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O3', 'Gobierno de Francia', 'Gobierno de Francia');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O4', 'Gobierno de España', 'Gobierno de España');

-- Datos base para la tabla Dataset
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A1', 'Farolas de caceres', 'Gratis', 'Farolas', 'O4');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A2', 'Calles de caceres', 'Gratis', 'Calles', 'O4');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A3', 'Barrios de caceres', 'Gratis', 'Barrios', 'O4');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A4', 'Aplicaciones privadas', 'Reducido', 'Private Apps');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A5', 'Ciudades de Francia', 'Gratis', 'Ciudades de Francia', 'O3');


-- Datos base para la tabla Reuse
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R1', 'Juego de fútbol', 'Head Soccer', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R2', 'Catastro: App de farolas', 'Catastro Farolas', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R3', 'Catastro: App de Calles', 'Catastro Calles', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`, `organization_id`) VALUES ('R4', 'Catastro completo con todos los datasets', 'Catastro Completo', 'Application', 'O4');

-- Datos sobre las relaciones entre dataset_reuse
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A1', 'R4');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A1', 'R2');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A2', 'R4');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A2', 'R3');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A3', 'R4');

-- Datos sobre las relaciones Dataset - Tag
INSERT INTO `opendataranks_db`.`dataset_tag` (`id_dataset`, `id_tag`) VALUES ('A1', 'T4');
INSERT INTO `opendataranks_db`.`dataset_tag` (`id_dataset`, `id_tag`) VALUES ('A2', 'T4');
INSERT INTO `opendataranks_db`.`dataset_tag` (`id_dataset`, `id_tag`) VALUES ('A3', 'T4');
INSERT INTO `opendataranks_db`.`dataset_tag` (`id_dataset`, `id_tag`) VALUES ('A4', 'T3');

-- Datos sobre las relaciones Reuse - Tag
INSERT INTO `opendataranks_db`.`reuse_tag` (`id_reuse`, `id_tag`) VALUES ('R2', 'T4');
INSERT INTO `opendataranks_db`.`reuse_tag` (`id_reuse`, `id_tag`) VALUES ('R3', 'T4');
INSERT INTO `opendataranks_db`.`reuse_tag` (`id_reuse`, `id_tag`) VALUES ('R4', 'T4');
INSERT INTO `opendataranks_db`.`reuse_tag` (`id_reuse`, `id_tag`) VALUES ('R1', 'T3');
INSERT INTO `opendataranks_db`.`reuse_tag` (`id_reuse`, `id_tag`) VALUES ('R2', 'T1');
INSERT INTO `opendataranks_db`.`reuse_tag` (`id_reuse`, `id_tag`) VALUES ('R3', 'T1');

