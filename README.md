 # ######################################## # 
 # ####### API para Sistema Medico ######## #
 # ######################################## #
 
 # ####### Instalação ######## #

Faze inicial

    1- Baixe o repositorio no link abaixo
        https://github.com/IVictorOli/sismed


    Descompacte o arquivo sismed-main.zip no diretório:
        C:\Users\<nome_do_usuario> \Documents\workspace-spring-tool-suite-4-4.27.0.RELEASE

Criação e configuração do banco.
    No PostgreSQL crie o Banco: sismed
    Restaure o arquivo: sismed.sql no banco sismed recém-criado

Opcional
    O Instalados Offline de Repositórios:
    baixe o arquivo InstaladorOffLine.exe no repositório:
     https://github.com/IVictorOli/Drive
    instale o programa na pasta: C:\Users\<nome_do_usuario>\.m2

Importando o projeto
    Importe o projeto sismed que esta na pasta  workspace-spring-tool-suite-4-4.27.0.RELEASE para 
    sua Dev Suite (Preferencialmente Eclipse ou Spring Tools Suit)

Configurando banco
    Configure corretamente os dados do seu banco no arquivo:
        sismed-main\src\main\resources\application.properties
    Dados a serem alterado:
        spring.datasource.url=jdbc:postgresql://localhost:5432/sismed
        spring.datasource.username=seuusuario
        spring.datasource.password=suasenha

Salve as alterações

Force um Update Mavem Project
    Inicie a scr/main/java/com.sismed.api.SismedApplication.java como um Spring Boot App
    Verifique possíveis logs de erro

 # ####### Uso da Api com Swagger ######## #


 1- Controller Paciente
 
 POST Paciente: insira um nome, cpf, data nascimento, contato, email.
 id sera gerada altomaticamente ao enviar a requisicao
 
 GET Pacientes: gera uma lista de todos os pacientes registrados, lista estara em branco
 caso nao existam pacientes

 DELETE PacientesID: deleta o paciente inserindo a UUID

 PUT PacientesID: edita os dados de um paciente pela ID

 GET PacientesID: pesquisa os dados do paciente pela UUID


 2- Controller Medico
 
 POST Medico: insira um nome, especialidade, crm, email.
 id sera gerada altomaticamente ao enviar a requisicao
 
 GET Medico: gera uma lista de todos os medicos registrados, lista estara em branco
 caso nao existam Medicos

 DELETE MedicoID: deleta o Medico inserindo a UUID

 PUT MedicoID: edita os dados de um Medico pela ID

 GET MedicoID: pesquisa os dados do Medico pela UUID


 3- - Controller Consulta
 
 POST Consulta: A primeira ID é para Consulta (Nao preencher), insira o a ID do Medico,
 ID do Paciente, Status da Consulta e Data da Consulta.
 id sera gerada altomaticamente ao enviar a requisicao
 
 GET Consulta: gera uma lista de todas as Consultas registradas, lista estara em branco
 caso nao existam Consultas

 DELETE ConsultaID: deleta a Consulta inserindo a UUID

 PUT ConsultaID: edita os dados da Consulta, Para Alterar o Medico/Paciente Basta colocar
 outra ID ou inserir a anterior para nao mudar,
 
 GET ConsultaID: pesquisa os dados da Consulta pela UUID


# ####### Links uteis ######## #

 # swagger
 Pagina de teste com swagger
 http://localhost:8080/swagger-ui/index.html

