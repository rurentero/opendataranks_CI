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
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O5', 'Gobierno de Suecia', 'Gobierno de Suecia');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O6', 'Gobierno de Suiza', 'Gobierno de Suiza');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O7', 'Gobierno de Italia', 'Gobierno de Italia');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O8', 'Gobierno de Marruecos', 'Gobierno de Marruecos');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O9', 'Gobierno de Alemania', 'Gobierno de Alemania');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O10', 'Gobierno de Bélgica', 'Gobierno de Bélgica');
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O11', 'Gobierno de Rusia', 'Gobierno de Rusia');

-- Datos base para la tabla Dataset
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A1', 'Farolas de caceres', 'Gratis', 'Farolas', 'O4');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A2', 'Calles de caceres', 'Gratis', 'Calles', 'O4');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A3', 'Barrios de caceres', 'Gratis', 'Barrios', 'O4');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A4', 'Aplicaciones privadas', 'Reducido', 'Private Apps');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`, `organization_id`) VALUES ('A5', 'Ciudades de Francia', 'Gratis', 'Ciudades de Francia', 'O3');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A6', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A7', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A8', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A9', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A10', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A11', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A12', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A13', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A14', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A15', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A16', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A17', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A18', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A19', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A20', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');
INSERT INTO `opendataranks_db`.`dataset` (`id`, `description`, `license`, `title`) VALUES ('A21', 'Dataset prueba paginacion', 'Gratis', 'Prueba Paginacion');

-- Datos base para la tabla Reuse
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R1', 'Juego de fútbol', 'Head Soccer', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R2', 'Catastro: App de farolas', 'Catastro Farolas', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R3', 'Catastro: App de Calles', 'Catastro Calles', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`, `organization_id`) VALUES ('R4', 'Catastro completo con todos los datasets', 'Catastro Completo', 'Application', 'O4');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R5', 'Prueba paginacion', 'Reuse Prueba paginacion', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R6', 'Prueba paginacion', 'Reuse Prueba paginacion', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R7', 'Prueba paginacion', 'Reuse Prueba paginacion', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R8', 'Prueba paginacion', 'Reuse Prueba paginacion', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R9', 'Prueba paginacion', 'Reuse Prueba paginacion', 'Application');
INSERT INTO `opendataranks_db`.`reuse` (`id`, `description`, `title`, `type`) VALUES ('R10', 'Prueba paginacion', 'Reuse Prueba paginacion', 'Application');

-- Ponderaciones para la tabla Weight

INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W1', '0.33', 'Balanceado', '0.33', '0.33');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W2', '1', 'Solo descargas', '0', '0');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W3', '0', 'Solo comentarios', '1', '0');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W4', '0', 'Solo puntuacion', '0', '1');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W5', '0.5', 'Descargas el doble', '0.25', '0.25');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W6', '0.25', 'Comentarios el doble', '0.5', '0.25');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W7', '0.25', 'Puntuacion el doble', '0.25', '0.5');


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


-- Puntuaciones manuales de prueba, al menos una por defecto para cada reuso
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('100', 'W2', 'R1');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('30', 'W3', 'R1');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('60', 'W4', 'R1');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('100', 'W1', 'R1');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('90', 'W1', 'R2');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('80', 'W1', 'R3');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('70', 'W1', 'R4');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('60', 'W1', 'R5');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('50', 'W1', 'R6');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('40', 'W1', 'R7');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('30', 'W1', 'R8');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('20', 'W1', 'R9');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('10', 'W1', 'R10');

