-- Datos base para la tabla Tag [Ojo: La tabla Tag ya no tiene campo "name"]
/*
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T1', 'Administracion');
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T2', 'Gobierno');
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T3', 'Videojuegos');
INSERT INTO `opendataranks_db`.`tag` (`id`, `name`) VALUES ('T4', 'Caceres');
*/

-- Datos base para la tabla Organization
/*
INSERT INTO `opendataranks_db`.`organization` (`id`, `description`, `title`) VALUES ('O1', 'Descripcion de APIs', 'Swagger');
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
*/

-- Datos base para la tabla Dataset
/*
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
*/
-- Ponderaciones para la tabla Weight

INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W1', '0.33', '(0.33-0.33-0.33) Balanceado', '0.33', '0.33');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W12', '1', '(1-0-0) Solo descargas', '0', '0');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W13', '0', '(0-1-0) Solo comentarios', '1', '0');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W14', '0', '(0-0-1) Solo puntuacion', '0', '1');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W15', '0.5', '(0.5-0.25-0.25) Descargas el doble', '0.25', '0.25');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W16', '0.25', '(0.25-0.5-0.25) Comentarios el doble', '0.5', '0.25');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W17', '0.25', '(0.25-0.25-0.5) Puntuacion el doble', '0.25', '0.5');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W18', '0.5', '(0.5-0.33-0.16) Mayor a menor DCP', '0.33', '0.16');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W19', '0.5', '(0.5-0.33-0.16) Mayor a menor DPC', '0.16', '0.33');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W20', '0.33', '(0.5-0.33-0.16) Mayor a menor PDC', '0.16', '0.5');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W21', '0.33', '(0.5-0.33-0.16) Mayor a menor CDP', '0.5', '0.16');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W22', '0.16', '(0.5-0.33-0.16) Mayor a menor CPD', '0.5', '0.33');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W23', '0.16', '(0.5-0.33-0.16) Mayor a menor PCD', '0.33', '0.5');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W24', '0.66', '(0.66-0.17-0.17) Mayor: D', '0.17', '0.17');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W25', '0.17', '(0.66-0.17-0.17) Mayor: C', '0.66', '0.17');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W26', '0.17', '(0.66-0.17-0.17) Mayor: P', '0.17', '0.66');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W27', '0.66', '(0.66-0.33-0) D > C', '0.33', '0');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W28', '0.66', '(0.66-0.33-0) D > P', '0', '0.33');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W29', '0.33', '(0.66-0.33-0) C > D', '0.66', '0');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W30', '0.33', '(0.66-0.33-0) P > D', '0', '0.66');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W31', '0', '(0.66-0.33-0) P > C', '0.33', '0.66');
INSERT INTO `opendataranks_db`.`weight` (`id`, `downloads_val`, `name`, `reviews_num_val`, `score_val`) VALUES ('W32', '0', '(0.66-0.33-0) C > P', '0.66', '0.33');
/*
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
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('10', 'W2', 'R1');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('20', 'W2', 'R2');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('30', 'W2', 'R3');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('40', 'W2', 'R4');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('50', 'W2', 'R5');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('60', 'W2', 'R6');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('70', 'W2', 'R7');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('80', 'W2', 'R8');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('90', 'W2', 'R9');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('100', 'W2', 'R10');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('11', 'W3', 'R1');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('22', 'W3', 'R2');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('33', 'W3', 'R3');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('44', 'W3', 'R4');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('55', 'W3', 'R5');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('66', 'W3', 'R6');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('77', 'W3', 'R7');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('88', 'W3', 'R8');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('99', 'W3', 'R9');
INSERT INTO `opendataranks_db`.`reuse_weight` (`value`, `weight_id`, `reuse_id`) VALUES ('99', 'W3', 'R10');

-- Puntuaciones manuales de prueba, al menos una por defecto para cada dataset
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('10', 'W1', 'A1');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('20', 'W1', 'A2');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('30', 'W1', 'A3');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('40', 'W1', 'A4');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('50', 'W1', 'A5');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('60', 'W1', 'A6');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('70', 'W1', 'A7');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('80', 'W1', 'A8');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('90', 'W1', 'A9');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('100', 'W1', 'A10');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('22', 'W2', 'A1');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('33', 'W3', 'A1');
INSERT INTO `opendataranks_db`.`dataset_weight` (`value`, `weight_id`, `dataset_id`) VALUES ('44', 'W4', 'A1');
*/

