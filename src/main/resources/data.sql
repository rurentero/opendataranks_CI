-- Datos base para la tabla Dataset
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A1', 'Farolas de caceres', 'Gratis', 'Farolas');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A2', 'Calles de caceres', 'Gratis', 'Calles');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A3', 'Barrios de caceres', 'Gratis', 'Barrios');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A4', 'Aplicaciones privadas', 'Reducido', 'Private Apps');

-- Datos base para la tabla Reuse
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R1', 'Juego de fútbol', 'Head Soccer', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R2', 'Catastro: App de farolas', 'Catastro Farolas', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R3', 'Catastro: App de Calles', 'Catastro Calles', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R4', 'Catastro completo con todos los datasets', 'Catastro Completo', 'Application');

-- Datos sobre las relaciones entre dataset_reuse
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A1', 'R4');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A1', 'R2');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A2', 'R4');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A2', 'R3');
INSERT INTO `opendataranks_db`.`dataset_reuse` (`id_dataset`, `id_reuse`) VALUES ('A3', 'R4');
