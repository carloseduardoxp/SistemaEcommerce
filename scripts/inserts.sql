use dbecommerce;
INSERT INTO `TB_CLIENTE` VALUES ('1','Maria Anders','Sales Representative','Obere Str. 57','Berlin','12209','Germany');

INSERT INTO TB_PEDIDO VALUES (6,now(),'NOVO',1);
INSERT INTO TB_PEDIDO VALUES (2,now(),'CANCELADO',1);
INSERT INTO TB_PEDIDO VALUES (3,now(),'FATURADO',1);
INSERT INTO TB_PEDIDO VALUES (4,now(),'ENTREGUE',1);
INSERT INTO TB_PEDIDO VALUES (5,now(),'NOVO',1);


INSERT INTO TB_TELEFONE VALUES ('1','98858965','CELULAR',1);
INSERT INTO TB_TELEFONE VALUES ('2','12312313','RESIDENCIAL',1);

INSERT INTO `TB_CATEGORIA` VALUES (1,'Bebidas','Bebidas leves como cafés, chás, cervejas'),(2,'Molhos e Condimentos','Molhos e Condimentos'),(3,'Padaria','bolos, torradas, pães, doces'),(4,'Frios e Laticínios','Queijos, frios, patês'),(5,'Mercearia','Conservas, sopas, cremes, salgadinhos'),(6,'Carne, Avícula e Peixes','Carnes bovinas, carnes suínas, carnes de aves, peixes'),(7,'Higiene e Perfumaria','Produtos de Higiene e Perfumaria'),(8,'Vinho e espumante','Vinhos, vinhos finos, champagnes');

INSERT INTO `TB_PRODUTO` VALUES (1,'Chopp e Pêssego DRAFT & FRUIT','chopp_pessego.jpg',1.99,39,1),(2,'Chá com Pêssego','cha_pessego.jpg',1.70,17,1);

INSERT INTO TB_DETALHE_PEDIDO VALUES (1,2,0.5,1.8,3),(2,2,0.1,2.1,5);