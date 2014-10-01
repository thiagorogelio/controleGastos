CREATE TABLE IF NOT EXISTS `gastos` (
  `mes` int(2) NOT NULL,
  `descricao` varchar(30) NOT NULL,
  `valor` double NOT NULL,
  `necessário` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
