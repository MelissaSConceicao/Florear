-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21-Nov-2022 às 00:09
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `floricultura`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `adereco`
--

CREATE TABLE `adereco` (
  `cod_adereco` int(10) NOT NULL,
  `preco_adereco` varchar(10) NOT NULL,
  `tipo_adereco` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `adereco`
--

INSERT INTO `adereco` (`cod_adereco`, `preco_adereco`, `tipo_adereco`) VALUES
(1, '30,00', 'ursinho'),
(2, '40,00', 'bombom');

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamento`
--

CREATE TABLE `agendamento` (
  `id_agendamento` int(10) NOT NULL,
  `horario` varchar(10) NOT NULL,
  `id_pedido` int(10) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `destinatario`
--

CREATE TABLE `destinatario` (
  `cod_destinatario` int(10) NOT NULL,
  `nome_d` text NOT NULL,
  `cidade_d` text NOT NULL,
  `logradouro_d` text NOT NULL,
  `bairro_d` text NOT NULL,
  `numero_d` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `flor`
--

CREATE TABLE `flor` (
  `cod_flor` int(255) NOT NULL,
  `preco` varchar(1000) NOT NULL,
  `especie` text NOT NULL,
  `alergia` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `flor`
--

INSERT INTO `flor` (`cod_flor`, `preco`, `especie`, `alergia`) VALUES
(1, '1,00', 'tulipa', 'polem'),
(2, '2,00', 'orquidea', ''),
(3, '321', 'dawda', 'nao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `cod_fornecedor` int(10) NOT NULL,
  `nome_fornecedor` text NOT NULL,
  `cod_telefone` int(10) NOT NULL,
  `cep_fornecedor` varchar(10) NOT NULL,
  `produto_fornecido` text NOT NULL,
  `cnpj` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`cod_fornecedor`, `nome_fornecedor`, `cod_telefone`, `cep_fornecedor`, `produto_fornecido`, `cnpj`) VALUES
(1, 'wsim', 1, '66666-666', 'placa', '43.222.222/2222-22'),
(2, 'a', 3, '22222-222', 'a', '11.111.111/1111-11'),
(4, 'wad', 9, '32132-132', 'wda', '12.312.312/3123-21');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `matricula` int(110) NOT NULL,
  `nome` text DEFAULT NULL,
  `cpf` text NOT NULL,
  `telefone` int(10) DEFAULT NULL,
  `data` text NOT NULL,
  `senha` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`matricula`, `nome`, `cpf`, `telefone`, `data`, `senha`) VALUES
(1, 'yasmin', '432423', 1, '12/12/2000', 'a'),
(5, '[value-1]', '[value-4]', 0, '[value-5]', '[value-6]'),
(6, 'dawdawdawdaw', '432.423.423-42', NULL, '23/42/3424', 'a'),
(7, 'daw', '341.242.342-34', NULL, '23/42/3423', 'as'),
(8, 'dawdawd', '432.423.423-42', NULL, '23/42/3423', 'a'),
(9, '34534534', '534.534.534-53', 1, '53/45/3453', 'a'),
(10, 'ada', '342.344.244-23', 1, '23/42/3423', 'ada'),
(11, 'e', '233.232.323-23', 1, '32/32/3232', '3232'),
(12, 'dwadaw', '432.423.432-42', 8, '42/34/2342', 'ada'),
(13, 'adwda', '423.423.432-42', 9, '43/24/2342', '2'),
(17, 'awdawd', '234.242.342-34', 14, '42/34/2342', '423423432424'),
(18, 'ada', '423.423.423-42', 15, '41/23/4234', 'ada'),
(19, 'josuel', '555.555.355-45', 16, '12/12/1212', '007'),
(20, 'dawd', '412.312.312-31', 17, '31/23/1231', '312312');

-- --------------------------------------------------------

--
-- Estrutura da tabela `lote`
--

CREATE TABLE `lote` (
  `num_lote` int(10) NOT NULL,
  `quantidade_flores` int(10) NOT NULL,
  `cor_flores` text NOT NULL,
  `cod_fornecedor` int(10) NOT NULL,
  `cod_flor` int(10) NOT NULL,
  `dt_entrega` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `lote`
--

INSERT INTO `lote` (`num_lote`, `quantidade_flores`, `cor_flores`, `cod_fornecedor`, `cod_flor`, `dt_entrega`) VALUES
(1, 3, 'azul', 1, 1, '22'),
(3, 2, 'as', 1, 1, '12'),
(4, 3, 'azul', 1, 1, ''),
(5, 3, 'amarelo', 1, 1, '31/1/2000'),
(6, 3, 'amarelo', 1, 1, '31/1/2000'),
(7, 3, 'amarelo', 1, 1, '31/1/2000'),
(8, 3, 'amarelo', 1, 1, '31/1/2000'),
(9, 3, 'amarelo', 1, 1, '3'),
(10, 3, 'amarelo', 1, 1, '3'),
(11, 3, 'azul', 1, 1, '232'),
(12, 3, 'azul', 1, 1, '232'),
(13, 3, 'azul', 2, 2, '22');

-- --------------------------------------------------------

--
-- Estrutura da tabela `material`
--

CREATE TABLE `material` (
  `id_material` int(10) NOT NULL,
  `cod_fornecedor` int(11) NOT NULL,
  `material` text NOT NULL,
  `cor` text NOT NULL,
  `preco` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `material`
--

INSERT INTO `material` (`id_material`, `cod_fornecedor`, `material`, `cor`, `preco`) VALUES
(1, 1, 'dawwad', 'dawdw', '3,00'),
(2, 2, 'dwa', 'daw', '3,00'),
(3, 2, 'dwa', 'daw', '3,00'),
(4, 1, 'dawdaw', 'addada', '5,00'),
(7, 1, 'dad', 'daaa', '3,00'),
(8, 2, 'dawwad', 'adw', '7,00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(200) NOT NULL,
  `cod_cliente` int(200) NOT NULL,
  `num_produto` int(200) NOT NULL,
  `valor` varchar(1000) NOT NULL,
  `cod_adereco` int(200) NOT NULL,
  `observacao` text DEFAULT NULL,
  `cod_funcionario` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `cod_cliente`, `num_produto`, `valor`, `cod_adereco`, `observacao`, `cod_funcionario`) VALUES
(1, 1, 5, '111111', 2, '', 1),
(4, 5, 3, '2,00', 1, '', 1),
(5, 1, 1, '1', 1, '[value-6]', 1),
(6, 1, 1, '1', 1, '[value-6]', 1),
(8, 1, 1, '1', 1, '[value-6]', 1),
(9, 1, 1, '1', 1, '[value-6]', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `num_produto` int(10) NOT NULL,
  `preco_produto` varchar(10) NOT NULL,
  `cod_flor` int(10) NOT NULL,
  `id_material` int(10) NOT NULL,
  `nome` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`num_produto`, `preco_produto`, `cod_flor`, `id_material`, `nome`) VALUES
(1, '1.00', 1, 2, 'a'),
(2, '1.00', 2, 2, 'a'),
(3, '1.00', 1, 2, 'ca'),
(4, '1.00', 3, 2, 'ca'),
(5, '1,00', 1, 4, 'awdada'),
(6, '2', 1, 1, 'a');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servico_entrega`
--

CREATE TABLE `servico_entrega` (
  `id_entrega` int(10) NOT NULL,
  `id_pedido` int(10) NOT NULL,
  `cod_destinatario` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbclientes`
--

CREATE TABLE `tbclientes` (
  `cod_cliente` int(50) NOT NULL,
  `nome_contato` text NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `telefone_cliente` int(100) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `rua` text NOT NULL,
  `numero` text NOT NULL,
  `responsavel` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbclientes`
--

INSERT INTO `tbclientes` (`cod_cliente`, `nome_contato`, `cpf`, `telefone_cliente`, `cep`, `rua`, `numero`, `responsavel`) VALUES
(1, 'dwa', '543.453.453-45', 1, '53454-353', '534', '645', ''),
(3, 'awd', '123.123.123-12', 9, '23131-231', '3213213', '1323', NULL),
(4, 'laaa', '444.444.444-44', 10, '44444-444', 'a4', '234', NULL),
(5, 'ad5', '222.222.222-22', 12, '57777-777', '555', '555555', ''),
(8, 'aaaaa', '44.444.444/4444-44', 15, '11111-111', '11111', '1111', '2432222222222'),
(12, 'aaaa', '22.222.222/2222-22', 19, '33333-333', '31', '312', 'a'),
(14, 'adw', '32.132.131/2312-32', 21, '32131-312', '3213132', '321312', 'a'),
(15, 'da', '12.331.231/2312-31', 23, '31231-231', 'ad', '123', 'daw');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_cliente`
--

CREATE TABLE `telefone_cliente` (
  `cod_telefone` int(10) NOT NULL,
  `telefone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `telefone_cliente`
--

INSERT INTO `telefone_cliente` (`cod_telefone`, `telefone`) VALUES
(1, '(11) 11111-1111'),
(2, '553'),
(3, '(32) 13123-1231'),
(4, '(13) 12321-3123'),
(5, '(31) 23123-2131'),
(6, '(32) 13123-3123'),
(7, '(31) 23123-2312'),
(8, '(31) 23123-2312'),
(9, '(12) 32131-2312'),
(10, '(44) 44444-4444'),
(11, '(31) 23123-1231'),
(12, '(77) 77777-7777'),
(13, '(44) 44444-4444'),
(14, '(33) 33333-3333'),
(15, '(22) 22222-2222'),
(16, '(  )      -    '),
(17, '(31) 23123-1231'),
(18, '(32) 13213-1231'),
(19, '(33) 33333-3333'),
(20, '(33) 33333-3333'),
(21, '(31) 23123-1231'),
(22, '(34) 12423-4242'),
(23, '(34) 12423-4248');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_fornecedor`
--

CREATE TABLE `telefone_fornecedor` (
  `cod_telefone` int(10) NOT NULL,
  `telefone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `telefone_fornecedor`
--

INSERT INTO `telefone_fornecedor` (`cod_telefone`, `telefone`) VALUES
(1, '(31) 11111-1111'),
(2, '(22) 22222-2222'),
(3, '(22) 22222-2222'),
(4, '(22) 22222-2222'),
(5, '(32) 13123-1231'),
(6, '(32) 13123-1231'),
(7, '(32) 13123-1231'),
(8, '(32) 13123-1231'),
(9, '(23) 13123-1231');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone_funcionario`
--

CREATE TABLE `telefone_funcionario` (
  `cod_telefone` int(10) NOT NULL,
  `telefonec` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `telefone_funcionario`
--

INSERT INTO `telefone_funcionario` (`cod_telefone`, `telefonec`) VALUES
(1, '1352523-4432'),
(2, '(42) 34234-2342'),
(3, '(23) 42342-3423'),
(4, '(23) 42342-3423'),
(5, '(23) 42342-3423'),
(6, '(34) 53453-4534'),
(7, '(23) 42342-3423'),
(8, '(32) 32323-2323'),
(9, '(42) 34234-2342'),
(10, '(42) 34234-2346'),
(11, '(13) 42423-4234'),
(12, '(42) 34234-2342'),
(13, '(42) 34234-2342'),
(14, '(42) 34234-2342'),
(15, '(11) 11111-1111'),
(16, '(12) 35465-7894'),
(17, '(31) 23123-1231');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `adereco`
--
ALTER TABLE `adereco`
  ADD PRIMARY KEY (`cod_adereco`);

--
-- Índices para tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD PRIMARY KEY (`id_agendamento`),
  ADD KEY `id_pedido` (`id_pedido`);

--
-- Índices para tabela `destinatario`
--
ALTER TABLE `destinatario`
  ADD PRIMARY KEY (`cod_destinatario`);

--
-- Índices para tabela `flor`
--
ALTER TABLE `flor`
  ADD PRIMARY KEY (`cod_flor`);

--
-- Índices para tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`cod_fornecedor`),
  ADD KEY `cod_telefone` (`cod_telefone`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`matricula`),
  ADD KEY `funcionario_ibfk_1` (`telefone`);

--
-- Índices para tabela `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`num_lote`),
  ADD KEY `cod_especie` (`cod_flor`),
  ADD KEY `cod_fornecedor` (`cod_fornecedor`);

--
-- Índices para tabela `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id_material`),
  ADD KEY `cod_fornecedor` (`cod_fornecedor`);

