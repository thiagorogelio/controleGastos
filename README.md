Universidade Estadual de Maringá,
Departamento de Informática
Inteligência Artificial II
prof: Wagner Igarashi

--------------------------------------------------------------------------------------------------

Aplicativo de controle de gastos pessoais, utilizando lógica fuzzy.

Desenvolvido por:

	Thiago Rogelio Ramos


* Instalação:

1. Você deverá ter um banco de dados mysql instalado em seu computador:

$ apt-get install mysql-server

2. Crie uma database controle
3. Insira a tabela 'gastos', o esquema encontra-se dentro da pasta controleGastos, com o nome de schema.sql
4. Configure os dados de seu servidor na classe bd.Conection

serverName = "localhost"; 
mydatabase = "controle";
username = "root";
password = "";

5. Limpe e construa o projeto, ou execute o jar localizado em dist/  // Necessário Java 7 ou superior.