--
-- Índices para tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `cod_adereco` (`cod_adereco`),
  ADD KEY `cod_cliente` (`cod_cliente`),
  ADD KEY `num_produto` (`num_produto`),
  ADD KEY `cod_funcionario` (`cod_funcionario`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`num_produto`),
  ADD KEY `cod_flor` (`cod_flor`),
  ADD KEY `id_material` (`id_material`);

--
-- Índices para tabela `servico_entrega`
--
ALTER TABLE `servico_entrega`
  ADD PRIMARY KEY (`id_entrega`),
  ADD KEY `cod_destinatario` (`cod_destinatario`),
  ADD KEY `id_pedido` (`id_pedido`);

--
-- Índices para tabela `tbclientes`
--
ALTER TABLE `tbclientes`
  ADD PRIMARY KEY (`cod_cliente`),
  ADD KEY `telefone_cliente` (`telefone_cliente`);

--
-- Índices para tabela `telefone_cliente`
--
ALTER TABLE `telefone_cliente`
  ADD PRIMARY KEY (`cod_telefone`);

--
-- Índices para tabela `telefone_fornecedor`
--
ALTER TABLE `telefone_fornecedor`
  ADD PRIMARY KEY (`cod_telefone`);

--
-- Índices para tabela `telefone_funcionario`
--
ALTER TABLE `telefone_funcionario`
  ADD PRIMARY KEY (`cod_telefone`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `adereco`
--
ALTER TABLE `adereco`
  MODIFY `cod_adereco` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `agendamento`
--
ALTER TABLE `agendamento`
  MODIFY `id_agendamento` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `destinatario`
--
ALTER TABLE `destinatario`
  MODIFY `cod_destinatario` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `flor`
--
ALTER TABLE `flor`
  MODIFY `cod_flor` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `cod_fornecedor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `matricula` int(110) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `lote`
--
ALTER TABLE `lote`
  MODIFY `num_lote` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `material`
--
ALTER TABLE `material`
  MODIFY `id_material` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `num_produto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `tbclientes`
--
ALTER TABLE `tbclientes`
  MODIFY `cod_cliente` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `telefone_cliente`
--
ALTER TABLE `telefone_cliente`
  MODIFY `cod_telefone` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de tabela `telefone_fornecedor`
--
ALTER TABLE `telefone_fornecedor`
  MODIFY `cod_telefone` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `telefone_funcionario`
--
ALTER TABLE `telefone_funcionario`
  MODIFY `cod_telefone` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`);

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`cod_telefone`) REFERENCES `telefone_fornecedor` (`cod_telefone`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`telefone`) REFERENCES `telefone_funcionario` (`cod_telefone`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `lote`
--
ALTER TABLE `lote`
  ADD CONSTRAINT `lote_ibfk_1` FOREIGN KEY (`cod_flor`) REFERENCES `flor` (`cod_flor`),
  ADD CONSTRAINT `lote_ibfk_2` FOREIGN KEY (`cod_fornecedor`) REFERENCES `fornecedor` (`cod_fornecedor`);

--
-- Limitadores para a tabela `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`cod_fornecedor`) REFERENCES `fornecedor` (`cod_fornecedor`);

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cod_adereco`) REFERENCES `adereco` (`cod_adereco`),
  ADD CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`num_produto`) REFERENCES `produto` (`num_produto`),
  ADD CONSTRAINT `pedido_ibfk_4` FOREIGN KEY (`cod_funcionario`) REFERENCES `funcionario` (`matricula`),
  ADD CONSTRAINT `pedido_ibfk_5` FOREIGN KEY (`cod_cliente`) REFERENCES `tbclientes` (`cod_cliente`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`cod_flor`) REFERENCES `flor` (`cod_flor`),
  ADD CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`id_material`) REFERENCES `material` (`id_material`);

--
-- Limitadores para a tabela `servico_entrega`
--
ALTER TABLE `servico_entrega`
  ADD CONSTRAINT `servico_entrega_ibfk_1` FOREIGN KEY (`cod_destinatario`) REFERENCES `destinatario` (`cod_destinatario`),
  ADD CONSTRAINT `servico_entrega_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`);

--
-- Limitadores para a tabela `tbclientes`
--
ALTER TABLE `tbclientes`
  ADD CONSTRAINT `tbclientes_ibfk_1` FOREIGN KEY (`telefone_cliente`) REFERENCES `telefone_cliente` (`cod_telefone`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
